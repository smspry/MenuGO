package DBAccess;

import java.sql.*;
import java.util.ArrayList;

@SuppressWarnings({"UnnecessaryCallToStringValueOf", "SqlResolve"})
public abstract class DBAccess {
    /**
     * Connect to the db database
     * Andrew made this
     * @return the Connection object
     */
    public Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:DB/DBMenuGo.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    /**
     * creates a prepared statement
     * @param con, Connection
     * @param sql, the sql string of code
     * @param data, the data we want to change
     * @return PreparedStatement
     * @throws SQLException, More info
     */
    public PreparedStatement createPreparedStatement(Connection con, String sql, ArrayList<String> data) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, data.get(0));
        pstmt.setInt(2, Integer.parseInt(data.get(1)));
        pstmt.setInt(3, Integer.parseInt(data.get(2)));
        pstmt.setString(4, data.get(3));
        pstmt.setString(5, data.get(4));
        pstmt.setString(6, data.get(5));
        pstmt.setString(7, data.get(6));
        pstmt.setString(8, data.get(7));
        return pstmt;
    }

}