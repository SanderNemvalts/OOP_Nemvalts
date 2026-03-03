package kdt.kdt3.dude;

import kdt.kdt3.effect.Bite;
import kdt.kdt3.effect.Effect;

public class Kevin extends Dude{

    public Kevin() {
        super(5.0, 6, 32);
    }

    @Override
    public Effect chooseEffect(Dude attackTarget) {
        return null;
    }

    @Override
    public String dudeType() {return "KEVIN";}
}
