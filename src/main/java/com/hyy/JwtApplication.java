package com.hyy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hyy.dao")
public class JwtApplication {

   public static void main(String[] args) {
      SpringApplication.run(JwtApplication.class, args);
   }

}
