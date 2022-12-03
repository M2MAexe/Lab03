package entertainments.rooms;

import java.util.Objects;

public class Room {
    protected String name;

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
            return this.name.equals(((Room) obj).getName());
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 47 * Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Room=" + name;
    }
}
