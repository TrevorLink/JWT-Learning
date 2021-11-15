package com.hyy.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sun.org.apache.regexp.internal.RE;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HuangSir
 * @date 2021-11-13 18:04
 */
public class JwtUtils {
   //不可以让别人知道的唯一的私钥
   private static final String KEY="nnmmb";

   /**
    * 根据用户传入的payload自动生成Token
    * 默认有效期是7天
    * @param payload map载荷 < String,String >
    * @return 生成的token
    */
   public static  String getToken(Map<String,String> payload){
      Calendar instance = Calendar.getInstance();
      instance.add(Calendar.DATE,7);
      //使用JWT.create创建JWT
      JWTCreator.Builder builder = JWT.create();
      payload.forEach((k,v)->{
         builder.withClaim(k,v);
      });
      builder.withExpiresAt(instance.getTime());//设置令牌的过期时间
      return builder.sign(Algorithm.HMAC256(KEY)); //JWT的签名
   }

   /**
    * 验证token并返回payload数据对象
    * 若token失效等错误则抛出异常
    * @param token
    * @return 解码后的Payload数据对象
    */
   public static DecodedJWT verify(String token){
      return JWT.require(Algorithm.HMAC256(KEY)).build().verify(token);
   }

}
