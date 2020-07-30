//package com.sixkery.authentication;
//
//import com.blinkframework.security.portal.properties.JwtProperties;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//import java.util.Base64;
//import java.util.Date;
//
///**
// * JWT工厂，创建JWT
// *
// * @author maoning
// */
//public class JwtFactory {
//
//    private JwtProperties properties;
//
//    private JwtFactory(JwtProperties properties) {
//        this.properties = properties;
//    }
//
//    public static JwtFactory newInstance() {
//        return newInstance(new JwtProperties());
//    }
//
//    public static JwtFactory newInstance(JwtProperties properties) {
//        return new JwtFactory(properties);
//    }
//
//    public String create(String username) {
//        String base64EncodeKey = Base64.getEncoder()
//                .encodeToString(this.properties.getSecretKey().getBytes());
//        return Jwts.builder()
//                .setIssuer(this.properties.getIssuer())
//                .setIssuedAt(new Date())
//                .claim("username", username)
//                .setExpiration(new Date(System.currentTimeMillis() + (this.properties.getExpire() * 1000)))
//                .signWith(SignatureAlgorithm.HS256, base64EncodeKey)
//                .compact();
//    }
//}
