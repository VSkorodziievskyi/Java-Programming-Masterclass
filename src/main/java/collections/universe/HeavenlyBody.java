package collections.universe;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final BodyTypes bodyType;

    public enum BodyTypes {
        PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.bodyType = bodyType;
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public String getBodyInformation() {
        return "Type: " + this.bodyType + ". Orbital period: " + this.orbitalPeriod + ". Name: " + this.name + ".";
    }

    public boolean addSatellite(HeavenlyBody satellite) {
        return this.satellites.add(satellite);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }


    public BodyTypes getBodyType() {
        return bodyType;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof HeavenlyBody && this.name.equals(((HeavenlyBody) obj).getName()))) {
            return this.bodyType == ((HeavenlyBody) obj).getBodyType();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.bodyType.hashCode() + 11;
    }
}
