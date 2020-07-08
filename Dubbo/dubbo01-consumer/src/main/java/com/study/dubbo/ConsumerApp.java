package com.study.dubbo;

import com.study.dubbo.service.api.GreetingsService;
import java.io.IOException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerApp {

  public static void main(String[] args) throws IOException {
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("consumer.xml");
    GreetingsService demoService = (GreetingsService) ctx.getBean("demoService");
    System.out.println(demoService.sayHi("Tom"));
    System.in.read();
  }
}
