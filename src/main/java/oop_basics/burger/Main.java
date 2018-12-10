package oop_basics.burger;

public class Main {

    public static void main(String[] args) {

        Hamburger baseBurger = new Hamburger();
        baseBurger.showUpPrices();
        baseBurger.additions(true, true, false, true);
        System.out.println("Please take your cheque. Total prise is: " + baseBurger.getTotalPrice() + "$");


        HealthyBurger healthyBurger = new HealthyBurger();
        healthyBurger.showUpPrices();
        healthyBurger.additions(true, true, false, true);
        healthyBurger.uniqueAdditions(false, true);
        System.out.println("Please take your cheque. Total prise is: " + healthyBurger.getTotalPrice() + "$");


        DeluxeBurger deluxeBurger = new DeluxeBurger();
        deluxeBurger.showUpPrices();
        deluxeBurger.additions(true, true, true, true);
        System.out.println("Please take your cheque. Total prise is: " + deluxeBurger.getTotalPrice() + "$");
    }
}
