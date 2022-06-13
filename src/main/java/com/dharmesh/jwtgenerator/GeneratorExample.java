package com.dharmesh.jwtgenerator;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.Random;

public class GeneratorExample {


    public static void main(String[] args) {

        Instant now = Instant.now();

        // todo: need to create a secret key
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String secStr = Encoders.BASE64.encode(key.getEncoded());
        byte[] sec = Base64.getDecoder().decode(secStr);
        String jwt = Jwts.builder()
                .setSubject("Dharmesh Vazarkar")
                .setAudience("JWT Gen Demo")
                .claim("1d20", new Random().nextInt(20)+1)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(1, ChronoUnit.MINUTES)))
                .signWith(Keys.hmacShaKeyFor(sec))
                .compact();

        System.out.println(jwt);
    }
}
