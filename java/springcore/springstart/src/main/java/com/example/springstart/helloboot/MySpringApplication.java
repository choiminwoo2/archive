package com.example.springstart.helloboot;


import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class MySpringApplication {

    public static void run(Class<?> applicationClass, String[] args) {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {

                super.onRefresh();

                ServletWebServerFactory factory = this.getBean(ServletWebServerFactory.class);
                DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
                WebServer webServer = factory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatchServlet", dispatcherServlet)
                        .addMapping("/*");
                });
                webServer.start();
            }
        };
        context.register(applicationClass);
        context.refresh();
    }
}
