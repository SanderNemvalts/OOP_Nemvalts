package kdt.kdt3.effect;

import kdt.kdt3.dude.Dude;

// võtab suure hulga elusid pihtasaamisel ja ka järgmisel kahel käigul
public class Bite implements Effect{

    int requiredActionPoints = 60;
    boolean isExpired = false;
    int count = 0;

    @Override
    public void onHit(Dude effectTarget) {
        effectTarget.changeHealth(-10);
        System.out.println(effectTarget.dudeType() + " got bit and lost 10 health");
    }

    @Override
    public void onTurnStart(Dude effectTarget) {

    }

    @Override
    public void onTurnEnd(Dude effectTarget) {
        if (count < 2 && !isExpired) {
            effectTarget.changeHealth(-3);
            System.out.println(effectTarget.dudeType() + " was still bleeding from the bite and lost 3 health");
        } else isExpired = true;
        count++;
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
