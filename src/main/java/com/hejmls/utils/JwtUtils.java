package com.hejmls.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    //密钥
    private static String signKey = "hejian";
    //过期时间
    private static Long expire = 43200000L;
    public static String generateJwt(Map<String,Object> claims){

        String jwt = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256,signKey)//签名算法
                .setExpiration(new Date(System.currentTimeMillis() + expire))//设置有效期
                .compact() ;
        return jwt;
    }

    //
    public static Claims parseJWT(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}
