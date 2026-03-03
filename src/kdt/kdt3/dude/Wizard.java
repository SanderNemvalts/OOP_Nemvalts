package kdt.kdt3.dude;

import kdt.kdt3.effect.*;

public class Wizard extends Dude {

    // WIZARD EFFECTS:
    //      FIREBALL
    //      SPIDERWEB

    public Wizard() {
        super(5.0, 15, 20);
    }

    @Override
    public Effect chooseEffect(Dude attackTarget) {
        int apSpiderweb = new Spiderweb().requiredActionPoints();
        int apFirebolt = new Firebolt().requiredActionPoints();
        int actionPoints = this.getActionPoints();

        // kontrolli mille jaoks on piisavalt AP
        boolean canSpiderweb = apSpiderweb <= actionPoints;
        boolean canFirebolt = apFirebolt <= actionPoints;

        // standardväjundid
        if (!canFirebolt && !canSpiderweb) {
            System.out.println(this.dudeType() + " doesnt have enough actionpoints");
            return null;
        } else if (!canSpiderweb) return new Firebolt();


        // madalate elude korral eelistada firebolt, sest see teeb rutem rohkem dmg
        if (this.getHealth() < 10) return new Firebolt();

        // muul juhul eelistab spiderweb
        return new Spiderweb();
    }

    @Override
    public String dudeType() {
        return "WIZARD";
    }
}
