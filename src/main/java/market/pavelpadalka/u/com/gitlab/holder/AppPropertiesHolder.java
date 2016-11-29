package market.pavelpadalka.u.com.gitlab.holder;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class AppPropertiesHolder {

    private static volatile AppPropertiesHolder instance;

    private static String driverName;
    private static String databaseURL;
    private static String databaseUser;
    private static String databasePassword;

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

        FileInputStream fileInputStream;
        Properties property = new Properties();

        try {
            fileInputStream = new FileInputStream("src/main/resources/application.properties");
            property.load(fileInputStream);

            driverName       = property.getProperty("db.driver");
            databaseURL      = property.getProperty("db.url");
            databaseUser     = property.getProperty("db.user");
            databasePassword = property.getProperty("db.password");

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



}
