package DBAccess;

import Models.Quantity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    public static void main(String[] args) {
        QuantityAccess na = new QuantityAccess();
    }
}
