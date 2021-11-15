package com.hyy.controller;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hyy.pojo.User;
import com.hyy.service.UserService;
import com.hyy.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HuangSir
 * @date 2021-11-13 17:55
 */
@RestController
@Slf4j
public class UserController {
   @Autowired
   private UserService userService;

   @GetMapping("/user/login")
   public Map<String, Object> login(User user) {
      log.info("用户名：{}", user.getName());
      log.info("密码：{}", user.getPassword());
      HashMap<String, Object> res = new HashMap<>();
      try {
         User login = userService.login(user);
         HashMap<String, String> payload = new HashMap<>();
         payload.put("userId", login.getId() + "");
         payload.put("userName", login.getName() + "");
         String token = JwtUtils.getToken(payload);
         res.put("state", true);
         res.put("msg", "登陆成功");
         res.put("token", token);
      } catch (Exception e) {
         res.put("state", false);
         res.put("msg", e.getMessage());
      }
      return res;
   }

   //用户想要访问服务器上的某一个资源
   @GetMapping("/getSth")
   public Map<String, Object> getSth(String token) {
      //我们现在只需要专注于业务的实现即可
      HashMap<String, Object> res = new HashMap<String, Object>();
      res.put("msg", "登陆成功！");
      res.put("state", true);
      return res;
   }
}
