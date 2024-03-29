package com.letcode.SecureBankSystem.config;


import com.letcode.SecureBankSystem.service.auth.CustomUserDetailService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Configuration
public class JWTAuthFilter extends OncePerRequestFilter {
    private static final String BEARER = "Bearer ";
    private final JWTUtil jwtUtil;

    private final CustomUserDetailService userDetailService;

    public JWTAuthFilter(JWTUtil jwtUtil, CustomUserDetailService userDetailService) {
        this.jwtUtil = jwtUtil;
        this.userDetailService = userDetailService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if(!request.getServletPath().equals("/api/v1/login")
                && authorizationHeader
                != null && authorizationHeader.startsWith(BEARER)){
            String token = authorizationHeader.substring(7);
            if(jwtUtil.isTokenValid(token)){
                String username = jwtUtil.getUsernameFromToken(token);
                if (username == null){
                    throw  new UsernameNotFoundException("user not found");
                }
                UserDetails userDetails = userDetailService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request,response);
    }

}