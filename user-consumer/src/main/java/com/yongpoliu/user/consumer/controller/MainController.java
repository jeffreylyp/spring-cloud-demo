package com.yongpoliu.user.consumer.controller;

import com.google.common.base.Stopwatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MainController {

  @Value("${spring.application.name}")
  private String appName;

  @Autowired
  @LoadBalanced
  private RestTemplate restTemplate;

  @Autowired
  private LoadBalancerClient loadBalancer;

  @Autowired
  private DiscoveryClient discoveryClient;

  @RequestMapping("/")
  public ServiceInstance lb() {
    ServiceInstance serviceInstance = loadBalancer.choose("User-Service-Producer");
    URI uri =
        loadBalancer
            .reconstructURI(serviceInstance, URI.create("http://User-Service-Producer/demo"));
    log.info("uri is {}", uri);
    return serviceInstance;
  }

  @RequestMapping("/hi")
  public String hi() {
    Stopwatch stopwatch = Stopwatch.createStarted();
    ResponseEntity<String>
        entity =
        restTemplate.getForEntity("http://User-Service-Producer/demo", String.class);
    long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);
    log.warn("request elapsed {} ms", elapsed);
    return "Hello World! from " + entity.getBody();
  }

  @RequestMapping("/ls")
  public List<ServiceInstance> listUserServiceInstance() {
    return discoveryClient.getInstances("User-Service-Producer");
  }
}
