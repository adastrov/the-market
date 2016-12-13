package market.pavelpadalka.u.com.gitlab.controller.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("Session was created");
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("Session was destroyed");
    }
}
