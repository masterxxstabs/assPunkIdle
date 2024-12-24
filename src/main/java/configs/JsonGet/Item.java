package configs.JsonGet;

public class Item {
    private int id;
    private String name;
    private double weight;
    private double price;
    private double energyReturn;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public double getEnergyReturn() {
        return energyReturn;
    }
    public void setEnergyReturn(int energyReturn) {
        this.energyReturn = energyReturn;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name;
    }
}
