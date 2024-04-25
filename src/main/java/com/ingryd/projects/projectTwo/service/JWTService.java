package com.ingryd.projects.projectTwo.service;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.HashMap;

@Service
public class JWTService {
    private static final String SECRET_KEY = "blahBlahBlahblahblahblahblahblahblblahblahblahblahblahblahah";

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private String createToken() {
        return createFreshToken(new HashMap<>(), userDetails);
    }
}
