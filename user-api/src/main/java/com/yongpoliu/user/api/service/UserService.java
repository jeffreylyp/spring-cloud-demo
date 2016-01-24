package com.yongpoliu.user.api.service;

import com.yongpoliu.user.api.dto.User;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户中心服务接口
 */
@FeignClient("User-Service-Producer")
public interface UserService {

  @RequestMapping(value = "/getById", method = RequestMethod.GET)
  User getById(@RequestParam("id")  Long id);
}
