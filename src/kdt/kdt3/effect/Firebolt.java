package kdt.kdt3.effect;

import kdt.kdt3.dude.Dude;

// vastase järgmise käigu lõpus võtab 5 elu
public class Firebolt implements Effect {

    int requiredActionPoints = 20;
    boolean isExpired = false;

    @Override
    public void onHit(Dude effectTarget) {
        System.out.println(effectTarget.dudeType() + " has a firebolt pointed at them");
    }

    @Override
    public void onTurnStart(Dude effectTarget) {

    }

    @Override
    public void onTurnEnd(Dude effectTarget) {
        if (!isExpired) {
            effectTarget.changeHealth(-8);
            System.out.println(effectTarget.dudeType() + " lost 8 health to a firebolt");
        }
        isExpired = true;
    }

    @Override
    public int requiredActionPoints() {
        return requiredActionPoints;
    }

    @Override
    public boolean isExpired() {
        return isExpired;
    }
}
