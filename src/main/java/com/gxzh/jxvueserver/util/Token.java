package com.gxzh.jxvueserver.util;


import io.jsonwebtoken.*;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Token {
    public static String tokenvalue="";

    private static String SECRET_KEY="jiangxijiangxijiangxijiangxijiangxijiangxijiangxi";

    public static String generateToken(String username, String password, Date expiration) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("password", password);
        Date now = new Date();
        tokenvalue= Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .compact();
        return tokenvalue;
    }




}
