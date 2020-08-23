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

    public void buildAndExecutePrepared(ArrayList<String> data, String sql) {
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < data.size(); i++) {
                pstmt.setString(i+1, data.get(i));
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int countRecords(String tableName) {
        String sql = "select COUNT(*) from " + tableName;
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;

    }

}