package kdt.kdt3.effect;

import kdt.kdt3.dude.Dude;

// vastase 3 järgmise käigu alguses vähendab elusid
public class Spiderweb implements Effect{

    int requiredActionPoints = 30;
    boolean isExpired = false;
    int count = 0;

    @Override
    public void onHit(Dude effectTarget) {
        System.out.println(effectTarget.dudeType() + " got hit with a spiderweb attack");
    }

    @Override
    public void onTurnStart(Dude effectTarget) {
        if (count < 3 && !isExpired) {
            effectTarget.changeHealth(-4);
            System.out.println(effectTarget.dudeType() + " lost 4 health in the spiderweb");
        }
        else isExpired = true;
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
