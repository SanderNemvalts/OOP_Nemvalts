package kdt.kdt3.effect;

import kdt.kdt3.dude.Dude;

public interface Effect {

    void onHit(Dude effectTarget);
    void onTurnStart(Dude effectTarget);
    void onTurnEnd(Dude effectTarget);
    int requiredActionPoints();
    boolean isExpired();

}
