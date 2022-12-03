package entertainments.humanoids;

import entertainments.humanoids.suits.CosmoSuit;

public class Dunno
        extends Human {
    public Dunno() {
        super("Dunno", new CosmoSuit(), HonestyParam.LIAR);
    }
}
