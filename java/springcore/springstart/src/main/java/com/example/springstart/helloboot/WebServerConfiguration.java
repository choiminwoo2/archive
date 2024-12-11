package com.example.springstart.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration(proxyBeanMethods = false)
public class WebServerConfiguration {
    //@Bean
    ServletWebServerFactory customerWebServerFactory(){
        TomcatServletWebServerFactory servletFactory = new TomcatServletWebServerFactory();
        servletFactory.setPort(9090);
        return servletFactory;
    }

}
