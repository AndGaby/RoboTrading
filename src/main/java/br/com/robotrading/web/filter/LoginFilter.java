package br.com.robotrading.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.robotrading.web.model.Cliente;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String url = ((HttpServletRequest) request).getServletPath();
		String method = ((HttpServletRequest) request).getMethod();

		System.out.println(url);
		System.out.println(method);

		Cliente user = (Cliente) ((HttpServletRequest) request).getSession().getAttribute("user");
		chain.doFilter(request, response);
		if (user == null) {
		}

	}

	@Override
	public void destroy() {

	}
}