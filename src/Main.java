import entertainments.Rocket;
import entertainments.humanoids.*;
import entertainments.humanoids.suits.Suit;

public class Main {
    public static void main(String[] args) {
        Rocket r = new Rocket("Soyuz", 48);

        r.addVisitor(new Dunno());
        for (int i = 0; i < 143; i++) {
            r.addVisitor(new Human("human " + i, new Suit("None")));
        }
        r.addWatcher(new Human("Fuksia", new Suit("none")));
        r.addWatcher(new Human("Seledochka", new Suit("none")));

        while (r.getStatement()) {
           r.run();
        }
    }
}