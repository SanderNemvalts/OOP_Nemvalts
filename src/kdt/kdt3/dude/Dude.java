package kdt.kdt3.dude;

import kdt.kdt3.effect.Effect;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Dude {

    private double accuracy;
    private int armor;
    private int health;
    private int defaultActionPoints = 60;
    private int actionPoints = defaultActionPoints;
    private List<Effect> activeEffects = new ArrayList<>();

    public Dude(double accuracy, int armor, int health) {
        this.accuracy = accuracy;
        this.armor = armor;
        this.health = health;

    }

    public void takeTurn(Dude attackTarget) {
        System.out.println("Turn is now on " + this.dudeType() + "\n");
        turnStartEffects();
        if (!isAlive()) return;

        Effect effect = chooseEffect(attackTarget);
        Random random = new Random();
        if (effect != null && 1 + random.nextInt(19) + accuracy >= attackTarget.armor) {
            effect.onHit(attackTarget);
            attackTarget.addEffect(effect);
        } else if (effect != null) System.out.println(this.dudeType() + " missed their attack");

        turnEndEffects();
        clearEffects();
    }

    private void turnStartEffects(){
        activeEffects.forEach(effect -> effect.onTurnStart(this));
    }
    private void turnEndEffects(){
        activeEffects.forEach(effect -> effect.onTurnEnd(this));
    }

    // tühjenda aegunud effectid
    private void clearEffects() {
        activeEffects.removeIf(Effect::isExpired);
    }

    public abstract Effect chooseEffect(Dude attackTarget);

    public boolean isAlive() {
        return health > 0;
    }

    public abstract String dudeType();

    public void addEffect(Effect effect){
        activeEffects.add(effect);
    }

    public void changeHealth(int i) {health += i;}

    public void setActionPoints(int i) {actionPoints = i;}

    public int getHealth() {return health;}

    public int getActionPoints() {return actionPoints;}

    public void defaultActionPoints() {actionPoints = defaultActionPoints;}
}
