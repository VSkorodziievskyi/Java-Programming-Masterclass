package collections.basket;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock;
    private int reservedStock = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int remainingQuantity() {
        return this.quantityStock;
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityStock + quantity;
        if (newQuantity >= 0) {
            this.quantityStock = newQuantity;
        }
    }

    public int getReservedStock() {
        return reservedStock;
    }

    public boolean reserveStock(int quantity) {
            if(quantity + this.reservedStock <= this.quantityStock) {
                this.reservedStock += quantity;
                System.out.println(quantity + ((quantity == 1) ? " item " : " items ") + "of " + name + " reserved. Available reservations amount of " + name + " is: " + (this.quantityStock - this.reservedStock));
                return true;
            } else {
                System.out.println("Can`t reserve this amount of " + name + ". Available reservations amount of " + name + " is: " + (this.quantityStock - this.reservedStock));
                return false;
            }
        }

        public void unreserveStock(int quantity) {
        if(this.reservedStock > 0 && quantity <= this.reservedStock && quantity > 0) {
            this.reservedStock -= quantity;
            System.out.println("Unreserved " + quantity + ((quantity == 1) ? " item " : " items ") + "of " +  name  + " successfully. Total amount of reserved " + name + " items is: " + this.reservedStock);
            } else {
            System.out.println("Can`t unreserve this amount of " + name + ". Total amount of reserved " + name + " items is: " + this.reservedStock);
            }
        }

        public void checkOutUnreservation(int quantity) {
            if(this.reservedStock > 0 && quantity <= this.reservedStock && quantity > 0) {
                this.quantityStock -= quantity;
                this.reservedStock -= quantity;
            }
        }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");
        if(obj == this) {
            return true;
        }

        if((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
        if(this == o) {
            return 0;
        }

        if(o != null) {
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " || price: " + this.price;
    }
}
