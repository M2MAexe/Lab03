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

        long timerun = System.currentTimeMillis();
        boolean key = true;

        while (key) {
            if (System.currentTimeMillis() - timerun > 2000) {
                r.run();
                timerun = System.currentTimeMillis();
            }
            if (r.getNumOfWaiters() < 48 && r.getNumOfVisitors() <= 1) {
                key = false;
            }
        }
    }
}