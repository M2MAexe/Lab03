package entertainments;

import entertainments.checkers.IChecker;
import entertainments.handlers.IHandler;
import entertainments.humanoids.Human;
import entertainments.rooms.Room;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Entertainment {
    protected String name;
    protected int numOfVisitors;
    protected ArrayList<IHandler> entertainmentHandlers = new ArrayList<>();
    protected ArrayList<IChecker> entertainmentCheckers = new ArrayList<>();
    protected ArrayList<Room> entertainmentRooms = new ArrayList<>();
    protected ArrayList<Human> visitors = new ArrayList<>();
    protected ArrayList<Human> watchers = new ArrayList<>();
    protected ArrayList<Human> waiters = new ArrayList<>();
    protected ArrayList<String> questionsBillboard = new ArrayList<>();


    public void run() {
    }

    public void addWatcher(Human newWatcher) {
        watchers.add(newWatcher);
    }

    public void addVisitor(Human newVisitor) {
        waiters.add(newVisitor);
    }

    protected void endGroupEntertainment() {}

    protected void outputCondition() {}

    public int getNumOfWaiters() {
        return waiters.size();
    }

    public int getNumOfVisitors() {
        return visitors.size();
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
        return getClass() == obj.getClass();
    }

    @Override
    public int hashCode() {
        return 47 * Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Name=" + name + " NumOfVisitors=" + numOfVisitors + " Visitors=" + visitors.size() +
                " Watchers=" + watchers.size() + " Waiters=" + waiters.size() +
                " Questions=" + questionsBillboard.size() + " Checkers=" + entertainmentCheckers.size() +
                " Rooms=" + entertainmentRooms.size() + " Handlers=" + entertainmentHandlers.size();
    }

    public boolean getStatement() {
        return true;
    }
}
