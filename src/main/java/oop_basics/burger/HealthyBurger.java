package oop_basics.burger;

/**
 * Created by Vladimir on 07.03.2018.
 */
public class HealthyBurger extends Hamburger {
    private int price;
    private int cornPrice = 4;
    private int avocadoPrice = 5;

    public HealthyBurger() {
        this("Healthy Burger", "Bacon", 15);
    }

    public HealthyBurger(String name, String meat, int price) {
        super(name, "Brown rye", meat,price);
    }

    @Override
    public void showUpPrices() {
        System.out.println("Price of the Healthy Burger: " + super.getBasePrice() + "$");
        System.out.println("Prices of unique additions for Healthy Burger: " + "\n" + "Algae price: " + this.cornPrice + "$" + "\n" + "Avocado price: " + this.avocadoPrice + "$");
    }

    @Override
    public void additions(boolean lettuce, boolean tomato, boolean carrot, boolean cucumber) {
        super.additions(lettuce, tomato, carrot, cucumber);
    }

    public void uniqueAdditions(boolean corn, boolean avocado) {
        if (corn) {
            this.price += this.cornPrice;
        }
        if(avocado) {
            this.price += this.avocadoPrice;
        }
    }

    @Override
    public int getTotalPrice() {
        int price = super.getTotalPrice();
        return this.price + price;
    }

}


