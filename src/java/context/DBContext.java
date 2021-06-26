
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * DBContext class<br>
 *
 * <pre>
 * This class will be proceed below

 * </pre>

 */
public class DBContext {

    /**
     * Store the server name.<br>
     */
    private final String serverName = "localhost";
    /**
     * Store the database name.<br>
     */
    private final String dbName = "photo1";
    /**
     * Store the port number.<br>
     */
    private final String portNumber = "1433";
    /**
     * Store the userID.<br>
     */
    private final String userID = "sa";
    /**
     * Store the password.<br>
     */
    private final String password = "sa";

    /**
     * Get connection of your database.<br>
     *
     * @return connection
     * @throws Exception
     */
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    /**
     * When you are done with using your connection , you need to close in order
     * to release any other database resources .
     *
     * @param ps PreparedStatement
     * @throws Exception
     */
    public void closePreparedStatement(PreparedStatement ps) throws Exception {
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
    }

    /**
     * When you are done with using your connection , you need to close in order
     * to release any other database resources .
     *
     * @param con Connection
     * @throws Exception
     */
    public void closeConnection(Connection con) throws Exception {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    /**
     * When you are done with using your connection , you need to close in order
     * to release any other database resources .
     *
     * @param rs ResultSet
     * @throws Exception
     */
    public void closeResultSet(ResultSet rs) throws Exception {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
    }

}
