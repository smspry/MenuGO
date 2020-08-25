package MenuGO.Models;

import java.util.ArrayList;
import java.util.Date;

public class Menu {
    ArrayList<Meal> meals;
    Date startDate;
    Date endDate;

    public Menu(ArrayList<Meal> meals, Date startDate, Date endDate) {
        this.meals = meals;
        this.startDate = startDate;
        this.endDate = endDate;
    }


}
