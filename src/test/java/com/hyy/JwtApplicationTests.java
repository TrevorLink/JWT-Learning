package com.hyy;

import com.hyy.dao.UserMapper;
import com.hyy.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JwtApplicationTests {

   @Autowired
   private UserMapper userMapper;
   @Test
   void contextLoads() {
   }
@Test
   public  void testMybatis(){
   System.out.println(userMapper.login(new User(null, "admin", "123456")));
}
}
