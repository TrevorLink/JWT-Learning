package com.hyy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author HuangSir
 * @date 2021-11-13 15:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
   private  Integer id;
   private  String name;
   private  String password;
}
