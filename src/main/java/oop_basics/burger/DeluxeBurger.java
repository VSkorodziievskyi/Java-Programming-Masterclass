package oop_basics.burger;

/**
 * Created by Vladimir on 07.03.2018.
 */
public class DeluxeBurger extends Hamburger {
    private String chips;
    private String drink;

    public DeluxeBurger() {
        super("Deluxe Burger", "Deluxe roll" , "Extra Bacon" , 25);
        this.chips = "Lays";
        this.drink = "Cola";
    }

    @Override
    public void additions(boolean lettuce, boolean tomato, boolean carrot, boolean cucumber) {
        System.out.println("You can not add any additions to this type of burger");
    }

    @Override
    public void showUpPrices() {
        System.out.println("Price of the Deluxe Burger: " + super.getBasePrice() + "$");
    }

    @Override
    public int getTotalPrice() {
        return super.getTotalPrice();
    }
}
