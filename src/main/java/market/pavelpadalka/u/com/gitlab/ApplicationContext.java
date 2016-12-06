package market.pavelpadalka.u.com.gitlab;

import market.pavelpadalka.u.com.gitlab.datasource.DataSource;
import market.pavelpadalka.u.com.gitlab.holder.AppPropertiesHolder;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class ApplicationContext {

    private static DataSource dataSource = DataSource.getInstance();
    private static AppPropertiesHolder propertiesHolder = AppPropertiesHolder.getInstance();

    public static void init() {

        executeBatchQuery(propertiesHolder.getDatabaseStructureCreationScript());
        executeBatchQuery(propertiesHolder.getDatabaseDataInsertScript());

    }

    private static void executeBatchQuery(String query) {

        Connection connection = dataSource.createConnection();

        LinkedList<String> queriesForBatch = getQueriesForBatch(query);

        try {

            Statement statement = connection.createStatement();

            for (String currentQuery : queriesForBatch) {
                statement.addBatch(currentQuery);
            }

            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static LinkedList<String> getQueriesForBatch(String fileName)  {

        StringBuilder sb = new StringBuilder();
        LinkedList<String> stringLinkedList = new LinkedList<String>();

        try {

            BufferedReader in = new BufferedReader(new FileReader(fileName));

            try {

                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");

                    if(s.contains(";")) {
                        stringLinkedList.add(sb.toString());
                        sb.delete(0, sb.length());
                    }

                }
            } finally {
                in.close();
            }

        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        return stringLinkedList;

    }

}
