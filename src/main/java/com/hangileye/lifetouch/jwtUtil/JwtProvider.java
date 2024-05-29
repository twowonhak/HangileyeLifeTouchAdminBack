package com.hangileye.lifetouch.jwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Duration;
import java.util.Date;

@Log4j2
@Component
public class JwtProvider {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.token-validity-in-minutes}")
    private int durationOfMinutes;

    @Value("${jwt.token-validity-in-hours}")
    private int durationOfHours;



    /*
        JWT 토큰 생성
        subject : accessToken or refreshToken
        userId : 사용자 아이디
     */

    public String createJwtToken(String subject, String userId) {

        log.info("JwtProvider createJwtToken : {} {}",subject, "START");
        log.info("JwtProvider secretKey : {}", secretKey);
        Date now = new Date();
        Date expiration = new Date();

        expiration = new Date(now.getTime() + Duration.ofHours(durationOfHours).toMillis()); // 만료기간 1시간

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE) // (1)
                .setId(userId)
                .setIssuer(userId) // 토큰발급자(iss) 사용자 아이디
                .setIssuedAt(now) // 발급시간(iat)
                .setExpiration(expiration) // 만료시간(exp)
                .setSubject(subject) //  토큰 제목(subject)
                .signWith(getSignKey())
                .compact();
    }


    /* jwt 토큰의 유효성 체크 메소드 */
    public Jws<Claims> parseJwtToken(String token) {
        log.info("[JWT] parseJwtToken data {}", token);
        token = BearerRemove(token); // Bearer 제거
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token);
    }

    /* 토큰 앞 부분('Bearer') 제거 메소드 */
    private String BearerRemove(String token) {
        if(token.contains("Bearer ")){
            return token.substring("Bearer ".length());
        }
        return token;
    }

    private Key getSignKey(){
        log.info("getSignKey " + secretKey);
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }





}