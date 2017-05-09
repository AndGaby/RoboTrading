package br.com.robotrading.web.filters;

import java.io.IOException;

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
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String url = httpServletRequest.getServletPath();
		Cliente user = (Cliente) httpServletRequest.getSession().getAttribute("user");
		
		System.out.println(url);
		
		if (user == null) {
			httpServletRequest.setAttribute("msg", 
					"Favor efetuar o login para continuar!");
			httpServletResponse.sendRedirect("/");
		//	httpServletRequest.getRequestDispatcher("/").forward(httpServletRequest, httpServletResponse);
		}else{
			chain.doFilter(httpServletRequest, httpServletResponse);
		}
	}

	@Override
	public void destroy() {
		System.out.println("Finishing Filter!");
	}

}