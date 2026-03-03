package kdt.kdt2.lobustuspark;

public class VanuseKontrollija implements Lobustus{

    private int noutudVanus;
    private Lobustus delegaat;

    public VanuseKontrollija(int noutudVanus, Lobustus lobustus){
        this.noutudVanus = noutudVanus;
        this.delegaat = lobustus;
    }

    @Override
    public void lobusta(Kylastaja kylastaja) {

        if (kylastaja.getVanus() < noutudVanus) {
            kylastaja.lisaKirjeldus("Ei läbinud vanusekontrolli:( ");
        } else {
            delegaat.lobusta(kylastaja);
        }
    }
}
