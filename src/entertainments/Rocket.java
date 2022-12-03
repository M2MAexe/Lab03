package entertainments;

import entertainments.checkers.SuitChecker;
import entertainments.handlers.AirCleaner;
import entertainments.handlers.TemperatureHolder;
import entertainments.handlers.Ventroom;
import entertainments.humanoids.HonestyParam;
import entertainments.humanoids.suits.*;
import entertainments.rooms.Cabin;
import entertainments.rooms.SleepingRoom;
import entertainments.rooms.Toilet;

public class Rocket
        extends Entertainment {
    private float airConditionValue = 1;
    private float airFreshnessValue = 1;
    private float temperature = 23f;

    public Rocket(String name, int numOfVisitors) {
        this.name = name;
        this.numOfVisitors = numOfVisitors;
        entertainmentHandlers.add(new AirCleaner(0.2f));
        entertainmentHandlers.add(new Ventroom(0.5f));
        entertainmentHandlers.add(new TemperatureHolder(temperature, 0.8f));
        entertainmentCheckers.add(new SuitChecker(new CosmoSuit()));
        entertainmentRooms.add(new Toilet());
        entertainmentRooms.add(new SleepingRoom());
        entertainmentRooms.add(new Cabin());
    }

    private void checkQueue() {
        if (waiters.size() >= numOfVisitors &&
                (visitors.size() == 0 || (visitors.size() == 1 && visitors.get(0).getHonesty() == HonestyParam.LIAR))) {
            for (int i = 0; i < numOfVisitors; i++) {
                visitors.add(waiters.get(0));
                waiters.remove(0);
            }
        }
    }

    private void handlersResponse() {
        airConditionValue -= 0.1 * Math.random();
        airFreshnessValue -= 0.1 * Math.random();
        temperature -= 0.4 * Math.random();

        for (int i = 0; i < entertainmentHandlers.size(); i++) {
            if (entertainmentHandlers.get(i).getClass().equals(AirCleaner.class)) {
                airConditionValue = entertainmentHandlers.get(i).doMove(airConditionValue);
            } else if (entertainmentHandlers.get(i).getClass().equals(Ventroom.class)) {
                airFreshnessValue = entertainmentHandlers.get(i).doMove(airFreshnessValue);
            } else if (entertainmentHandlers.get(i).getClass().equals(TemperatureHolder.class)) {
                temperature = entertainmentHandlers.get(i).doMove(temperature);
            }
        }
    }

    @Override
    protected void endGroupEntertainment() {
        for (int i = 0; i < visitors.size(); i++) {
            if (Math.random() < 0.5) {
                visitors.get(i).changeSuit(new CosmoSuit());
            }
        }

        int cnt = 0;
        while (cnt < visitors.size()) {
            if (visitors.get(cnt).getHumanSuit().equals(new CosmoSuit()) &&
                    visitors.get(cnt).getHonesty() == HonestyParam.HONEST) {
                visitors.remove(cnt);
            } else {
                cnt++;
            }
        }
    }

    @Override
    protected void outputCondition() {
        System.out.println("Air Condition=" + airConditionValue);
        System.out.println("Air Freshness=" + airFreshnessValue);
        System.out.println("Temperature in rocket=" + temperature);
        System.out.println("Number of visitors=" + visitors.size());
        System.out.println("Number of watchers=" + watchers.size());
        System.out.println("Number of waiters=" + waiters.size());
    }
    @Override
    public void run() {
        checkQueue();
        handlersResponse();

        for (int i = 0; i < visitors.size(); i++) {
            double rnd = Math.random();
            if (rnd < 0.25) {
                questionsBillboard.add(visitors.get(i).askQuestion("something in rocket"));
            } else if (rnd < 0.5) {
                visitors.get(i).sitOn(entertainmentRooms.get((int)(entertainmentRooms.size() * Math.random())).getName());
            } else if (rnd < 0.75) {
                visitors.get(i).lieOn(entertainmentRooms.get((int)(entertainmentRooms.size() * Math.random())).getName());
            } else if (rnd < 1) {
                visitors.get(i).watchOut(entertainmentRooms.get((int)(entertainmentRooms.size() * Math.random())).getName());
            }
        }

        for (int i = 0; i < questionsBillboard.size(); i++) {
            System.out.println(watchers.get((int)(watchers.size() * Math.random())).answerQuestion(questionsBillboard.get(0)));
            questionsBillboard.remove(0);
        }

        endGroupEntertainment();
        outputCondition();
    }
}