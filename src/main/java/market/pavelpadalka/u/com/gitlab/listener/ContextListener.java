package market.pavelpadalka.u.com.gitlab.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener{
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // ApplicationContext.init();
        System.out.println("contextInitialized");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("contextDestroyed");
    }
}
