package entertainments.humanoids.suits;

import entertainments.humanoids.suits.clothes.*;

public class CosmoSuit
        extends Suit {
    public CosmoSuit() {
        super("Cosmo Suit");
        addCloth(new CosmoJacket());
        addCloth(new CosmoHelmet());
    }
}
