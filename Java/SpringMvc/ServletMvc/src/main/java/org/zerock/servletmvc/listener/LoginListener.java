package org.zerock.servletmvc.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import lombok.extern.log4j.Log4j2;

@WebListener(value = "good")
@Log4j2
public class LoginListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {

        String name = event.getName();

        Object obj = event.getValue();

        if (name.equals("loginInfo")) {
            log.info("A user logined..................");
            log.info(obj);
        }
    }
}
