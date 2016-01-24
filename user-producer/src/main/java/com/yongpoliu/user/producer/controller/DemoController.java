package com.yongpoliu.user.producer.controller;

import com.google.common.collect.Lists;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class DemoController {

  private static final List<Integer> BIG_INT_ARRAY = initBigIntArray();

  @RequestMapping(path = "/demo", method = RequestMethod.GET)
  public String demo() {
    try {
      TimeUnit.MILLISECONDS.sleep(100);
    } catch (InterruptedException e) {
      //模拟请求等待
    }
    return "Producer Application";
  }

  @RequestMapping(path = "/bigIntArray", method = RequestMethod.GET)
  public List<Integer> getBigIntArray() {
    try {
      TimeUnit.MILLISECONDS.sleep(100);
    } catch (InterruptedException e) {
      //模拟请求等待
    }
    return BIG_INT_ARRAY;
  }

  private static List<Integer> initBigIntArray() {
    List<Integer> array = Lists.newArrayList();
    for (int i = 0; i < 1000000; i ++) {
      array.add(i);
    }
    return array;
  }
}
