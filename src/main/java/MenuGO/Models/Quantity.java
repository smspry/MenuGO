package MenuGO.Models;

public class Quantity {

    private String unit;
    private Float amount;



    public Quantity(String unit, Float amount) {
        this.unit = unit;
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
