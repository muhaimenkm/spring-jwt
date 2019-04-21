package com.kraftlabs.security.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

@Component
public class JWTFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("JWTFilter");
		HttpServletRequest request = (HttpServletRequest) req;
		String authorization = request.getHeader("authorization");

		if (authorization == null || !authorization.startsWith("Token "))
			throw new ServletException("401 - UNAUTHORIZED");
		try {
			Claims claims = Jwts.parser().setSigningKey("123456").parseClaimsJws(authorization.substring(6)).getBody();
			request.setAttribute("claims", claims);
		} catch (final SignatureException e) {
			throw new ServletException("401 - UNAUTHORIZED");
		}
		chain.doFilter(req, res);
	}

}
