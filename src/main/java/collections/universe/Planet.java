package collections.universe;

public class Planet extends HeavenlyBody {
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody satellite) {
        if (satellite.getBodyType().equals(BodyTypes.MOON)) {
            return super.addSatellite(satellite);
        }
        System.out.println(satellite.getBodyType() + " cannot be a satellite to " + this.getBodyType());
        return false;
    }
}
