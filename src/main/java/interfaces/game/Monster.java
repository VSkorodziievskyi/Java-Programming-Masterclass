package interfaces.game;

import java.util.ArrayList;
import java.util.List;

public class Monster implements Saveable {
    private String name;
    private int hp;
    private String superAbility;
    private String weapon;

    public Monster(String name, int hp, String superAbility) {
        this.name = name;
        this.hp = hp;
        this.superAbility = superAbility;
        this.weapon = "Claws";
        System.out.println("New monster created - " + this.name);
    }

    @Override
    public List<String> save() {
        List<String> values = new ArrayList<>();
        values.add(0, this.name);
        values.add(1, "" + this.hp);
        values.add(2, this.superAbility);

        return values;
    }

    @Override
    public void read(List<String> list) {
        if (list != null && list.size() > 2) {
            this.name = list.get(0);
            this.hp = Integer.parseInt(list.get(1));
            this.superAbility = list.get(2);
        } else {
            System.out.println("Nothing changed. Put all of the character values.\n");
        }
    }

    @Override
    public String toString() {
        return "Monster`s name: " + this.name + "\n" +
                this.name + "`s health points: " + this.hp + "\n" +
                this.name + "`s weapon: " + this.weapon + "\n" +
                this.name + "`s super ability: " + this.superAbility + "\n";
    }
}
