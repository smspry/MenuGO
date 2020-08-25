package MenuGO.DBAccess;

import java.sql.*;
import java.util.ArrayList;

public class QuantityAccess extends DBAccess{

    public void addQuantity(ArrayList<String> data){
        String sql = "insert into Quantity(" +
                "unit)" +
                "values (?)";
        buildAndExecutePrepared(data, sql);
    }

    public int countRecords() {
        return super.countRecords("Quantity");
    }

    public ArrayList<String> getAllQuantities() {
        String sql = "SELECT * FROM Quantity";
        int count = 0;
        //noinspection Convert2Diamond
        ArrayList<String> data = new ArrayList<String>();
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                    data.add(rs.getString("unit"));
            }
            return data;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static void main(String[] args) {
        QuantityAccess na = new QuantityAccess();
        ArrayList<String> items = na.getAllQuantities();
        System.out.println(items);
    }
}
