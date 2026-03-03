package kdt.kdt3;

import kdt.kdt3.effect.*;
import kdt.kdt3.dude.*;

import kdt.kdt3.dude.*;

public class DungeonsAndDudes {
    static void main() {

        Wizard wizard = new Wizard();
        Fighter fighter = new Fighter();
        Karu karu = new Karu();
        Kevin kevin = new Kevin();


        // kakluste testimiseks
        Dude dude1 = fighter;
        Dude dude2 = wizard;


        System.out.println("A FIGHT BETWEEN " + dude1.dudeType() + " AND " + dude2.dudeType());
        // game body
        while (true) {

            hline();
            dude1.takeTurn(dude2);
            if (!dude1.isAlive() || !dude2.isAlive()) break;
            else healthOut(dude1, dude2);

            dude2.defaultActionPoints();

            hline();
            dude2.takeTurn(dude1);
            if (!dude1.isAlive() || !dude2.isAlive()) break;
            else healthOut(dude1, dude2);

            dude1.defaultActionPoints();

        }

        hline();
        Dude deadDude = null;
        Dude winner = null;
        if (!dude1.isAlive()) {deadDude = dude1; winner = dude2;}
        if (!dude2.isAlive()) {deadDude = dude2; winner = dude1;}

        System.out.println(deadDude.dudeType() + " HAS DIED, THE WINNER IS " + winner.dudeType());
    }

    static void healthOut(Dude dude1, Dude dude2){
        System.out.println("\n" + dude1.dudeType() + ": " + dude1.getHealth() + "HP\n" + dude2.dudeType() + ": " + dude2.getHealth() + "HP");
    }
    static void hline() {
        System.out.println("---------------------------------------------------------");
    }
}
