package entertainments.humanoids.suits.clothes;

import java.util.Objects;

public class Cloth {
    private final ClothType wearing;
    private final String name;

    protected Cloth(String name, ClothType wearing) {
        this.name = name;
        this.wearing = wearing;
    }

    public String getName() {
        return name;
    }

    public ClothType getWearing() {
        return wearing;
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
            return name == ((Cloth) obj).getName() && wearing == ((Cloth) obj).getWearing();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hash(name, wearing);
    }

    @Override
    public String toString() {
        return "Name=" + name + " ClothType=" + wearing;
    }
}
