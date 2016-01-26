package com.yongpoliu.user.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private String name;

  private long id;
}
