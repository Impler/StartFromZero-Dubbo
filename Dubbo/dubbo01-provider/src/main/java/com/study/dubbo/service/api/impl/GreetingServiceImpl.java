package com.study.dubbo.service.api.impl;
import com.study.dubbo.service.api.GreetingsService;

public class GreetingServiceImpl implements GreetingsService {

  @Override
  public String sayHi(String name) {
    System.out.println("hello: " + name);
    return "hello: " + name;
  }
}
