package com.study.dubbo;

import com.study.dubbo.service.api.GreetingsService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;

public class ConsumerAPIApp {

  public static void main(String[] args) {

    RegistryConfig registryConfig = new RegistryConfig("zookeeper://192.168.32.10:2181");
    registryConfig.setTimeout(10000);

    ReferenceConfig<GreetingsService> rc = new ReferenceConfig<>();
    rc.setInterface(GreetingsService.class);
    rc.setRegistry(registryConfig);

    ApplicationConfig ac = new ApplicationConfig("simple-consumer");
    ac.setQosPort(33333);

    DubboBootstrap boot = DubboBootstrap.getInstance();
    boot.application(ac).start();
    GreetingsService greetingsService = rc.get();
    greetingsService.sayHi("Tom");
  }
}
