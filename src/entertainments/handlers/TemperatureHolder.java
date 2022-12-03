package entertainments.handlers;

import java.util.Objects;
import java.lang.Math;

public class TemperatureHolder
        implements IHandler {
    private float temperature;
    private final float effectiveness;

    public TemperatureHolder(float temperature, float effectiveness) {
        this.temperature = temperature;
        this.effectiveness = Math.min(1, Math.max(effectiveness, 0));
    }

    public boolean changeTemperature(float temperature) {
        if (this.temperature == temperature) {
            return false;
        }
        this.temperature = temperature;
        return true;
    }
    @Override
    public float doMove(float param) {
        if (param > temperature) {
            return param - (param - temperature) * effectiveness;
        }
        else if (param < temperature) {
            return param + (temperature - param) * effectiveness;
        }
        return param;
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
            return hashCode() == ((TemperatureHolder) obj).hashCode();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 357 * Objects.hash(temperature) + Objects.hash(effectiveness);
    }

    @Override
    public String toString() {
        return "Temperature=" + temperature + " Effect=" + effectiveness;
    }
}
