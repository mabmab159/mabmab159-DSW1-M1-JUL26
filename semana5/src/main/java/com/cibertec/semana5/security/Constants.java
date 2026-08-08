package com.cibertec.semana5.security;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;

public class Constants {
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String SECRET_TEXT = "Semana05CibertecSemana05Cibertec";
    public static final long TOKEN_EXPIRATION_SECONDS = 300_000;

    public static Key getSigninKeyB64(String secretText) {
        byte[] keyBytes = Decoders.BASE64.decode(secretText);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public static Key getSigninKey(String secretText) {
        byte[] keyBytes = secretText.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
