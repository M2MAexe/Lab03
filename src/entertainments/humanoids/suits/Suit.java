package entertainments.humanoids.suits;

import entertainments.humanoids.suits.clothes.Cloth;

import java.util.ArrayList;
import java.util.Objects;

public class Suit {
    private String name;
    protected ArrayList<Cloth> clothes = new ArrayList<>();

    public Suit(String name) {
        this.name = name;
    }

    public boolean addCloth(Cloth newCloth) {
        boolean flag = false;
        for (int i = 0; i < clothes.size(); i++) {
            if (newCloth.equals(clothes.get(i))) {
                flag = true;
            }
        }
        if (flag) {
            return false;
        }

        clothes.add(newCloth);
        return true;
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
            return name == ((Suit) obj).getName();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 102 * Objects.hash(name, clothes.size());
    }

    @Override
    public String toString() {
        String info = "Name=" + name;

        for (int i = 0; i < clothes.size(); i++) {
            info = info + " Cloth" + i + "=" + clothes.get(i).getName();
        }

        return info;
    }

}
