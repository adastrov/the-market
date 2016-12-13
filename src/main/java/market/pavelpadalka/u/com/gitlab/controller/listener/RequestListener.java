package market.pavelpadalka.u.com.gitlab.controller.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener{

    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("requestDestroyed");
    }

    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("requestInitialized");
    }
}
