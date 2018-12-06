package collections.universe;

public class Moon extends HeavenlyBody {
    public Moon(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.MOON);
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
