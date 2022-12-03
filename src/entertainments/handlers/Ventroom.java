package entertainments.handlers;

import java.util.Objects;

public class Ventroom
        implements IHandler {
    private final float effectiveness;

    public Ventroom(float effectiveness) {
        this.effectiveness = Math.min(1, Math.max(effectiveness, 0));
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
            return doMove(1) == ((Ventroom) obj).doMove(1);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 29 * Objects.hash(effectiveness);
    }

    @Override
    public String toString() {
        return "VentroomEffect=" + effectiveness;
    }
}
