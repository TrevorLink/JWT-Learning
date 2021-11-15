package com.hyy;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hyy.utils.JwtUtils;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.HashMap;

/**
 * @author HuangSir
 * @date 2021-11-13 14:42
 */
public class JwtTest {
   @Test
   public  void testToken(){
      HashMap<String, Object> map = new HashMap<>();
      Calendar instance = Calendar.getInstance();
      instance.add(Calendar.MINUTE,5);
      //使用JWT.create创建JWT
      String token = JWT.create()
              .withHeader(map)//JWT的header
              .withClaim("userId", 11)//JWT的payload
              .withClaim("userName", "小黄鸭")
              .withExpiresAt(instance.getTime())//设置令牌的过期时间
              .sign(Algorithm.HMAC256("nnmmb")); //JWT的签名
      System.out.println(token);
   }
   @Test
   public  void testVerification(){
      //根据指定算法和私钥获取校验对象
      JWTVerifier verifier = JWT.require(Algorithm.HMAC256("nnmmb")).build();
      //获取JWT解码后对象
      DecodedJWT verify = verifier.verify("要解码的token");
      System.out.println(verify.getClaim("userId").asInt());
      System.out.println(verify.getClaim("userName").asString());
   }
   @Test
   public  void testUtils(){
      HashMap<String, String> payload = new HashMap<>();
      payload.put("userId","11");
      payload.put("userName","小黄鸭");
      String token = JwtUtils.getToken(payload);
      DecodedJWT verify = JwtUtils.verify(token);
      System.out.println(verify.getClaim("userId").asString());
      System.out.println(verify.getClaim("userName").asString());
   }
}
