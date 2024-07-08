package com.scm.configs;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RedirectAuthenticatedUserFilter extends HttpFilter {

    @Override
    protected void doFilter(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain chain
    ) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (
            authentication != null
            && authentication.isAuthenticated()
            &&  (request.getRequestURI().equals("/login") || request.getRequestURI().equals("/register"))
        ) {
            response.sendRedirect("/users/profile");
        
            return;
        }

        chain.doFilter(request, response);
    }
}
