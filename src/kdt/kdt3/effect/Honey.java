package kdt.kdt3.effect;

import kdt.kdt3.dude.Dude;

// Pihtasaamisel tühjendab actionpointed ja järgmise kolme käigu alguses lisab elusid
public class Honey implements Effect{

    int requiredActionPoints = 25;
    boolean isExpired = false;
    int count = 0;

    @Override
    public void onHit(Dude effectTarget) {
        System.out.println(effectTarget.dudeType() + " got splashed by honey and zeroed their action points");
        effectTarget.setActionPoints(0);
    }

    @Override
    public void onTurnStart(Dude effectTarget) {
        if (count < 3 && !isExpired) {
            effectTarget.changeHealth(5);
            System.out.println(effectTarget.dudeType() + " ate some honey and gained 5 health");
        } else isExpired = true;
        count++;
    }

    @Override
    public void onTurnEnd(Dude effectTarget) {

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
