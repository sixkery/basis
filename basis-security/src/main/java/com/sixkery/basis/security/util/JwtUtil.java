package com.sixkery.basis.security.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.Date;

/**
 * JWT 生成解析
 *
 * @author sixkery
 * @date 2020/10/27
 */
public class JwtUtil {

    /**
     * 设置过期时间 24 hour
     */
    private static final int EXPIRE_TIME = 24 * 60 * 1000;
    /**
     * 自己设定的密钥
     */
    private static final String SECRET = "SIXKERY";

    /**
     * token 的前缀
     */
    private static final String TOKEN_PREFIX = "Bearer ";
    /**
     * 表头授权
     */
    private static final String AUTHORIZATION = "Authorization";


    /**
     * 根据用户名创建 token
     *
     * @param username 用户名
     * @return token
     */
    private static String generateToken(String username) {
        Calendar calendar = Calendar.getInstance();
        // 设置签发时间
        calendar.setTime(new Date());
        calendar.add(Calendar.SECOND, EXPIRE_TIME);
        Date expiration = calendar.getTime();
        // 生成 token
        String jwt = Jwts.builder()
                .setIssuer("sixkery")
                .setIssuedAt(new Date())
                .claim("username", username)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();

        // jwt 前面一般都会加 Bearer
        return TOKEN_PREFIX + jwt;
    }

    /**
     * 校验token是否正确
     *
     * @param token  密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String username, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
}
