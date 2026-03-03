package kdt.kdt3.effect;

import kdt.kdt3.dude.Dude;

// vastane kaotab pihtasaamisel pooled actionpointid ja võtab mõned elud
public class Knockdown implements Effect{

    int requiredActionPoints = 30;
    boolean isExpired = false;

    @Override
    public void onHit(Dude effectTarget) {
        if (!isExpired) {
            effectTarget.setActionPoints(effectTarget.getActionPoints() / 2);
            effectTarget.changeHealth(-2);
            System.out.println(effectTarget.dudeType() + " lost half of their actionpoints and 2 health being knocked down");
        }
        isExpired = true;
    }

    @Override
    public void onTurnStart(Dude effectTarget) {}

    @Override
    public void onTurnEnd(Dude effectTarget) {}

    @Override
    public int requiredActionPoints() {
        return requiredActionPoints;
    }

    @Override
    public boolean isExpired() {
        return isExpired;
    }
}
