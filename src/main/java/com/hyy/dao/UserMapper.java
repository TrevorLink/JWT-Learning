package com.hyy.dao;

import com.hyy.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author HuangSir
 * @date 2021-11-13 17:46
 */
@Repository
public interface UserMapper {
   //根据传递的用户名和密码进行登录
   User login(User user);
}
