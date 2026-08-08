package com.cibertec.semana5.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static com.cibertec.semana5.security.Constants.*;

@Configuration
public class JWTAuthenticationConfig {
    public String getJWTToken(String usuario, String nombre, String apellido) {
        List<GrantedAuthority> authorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER,ROLE_ADMIN");

        String token = Jwts.builder()
                .setId("Miguel")
                .setSubject(usuario)
                .claim("nombre", nombre)
                .claim("apellido", apellido)
                .claim("authorities", authorities.stream()
                        .map(GrantedAuthority::getAuthority)
                        .toArray())
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_SECONDS))
                .signWith(getSigninKey(Constants.SECRET_TEXT), SignatureAlgorithm.HS256)
                .compact();

        return TOKEN_PREFIX + token;
    }

    public Claims decodeToken(String token){
        Claims claims = Jwts.parser().setSigningKey(getSigninKey(SECRET_TEXT))
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }
}
