package collections.basket;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
	    StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        Basket basket = new Basket("customer");
        reserveItem(basket, "bread", 5);
        reserveItem(basket, "car", 1);
        reserveItem(basket, "car", 1);
        reserveItem(basket, "car", 1);
        unreserveItem(basket, "phone", 3);
        System.out.println(basket.toString());

        System.out.println(stockList);

        unreserveItem(basket, "car", 1);
        unreserveItem(basket, "car", 1);
        unreserveItem(basket, "car", 1);
        System.out.println(basket.toString());

        System.out.println(stockList);

        basket.checkOutBasket("customer");
        System.out.println(basket.toString());
        unreserveItem(basket, "bread", 1);
        System.out.println(stockList);

    }

    public static int reserveItem(Basket basket, String item, int quantity) {
        //retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }

    public static void unreserveItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if(stockItem != null) { /* && basket.items().containsKey(stockItem)*/
            basket.removeFromBasket(stockItem, quantity);
            stockItem.unreserveStock(quantity);
        }
    }
}
