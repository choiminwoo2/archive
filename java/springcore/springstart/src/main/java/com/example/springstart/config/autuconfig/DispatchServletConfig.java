package com.example.springstart.config.autuconfig;

import com.example.springstart.config.MyAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@MyAutoConfiguration
public class DispatchServletConfig {

    @Bean
    public DispatcherServlet dispatcherServlet() {

        return new DispatcherServlet();
    }
}
