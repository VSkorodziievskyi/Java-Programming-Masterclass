package lists.bank;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    public boolean addNewCustomer(String customerName, double initialAmount) {
        if (this.findCustomer(customerName) == null) {
            this.customers.add(new Customer(customerName, initialAmount));
            return true;
        } else {
            System.out.println("Can not add this record, please check if " + customerName + " Customer already exists.");
            return false;
        }
    }

    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer existingCustomer = this.findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.addTransactions(amount);
            return true;
        } else {
            System.out.println("Can not add transaction, please check if " + customerName + " Customer record does exist.");
            return false;
        }
    }

    public void customerTransactionList(boolean showTransacions) {
        for(int i = 0; i < this.customers.size(); ++i) {
            if (showTransacions) {
                System.out.println(i + 1 + "." + ((Customer)this.customers.get(i)).getName() + " -> " + ((Customer)this.customers.get(i)).getTransactions());
            }

            System.out.println(i + 1 + "." + ((Customer)this.customers.get(i)).getName());
        }

        if (this.customers.isEmpty()) {
            System.out.println("Customer & Transaction List is empty...");
        }

    }

    private Customer findCustomer(String customerName) {
        for(int i = 0; i < this.customers.size(); ++i) {
            if (((Customer)this.customers.get(i)).getName().equals(customerName)) {
                return (Customer)this.customers.get(i);
            }
        }

        return null;
    }
}
