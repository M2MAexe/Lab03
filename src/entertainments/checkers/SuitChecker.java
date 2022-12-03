package entertainments.checkers;

import entertainments.humanoids.suits.Suit;

import java.util.Objects;

public class SuitChecker
        implements IChecker {
    private Suit checkSuit;

    public SuitChecker(Suit checkSuit) {
        this.checkSuit = checkSuit;
    }

    public Suit getCheckSuit() {
        return checkSuit;
    }

    @Override
    public boolean doCheck(Object obj) {
        return checkSuit.equals(obj);
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
            return checkSuit.equals(((SuitChecker) obj).getCheckSuit());
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 39 * Objects.hash(checkSuit.getName());
    }

    @Override
    public String toString() {
        return "CheckSuit=" + checkSuit.getName();
    }
}
