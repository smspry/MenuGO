package MenuGO.DBAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class IngredientAccess extends DBAccess{

    public void addIngredient(ArrayList<String> data){
        String sql = "insert into Ingredient(" +
                "ingredient_name, category)" +
                "values (?, ?)";
        buildAndExecutePrepared(data, sql);
    }

    public int countRecords() {
        return super.countRecords("Ingredient");
    }

    /** Adapted from softeng
     * Call this to update the database with the required paramaters
     *
     * @param unit, the unit of  you want to edit
     * @param field, the column of the table you want to edit
     * @param data, the data you want to put in
     */
    public void updateIngredient(String unit, String field, String data) {
        String sql = "update Quantity set " + field + "= ? where unit= ?;";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, data);
            pstmt.setString(2, unit);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        IngredientAccess na = new IngredientAccess();
        ArrayList<String> strings = new ArrayList<String>();
        //strings.add("salt");
        //strings.add("condiments");
        //na.addIngredient(strings);
        System.out.println(na.countRecords());
    }
}
