package collections.universe;

public class Comet extends HeavenlyBody {
    public Comet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.COMET);
    }

    @Override
    public BodyTypes getBodyType() {
        return super.getBodyType();
    }

    @Override
    public boolean addSatellite(HeavenlyBody satellite) {
        System.out.println(this.getBodyType() + " cannot have a satellite.");
        return false;
    }
}
