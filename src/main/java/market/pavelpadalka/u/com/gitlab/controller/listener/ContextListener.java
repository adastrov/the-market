package market.pavelpadalka.u.com.gitlab.controller.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener{
    public void contextInitialized(ServletContextEvent servletContextEvent) {
      //  ApplicationContext.init();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
