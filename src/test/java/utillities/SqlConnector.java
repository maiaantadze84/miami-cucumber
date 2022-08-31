package utillities;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.sql.*;

;

public class SqlConnector {
    private static final String userName = ReadConfigFiles.getPropertyValues("DbUser");
    private static final String password = ReadConfigFiles.getPropertyValues("DbPassword");
    public static final String databaseName = ReadConfigFiles.getPropertyValues("DbName");
    public static final String Url = String.format("jdbc:postgresql://localhost:5432/mortgage_calculator", databaseName);

    private static final Logger LOGGER = (Logger) LogManager.getLogger(SqlConnector.class);

    /**
     * Connect to the postgres SQL database
     * @return a connection object
     */

    private static Connection connect() {
       Connection conn = null;
       try {
           conn = DriverManager.getConnection(Url,userName,password);
           LOGGER.info("Successfully connected to the Database");
       }catch (SQLException e) {
           LOGGER.error("SQL Connection Exception: " + e.getMessage());
       }
       return conn;
    }

    /**
     * Reading Data from the Database
     * @param sqlQuery is the method parameter to pass the SQL Query
     * @return a ResultSet Object
     * @throws SQLException
     */

    public static ResultSet readData(String sqlQuery) throws SQLException {
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = connect();
           Statement stmt = conn.createStatement();
           rs = stmt.executeQuery(sqlQuery);
        } catch (SQLException e){
            LOGGER.error("SQL ResultSet Exception:" + e.getMessage());
        } finally {
            conn.close();
        }
        return rs;
    }
}
