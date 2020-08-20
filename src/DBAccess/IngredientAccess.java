package DBAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class IngredientAccess extends DBAccess{

    public void addNode(ArrayList<String> data){
        String sql = "insert into Ingredient(" +
                "ingredient_name, category)" +
                "values (?, ?)";


        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                 pstmt.setString(1, data.get(0));
                 pstmt.setString(2, data.get(1));
                 pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        IngredientAccess na = new IngredientAccess();
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("salt");
        strings.add("condiments");
        na.addNode(strings);
    }
}
