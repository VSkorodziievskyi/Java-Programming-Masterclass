package interfaces.game;

import java.util.ArrayList;
import java.util.List;

public class Player implements Saveable {
    private String name;
    private int hp;
    private String weapon;

    public Player(String name, int hp, String weapon) {
        this.name = name;
        this.hp = hp;
        this.weapon = weapon;
        System.out.println("New player created - " + this.name);
    }

    @Override
    public List<String> save() {
        List<String> values = new ArrayList<>();
        values.add(0, this.name);
        values.add(1, Integer.toString(this.hp));
        values.add(2, this.weapon);

        return values;
    }

    @Override
    public void read(List<String> list) {
        if (list != null && list.size() > 2) {
            this.name = list.get(0);
            this.hp = Integer.parseInt(list.get(1));
            this.weapon = list.get(2);
        } else
            System.out.println("Nothing changed. Write down all of the character values.\n");
    }

    @Override
    public String toString() {
        return "Player`s name: " + this.name + "\n" +
                this.name + "`s health points: " + this.hp + "\n" +
                this.name + "`s weapon: " + this.weapon + "\n";
    }
}
