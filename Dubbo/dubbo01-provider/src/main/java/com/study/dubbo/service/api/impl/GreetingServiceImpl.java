package com.study.dubbo.service.api.impl;

import com.study.dubbo.service.api.GreetingsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreetingServiceImpl implements GreetingsService {

  private static final Logger LOG = LoggerFactory.getLogger(GreetingServiceImpl.class);

  @Override
  public String sayHi(String name) {
    LOG.info("hello: " + name);
    return "hello: " + name;
  }
}
