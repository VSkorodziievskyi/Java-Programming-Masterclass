package interfaces.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player dragonborn = new Player("Tiber Septim", 100, "Dragonbane");
        System.out.println(dragonborn);
        loadValues(dragonborn);
        saveValues(dragonborn);
        System.out.println(dragonborn);

        Saveable werewolf = new Monster("Werewolf", 200, "Animal Vigor");
        System.out.println(werewolf);
        loadValues(werewolf);
        saveValues(werewolf);
        System.out.println(werewolf);
    }

    public static void saveValues(Saveable object) {
        for (Object x : object.save()) {
            System.out.println("Saved character value: " + x);
        }
        System.out.println("\n");
    }

    public static void loadValues(Saveable object) {
        object.read(readValues());
    }


    public static List<String> readValues() {
        List<String> values = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Here you can overwrite new values according to your character type:\n" +
                "1 to confirm and continue\n" +
                "0 to cancel");

        while (!quit && index != 3) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter " + ((index == 1) ? "an integer: " : "a string: "));
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }
}
