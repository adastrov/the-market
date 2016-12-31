package market.pavelpadalka.u.com.gitlab.controller.listener;

import market.pavelpadalka.u.com.gitlab.helper.ApplicationContext;
import market.pavelpadalka.u.com.gitlab.holder.AppPropertiesHolder;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

@WebListener
public class ContextListener implements ServletContextListener{

    private static AppPropertiesHolder propertiesHolder = AppPropertiesHolder.getInstance();

    public void contextInitialized(ServletContextEvent servletContextEvent) {

        File createDBScriptFile        = getFileFromURL(propertiesHolder.getDatabaseStructureCreationScript());
        File insertDataIntoDBScriptUrl = getFileFromURL(propertiesHolder.getDatabaseStructureCreationScript());

        ApplicationContext.init(createDBScriptFile);
        ApplicationContext.init(insertDataIntoDBScriptUrl);

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    private File getFileFromURL(String path) {

        URL url = ContextListener.class.getClassLoader().getResource(path);

        File result;

        try {
            result = new File(url.toURI());
        } catch (URISyntaxException e) {
            result = new File(url.getPath());
        }

        return result;

    }

}
