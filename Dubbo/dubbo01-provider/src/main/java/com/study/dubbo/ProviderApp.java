package com.study.dubbo;

import java.io.IOException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderApp {

  public static void main(String[] args) throws IOException {
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("provider.xml");
    System.in.read();
  }
}
