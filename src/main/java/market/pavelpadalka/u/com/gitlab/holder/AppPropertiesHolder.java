package market.pavelpadalka.u.com.gitlab.holder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppPropertiesHolder {

    private static volatile AppPropertiesHolder instance;

    private static String driverName;
    private static String databaseURL;
    private static String databaseUser;
    private static String databasePassword;
    private static String databaseStructureCreationScript;
    private static String databaseDataInsertScript;

    private AppPropertiesHolder() {
    }

    public static AppPropertiesHolder getInstance() {
        if (instance == null) {
            synchronized (AppPropertiesHolder.class) {
                if (instance == null)
                    instance = new AppPropertiesHolder();
                    setConnectionSettings();
            }
        }
        return instance;
    }

    private static void setConnectionSettings() {

        try {

            InputStream inputStream = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("application.properties");

            Properties property = new Properties();
            property.load(inputStream);

            driverName       = property.getProperty("db.driver");
            databaseURL      = property.getProperty("db.url");
            databaseUser     = property.getProperty("db.user");
            databasePassword = property.getProperty("db.password");

            databaseStructureCreationScript = property.getProperty("db.databaseStructureCreationScript");
            databaseDataInsertScript        = property.getProperty("db.databaseDataInsertScript");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getDriverName() {
        return driverName;
    }

    public String getDatabaseURL() {
        return databaseURL;
    }

    public String getDatabaseUser() {
        return databaseUser;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public String getDatabaseStructureCreationScript() {
        return databaseStructureCreationScript;
    }

    public String getDatabaseDataInsertScript() {
        return databaseDataInsertScript;
    }
}
