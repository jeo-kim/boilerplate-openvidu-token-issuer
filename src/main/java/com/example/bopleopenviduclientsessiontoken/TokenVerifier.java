package com.example.bopleopenviduclientsessiontoken;


import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class TokenVerifier {

    @Value("1234")
    public String secretKey;

    public Jws<Claims> validateToken(String jwtToken) {

        Jws<Claims> claims = null;
        try {
            claims = Jwts.parser().setSigningKey("1234").parseClaimsJws(jwtToken);
            log.info("claims: {}", claims.toString());
            return claims;
        } catch (UnsupportedJwtException|MalformedJwtException|SignatureException|IllegalArgumentException e) {
            throw new JwtException(e.getMessage());
        }  catch (ExpiredJwtException e) {
            throw new ExpiredJwtException(null, null, "Jwt Expired !!");
        }

    }




}