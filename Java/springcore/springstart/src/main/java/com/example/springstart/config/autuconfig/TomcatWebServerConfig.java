package com.example.springstart.config.autuconfig;

import com.example.springstart.config.ConditionalMyOnClass;
import com.example.springstart.config.MyAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {

    @Bean("tomcatWebServerFactory")
    public ServletWebServerFactory servletWebServerFactory() {

        return new TomcatServletWebServerFactory();
    }
}
