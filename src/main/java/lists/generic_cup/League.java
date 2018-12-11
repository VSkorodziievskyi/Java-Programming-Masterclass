package lists.generic_cup;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    private String name;
    private ArrayList<T> teams;

    public League(String name) {
        this.name = name;
        this.teams = new ArrayList<>();
    }

    public boolean addTeam(T team) {
        if (teams.contains(team)) {
            System.out.println("Cannot add - Team already exists.");
            return false;
        }
        teams.add(team);
        System.out.println("Successfully added a team to the league: " + team.getName());
        return true;
    }

    public void printTeams() {
        Collections.sort(teams);
        System.out.println("\n" + name + "\n"  + teams + "\n");
    }
}

