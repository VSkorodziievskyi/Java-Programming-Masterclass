package lists.generic_cup;

public class Team<T> implements Comparable<Team<T>> {
    private String name;
    private int played = 0;
    private int won = 0;
    private int lost = 0;
    private int tied = 0;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void matchResult(Team<T> team, int ourScore, int theirScore) {
        if (ourScore > theirScore) {
            System.out.println(this.getName() + " beat " + team.getName());
            won++;
            team.lost++;
        } else if (ourScore < theirScore) {
            System.out.println(team.getName() + " beat " + this.getName());
            lost++;
            team.won++;
        } else {
            System.out.println(this.getName() + " drew with " + team.getName());
            tied++;
            team.tied++;
        }
        played++;
    }

    public int ranking() {
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking() > team.ranking()) {
            return -1;
        } else if (this.ranking() < team.ranking()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return getName() + " : " + ranking();
    }
}
