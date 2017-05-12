package br.com.robotrading.web.conf;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import br.com.robotrading.web.filters.LoginFilter;

@Configuration
public class MessageConfig  extends WebMvcConfigurerAdapter {
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		return slr;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}
	
	@Bean
	public FilterRegistrationBean myFilterBean() {
	  final FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
	  filterRegBean.setFilter(loginFilter());
	  filterRegBean.addUrlPatterns("/registros/cliente/*",
			  						"/clientes/account/*",
			  						"/robos/new",
			  						"robos/listar",
			  						"robos/*/edit");
	  filterRegBean.setEnabled(Boolean.TRUE);
	  filterRegBean.setName("loginFilter");
	  filterRegBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
	  
	  return filterRegBean;
	}
	
	@Bean(name = "loginFilter")
	public Filter loginFilter() {
	    return new LoginFilter();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
}
