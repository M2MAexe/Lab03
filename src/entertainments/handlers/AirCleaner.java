package entertainments.handlers;

import java.lang.Math;

import java.util.Objects;

public class AirCleaner
        implements IHandler {
    private final float effectiveness;

    public AirCleaner(float effectiveness) {
        this.effectiveness = Math.max(0, Math.min(effectiveness, 1));
    }

    @Override
    public float doMove(float param) {
        return Math.min(1, param + (1 - param) * effectiveness);
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        else if (obj == null) {
            return false;
        }
        try {
            return doMove(1) == ((AirCleaner) obj).doMove(1);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hash(effectiveness);
    }

    @Override
    public String toString() {
        return "AirCleanerEffect=" + effectiveness;
    }
}
