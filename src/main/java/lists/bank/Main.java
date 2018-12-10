package lists.bank;

public class Main {

    public static void main(String[] args) {
        welcomeBank();
        Bank bank = new Bank("American National Bank");
        bank.addNewBranch("New York");
        bank.addNewBranch("Los Angeles");
        bank.addNewCustomerToBranch("New York", "Jack", 50.4D);
        bank.addNewCustomerToBranch("Los Angeles", "Vladimir", 45.0D);
        bank.addNewTransactionToCustomer("Los Angeles", "Vladimir", 100.3D);
        bank.showBranchesList();
        bank.showCustomerTransactionList("Los Angeles", true);
        bank.showCustomerTransactionList("New York", false);
    }

    private static void welcomeBank() {
        System.out.println("Welcome to the Bank's management.");
    }
}
