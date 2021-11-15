package com.hyy.service.impl;

import com.hyy.dao.UserMapper;
import com.hyy.pojo.User;
import com.hyy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HuangSir
 * @date 2021-11-13 17:50
 */
@Service
public class UserServiceImpl  implements UserService {
   @Autowired
   private UserMapper userMapper;

   @Override
   public User login(User user) {
      User login = userMapper.login(user);
      //如果用户名或密码错误则查不到用户
      if (login==null) throw  new RuntimeException("用户名或密码错误！");
      return login;
   }
}
