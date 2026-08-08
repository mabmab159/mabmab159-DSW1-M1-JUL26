package com.cibertec.semana5.security;

import io.jsonwebtoken.*;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

import static com.cibertec.semana5.security.Constants.*;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    private Claims setSigningKeys(HttpServletRequest request) {
        String jwtToken = request.getHeader(HEADER_AUTHORIZATION).replace(Constants.TOKEN_PREFIX, "");
        return Jwts.parserBuilder().setSigningKey(getSigninKey(SECRET_TEXT)).build().parseClaimsJws(jwtToken).getBody();
    }

    private void setAuhentication(Claims claims) {
        List<String> authorities = claims.get("authorities", List.class);
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(),
                null, authorities.stream().map(SimpleGrantedAuthority::new).toList());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    private boolean isJwtValid(HttpServletRequest request) {
        String authHeader = request.getHeader(HEADER_AUTHORIZATION);
        return authHeader != null && authHeader.startsWith(Constants.TOKEN_PREFIX);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            if (isJwtValid(request)) {
                Claims claims = setSigningKeys(request);
                if (claims.get("authorities") != null) {
                    setAuhentication(claims);
                } else {
                    SecurityContextHolder.clearContext();
                }
            } else {
                SecurityContextHolder.clearContext();
            }
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
        }
    }
}
