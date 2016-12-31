package market.pavelpadalka.u.com.gitlab.helper;

import market.pavelpadalka.u.com.gitlab.datasource.DataSource;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ApplicationContext {

    private static DataSource dataSource = DataSource.getInstance();

    public static void init(File file) {

        String[] queriesForBatch = getQueriesForBatch(file);

        executeBatchQuery(queriesForBatch);

    }

    private static void executeBatchQuery(String[] queriesForBatch ) {

        Connection connection = dataSource.createConnection();

        try {

            Statement statement = connection.createStatement();

            for (String currentQuery : queriesForBatch) {
                statement.addBatch(currentQuery);
            }

            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }

    }

    private static String[] getQueriesForBatch(File file) {

        String[] queriesStringArray;
        StringBuilder incomeFileData = new StringBuilder();

        try {

            Scanner scanner = new Scanner(new FileReader(file));

            while (scanner.hasNext()) {
                incomeFileData.append(scanner.next()).append(" ");
            }

            scanner.close();

            queriesStringArray = incomeFileData.toString().split(";");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return queriesStringArray;

    }

    private static void closeConnection(Connection connection) {

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
