package prx.prx5.pank;

import java.util.ArrayList;
import java.util.List;

public class Klient {

    private String isikukood;
    private double saldo;
    private List<String> tehingud = new ArrayList<>();

    public Klient(String isikukood, double saldo) {
        this.isikukood = isikukood;
        this.saldo = saldo;
    }

    public void teostaÜlekanne(String kontole, double summa) {
        tehingud.add("ülekanne kontole " + kontole + ", summa " + summa);
        saldo -= summa;
    }

    public double arvutaTehinguTasud() {
        return 0.1 * tehingud.size();
    }

    public String toString() {
        return "klient " + isikukood + ", saldo " + saldo;
    }
}
