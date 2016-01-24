package com.yongpoliu.user.producer.controller;

import com.yongpoliu.user.api.dto.User;
import com.yongpoliu.user.api.service.UserService;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceImpl implements UserService {

  @Override
  public User getById(Long id) {
    return new User("uic center", id);
  }
}
