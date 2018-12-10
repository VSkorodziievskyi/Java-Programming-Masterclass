package collections.basket;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }
    public void removeFromBasket(StockItem item, int quantity) {
        if (list.containsKey(item) && (item != null) && (quantity > 0)) {
            int inBasket = list.get(item);
            if (quantity < inBasket) {
                list.put(item, inBasket - quantity);
            } else {
                list.remove(item);
            }
        }
    }

    public void checkOutBasket(String name) {
        if(this.name.equals(name) && !list.isEmpty()) {
            System.out.println("Thanks for your purchase. The basket has been cleared.");
            for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
                System.out.println("Purchased item: " + item.getKey() + ". quantity: " + item.getValue() + ".");
                item.getKey().checkOutUnreservation(item.getValue());
            }
            list.clear();
        } else if(this.name.equals(name) && list.isEmpty()) {
            System.out.println("Your basket is empty.");
        } else {
            System.out.println("Such basket name doesn`t exist.");
        }
    }

    public Map<StockItem, Integer> items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size() + ((list.size() == 1) ? " item" : " items") + "\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ". " + item.getValue() + " reserved.\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost: " + totalCost + "\n";
    }
}
