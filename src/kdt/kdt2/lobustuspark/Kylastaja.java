package kdt.kdt2.lobustuspark;

import java.util.ArrayList;
import java.util.List;

public class Kylastaja {

    private int vanus;
    private double kulud;
    private List<String> kylastusteKirjeldused = new ArrayList<>();

    public Kylastaja(ArrayList<String> kylastusteKirjeldused, int vanus) {
        this.kylastusteKirjeldused = kylastusteKirjeldused;
        this.vanus = vanus;
    }

    public void lisaKirjeldus(String kirjeldus) {
        kylastusteKirjeldused.add(kirjeldus);
    }

    public List<String> koikKirjeldused() {
        return kylastusteKirjeldused;
    }

    public int getVanus() {
        return vanus;
    }

    public void lisaKulu(double kulu) {
        kulud += kulu;
    }

    public double kuludeSumma() {
        return kulud;
    }

}
