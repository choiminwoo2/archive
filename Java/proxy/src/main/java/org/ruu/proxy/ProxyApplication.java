package org.ruu.proxy;

import org.ruu.proxy.config.AppV1Config;
import org.ruu.proxy.config.AppV2Config;
import org.ruu.proxy.config.v1_proxy.InterfaceProxyConfig;
import org.ruu.proxy.trace.LogTrace;
import org.ruu.proxy.trace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import({AppV1Config.class, AppV2Config.class})
@Import(InterfaceProxyConfig.class)
@SpringBootApplication(scanBasePackages = "org.ruu.proxy.app")
public class ProxyApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProxyApplication.class, args);
  }

  @Bean
  public LogTrace logTrace(){
    return new ThreadLocalLogTrace();
  }
}
