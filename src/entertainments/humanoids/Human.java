package entertainments.humanoids;

import entertainments.humanoids.suits.Suit;

import java.util.Objects;

public class Human
        implements IMoves {
    private final String name;
    private static int count = 0;
    private Suit humanSuit;
    private final HonestyParam honesty;

    private final int id;

    public Human(String name, Suit humanSuit) {
        this.name = name;
        this.humanSuit = humanSuit;
        honesty = HonestyParam.HONEST;
        id = putId();
    }

    protected Human(String name, Suit humanSuit, HonestyParam honesty) {
        this.name = name;
        this.humanSuit = humanSuit;
        this.honesty = honesty;
        id = putId();
    }

    private static int putId() {
        return count++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HonestyParam getHonesty() {
        return honesty;
    }

    public Suit getHumanSuit() {
        return humanSuit;
    }

    public void changeSuit( Suit humanSuit ) {
        this.humanSuit = humanSuit;
    }

    @Override
    public String askQuestion(String object) {
        return name + " asked about " + object;
    }

    @Override
    public String answerQuestion(String question) {
        return name + " answered to " + question;
    }

    @Override
    public void sitOn(String objectToSit) {
        System.out.println(name + " sat on " + objectToSit);
    }

    @Override
    public void lieOn(String objectToLie) {
        System.out.println(name + " lied on " + objectToLie);
    }

    @Override
    public void watchOut(String objectToWatch) {
        System.out.println(name + " watched on " + objectToWatch);
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
            return id == ((Human) obj).getId();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 78 * Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Name=" + name + " Suit=" + humanSuit.getName() + " Honesty=" + honesty;
    }

}