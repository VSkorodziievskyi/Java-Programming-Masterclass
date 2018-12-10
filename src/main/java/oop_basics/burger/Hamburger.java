package oop_basics.burger;

/**
 * Created by Vladimir on 06.03.2018.
 */
public class Hamburger {
    private String name;
    private String rolltype;
    private String meat;
    private int price;
    private int basePrice;
    private int lettucePrice = 5;
    private int tomatoPrice = 3;
    private int carrotPrice = 2;
    private int cucumberPrice = 4;

    public Hamburger() {
        this("Base Burger", "Casual Bread", "Bacon", 10);
        this.basePrice = this.price;
    }

    public Hamburger(String name, String rolltype, String meat, int price) {
        this.name = name;
        this.rolltype = rolltype;
        this.meat = meat;
        this.price = price;
        this.basePrice = this.price;
    }
    public void showUpPrices() {
        System.out.println("Price of the Base Burger: " + this.basePrice + "$");
        System.out.println("Prices of base additions: " + "\n" + "Tomato price: " + this.tomatoPrice + "$" + "\n" + "Lettuce price: " + this.lettucePrice + "$" + "\n" + "Carrot price: " + this.carrotPrice + "$" + "\n" + "Cucumber price: " + cucumberPrice + "$");
    }

    public void additions(boolean lettuce, boolean tomato, boolean carrot, boolean cucumber) {

        if (lettuce) {
            this.price += this.lettucePrice;
        }
        if (tomato) {
            this.price += this.tomatoPrice;
        }
        if (carrot) {
            this.price += this.carrotPrice;
        }
        if (cucumber) {
            this.price += this.cucumberPrice;
        }
    }

    public int getBasePrice() {
        return this.basePrice;
    }

    public int getTotalPrice() {
        return this.price;
    }
}
