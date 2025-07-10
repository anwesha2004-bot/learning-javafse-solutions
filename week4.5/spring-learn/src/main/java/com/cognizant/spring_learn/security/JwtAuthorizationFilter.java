package com.cognizant.spring_learn.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthorizationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        LOGGER.info("Start JWT filter");

        String header = request.getHeader("Authorization");
        LOGGER.debug("Authorization Header: {}", header);

        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(header);
        if (authentication != null) {
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
        LOGGER.info("End JWT filter");
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String header) {
        try {
            String token = header.replace("Bearer ", "");
            Jws<Claims> jws = Jwts.parser()
                    .setSigningKey("secretkey")
                    .parseClaimsJws(token);
            String user = jws.getBody().getSubject();
            LOGGER.debug("User from token: {}", user);
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
        } catch (JwtException e) {
            LOGGER.error("Invalid JWT token", e);
        }
        return null;
    }
}

