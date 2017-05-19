package br.com.robotrading.web.filters;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.robotrading.web.model.Cliente;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Initing Filter!");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest servlet = (HttpServletRequest) request;
		Enumeration<String> headerNames = servlet.getHeaderNames();
		String url = ((HttpServletRequest) request).getServletPath();
		String method = ((HttpServletRequest) request).getMethod();

		System.out.println(url);
		System.out.println(method);
		System.out.println(request.getRemoteAddr());

		while (headerNames.hasMoreElements()) {
			String element = headerNames.nextElement();
			System.out.print(element + "  =  ");
			System.out.println(servlet.getHeader(element));
		}
		Cliente user = (Cliente) ((HttpServletRequest) request).getSession().getAttribute("user");
		chain.doFilter(request, response);

		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		if (user == null) {
			httpServletResponse.sendRedirect("/clientes/erro");
		} else {
			chain.doFilter(servlet, httpServletResponse);
		}
		if (url.startsWith("/registros/cliente/")) {

		}
	}

	@Override
	public void destroy() {
		System.out.println("Finishing Filter!");
	}

}