package com.hyy.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyy.utils.JwtUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @author HuangSir
 * @date 2021-11-15 19:03
 */
public class JwtInterceptor implements HandlerInterceptor {
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      //从请求头中获取token
      String token = request.getHeader("token");
      HashMap<String, Object> res = new HashMap<>();
      try {
         JwtUtils.verify(token);
         //验证通过直接放行
         return  true;
      } catch (TokenExpiredException e) {
         res.put("state", false);
         res.put("msg", "Token已经过期!!!");
      } catch (SignatureVerificationException e){
         res.put("state", false);
         res.put("msg", "签名错误!!!");
      } catch (AlgorithmMismatchException e){
         res.put("state", false);
         res.put("msg", "加密算法不匹配!!!");
      } catch (Exception e) {
         e.printStackTrace();
         res.put("state", false);
         res.put("msg", "无效token~~");
      }
      String json = new ObjectMapper().writeValueAsString(res);
      response.setContentType("application/json;charset=UTF-8");
      response.getWriter().println(json);
      return  false;
   }
}
