package kdt.kdt3.effect;

import kdt.kdt3.dude.Dude;

// löögil kaotab vastane elusid
public class WeaponAttack implements Effect{

    int requiredActionPoints = 40;
    boolean isExpired = false;

    @Override
    public void onHit(Dude effectTarget) {
        if (!isExpired) {
            effectTarget.changeHealth(-8);
            System.out.println(effectTarget.dudeType() + " lost 8 health to WeaponAttack");
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
