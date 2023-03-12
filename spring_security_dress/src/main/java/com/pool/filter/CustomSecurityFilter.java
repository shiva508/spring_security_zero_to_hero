package com.pool.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.security.password.PasswordEncoderInfo;

//@Component
public class CustomSecurityFilter implements Filter {

	PasswordEncoderInfo passwordEncoderInfo=null;

	public CustomSecurityFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/* security Context holder */
		
		 //SecurityContext context=SecurityContextHolder.createEmptyContext();
		 //Authentication authentication=new TestingAuthenticationToken("Shiva","shiva", "ROLE_USER"); 
		 //context.setAuthentication(authentication);
		 //System.out.println(context.getAuthentication());
		 //SecurityContextHolder.setContext(context);
		//DELEGATE FILTER PROXY
		String encodedPassword=passwordEncoderInfo.customPasswordEncoder("bcrypt");
		System.out.println(encodedPassword);
		 
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		ApplicationContext context=WebApplicationContextUtils.getRequiredWebApplicationContext(fConfig.getServletContext());
		passwordEncoderInfo=(PasswordEncoderInfo) context.getBean("passwordEncoderInfo");
		
	}

}
