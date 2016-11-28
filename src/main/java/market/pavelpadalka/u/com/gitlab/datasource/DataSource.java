package market.pavelpadalka.u.com.gitlab.datasource;

import market.pavelpadalka.u.com.gitlab.holder.AppPropertiesHolder;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {

    private static volatile DataSource instance;
    private static AppPropertiesHolder propertiesHolder = AppPropertiesHolder.getInstance();

    private DataSource() {
    }

    public static DataSource getInstance() {
        if (instance == null) {
            synchronized (DataSource.class) {
                if (instance == null)
                    instance = new DataSource();
            }
        }
        return instance;
    }

    public Connection createConnection() {
        Connection connection = null;

        try {
            Class.forName(propertiesHolder.getDriverName());
            connection = DriverManager.getConnection(propertiesHolder.getDatabaseURL(), propertiesHolder.getDatabaseUser(), propertiesHolder.getDatabasePassword());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

}
