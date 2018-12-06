package collections.universe;

public class Asteroid extends HeavenlyBody {
    public Asteroid(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.ASTEROID);
    }

    @Override
    public boolean addSatellite(HeavenlyBody satellite) {
        if (satellite.getBodyType().equals(BodyTypes.ASTEROID)) {
            return super.addSatellite(satellite);
        }
        System.out.println(satellite.getBodyType() + " cannot be a satellite to " + this.getBodyType());
        return false;
    }
}
