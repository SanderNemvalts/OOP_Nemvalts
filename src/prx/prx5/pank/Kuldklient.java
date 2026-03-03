package prx.prx5.pank;

public class Kuldklient extends Klient {

    private String kliendiHaldur;

    public Kuldklient(String isikukood, double saldo, String kliendiHaldur) {
        super(isikukood, saldo);
        this.kliendiHaldur = kliendiHaldur;
    }


    public String getKliendiHaldur() {
        return kliendiHaldur;
    }
    public void setKliendiHaldur(String kliendiHaldur) {
        this.kliendiHaldur = kliendiHaldur;
    }
}
