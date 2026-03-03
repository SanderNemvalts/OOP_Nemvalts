package kdt.kdt2.lobustuspark;

public class Lasketiir implements Lobustus {

    public void lobusta(Kylastaja kylastaja) {
        int hits = (int)Math.round(Math.random() * 20);
        kylastaja.lisaKirjeldus(String.format("Tabasin lasketiirus %d sihtmärki", hits));
    }
}
