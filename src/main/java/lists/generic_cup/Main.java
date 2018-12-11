package lists.generic_cup;

public class Main {

    public static void main(String[] args) {

        Team<FootballTeam> madrid = new Team<>("Real Madrid C.F.");
        Team<FootballTeam> barcelona = new Team<>("FC Barcelona");
        barcelona.matchResult(madrid, 3, 3);
        barcelona.matchResult(madrid, 3, 2);
        madrid.matchResult(barcelona, 3, 0);

        Team<BasketballTeam> hawks = new Team<>("Atlanta Hawks");
        Team<BasketballTeam> bulls = new Team<>("Chicago Bulls");
        hawks.matchResult(bulls, 2, 4);


        League<Team<FootballTeam>> league = new League<>("World Football League");
        league.addTeam(madrid);
        league.addTeam(barcelona);
        league.printTeams();

        League<Team<BasketballTeam>> league1 = new League<>("World Basketball League");
        league1.addTeam(bulls);
        league1.addTeam(hawks);
        league1.printTeams();
    }
}