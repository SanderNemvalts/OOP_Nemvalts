package kdt.kdt3.dude;

import kdt.kdt3.effect.*;

import java.util.Random;


public class Fighter extends Dude{

    // FIGHTER EFFECTS:
    //      FIREBALL
    //      SPIDERWEB

    public Fighter() {
        super(7.0, 10, 25);
    }

    @Override
    public Effect chooseEffect(Dude attackTarget) {
        int apWeaponAttack = new WeaponAttack().requiredActionPoints();
        int apKnockdown = new Knockdown().requiredActionPoints();
        int actionPoints = this.getActionPoints();

        // kontrolli mille jaoks on piisavalt AP
        boolean canWeaponAttack = apWeaponAttack <= actionPoints;
        boolean canKnockdown = apKnockdown <= actionPoints;

        // standardväjundid
        if (!canWeaponAttack && !canKnockdown) {
            System.out.println(this.dudeType() + " doesnt have enough actionpoints");
            return null;
        } else if (!canWeaponAttack) return new Knockdown();

        // madalate elude korral eelistada weaponattack
        if (this.getHealth() < 10) return new WeaponAttack();

        // Kui vastasel on palju AP, eelistab Knockdowni 75% ajast
        Random random = new Random();
        if (attackTarget.getActionPoints() > 60 && random.nextInt(20) < 15 ) return new Knockdown();
        else if (attackTarget.getActionPoints() > 60) return new WeaponAttack();

        // Kui vastasel ei ole juba palju actionpointe, eelistab weaponattack
        return new WeaponAttack();
    }

    @Override
    public String dudeType() {
        return "FIGHTER";
    }

}

