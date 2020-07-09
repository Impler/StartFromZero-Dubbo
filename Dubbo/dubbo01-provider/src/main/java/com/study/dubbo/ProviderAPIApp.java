package com.study.dubbo;


import com.study.dubbo.service.api.GreetingsService;
import com.study.dubbo.service.api.impl.GreetingServiceImpl;
import java.io.IOException;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;

public class ProviderAPIApp {

  public static void main(String[] args) throws IOException {

    ServiceConfig<GreetingsService> sc = new ServiceConfig<>();
    sc.setInterface(GreetingsService.class);
    sc.setRef(new GreetingServiceImpl());

    DubboBootstrap boot = DubboBootstrap.getInstance();
    RegistryConfig registryConfig = new RegistryConfig("zookeeper://192.168.32.10:2181");
    registryConfig.setTimeout(10000);
    boot.application("simple-provider")
        .registry(registryConfig)
        .service(sc).start();

    // 便于查看日志
    Thread.currentThread()
        .setName(Thread.currentThread().getName() + "-" + sc.getExportedUrls().get(0).getPort());

    boot.await();
  }
}
