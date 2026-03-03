package kdt.kdt3.dude;

import kdt.kdt3.effect.Bite;
import kdt.kdt3.effect.Effect;
import kdt.kdt3.effect.Honey;
import kdt.kdt3.effect.Knockdown;

import java.util.List;

public class Karu extends Dude {

    public Karu() {
        super(0, 0, 150);
    }

    @Override
    public Effect chooseEffect(Dude attackTarget) {
        return null;
    }

    @Override
    public String dudeType() {
        return "KARU";
    }
}
