package kdt.kdt2.lobustuspark;

public class TasulineLobustus implements Lobustus{

    private double hind;
    private Lobustus delegaat;

    public TasulineLobustus(double hind, Lobustus delegaat) {
        this.hind = hind;
        this.delegaat = delegaat;
    }

    public void lobusta(Kylastaja kylastaja) {
        delegaat.lobusta(kylastaja);
        kylastaja.lisaKulu(hind);
        kylastaja.lisaKirjeldus(String.format("tasusin külastuse eest %.2f", hind));
    }

}
