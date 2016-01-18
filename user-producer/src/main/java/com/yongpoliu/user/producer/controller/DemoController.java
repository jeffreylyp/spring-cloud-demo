package com.yongpoliu.user.producer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class DemoController {

  @RequestMapping(path = "/demo", method = RequestMethod.GET)
  public String demo() {
    try {
      TimeUnit.MILLISECONDS.sleep(100);
    } catch (InterruptedException e) {
      //模拟请求等待
    }
    return "Producer Application";
  }
}
