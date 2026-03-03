package kdt.kdt2.lobustuspark;

import java.util.List;

public class Lobustuspark {

    private List<Lobustus> lobustused;

    public Lobustuspark(List<Lobustus> lobustused) {
        this.lobustused = lobustused;
    }

    public void alustaSeiklust(Kylastaja kylastaja){
        System.out.println("alustan seiklust");
        for (Lobustus lobustus : lobustused) {
            lobustus.lobusta(kylastaja);
        }
        System.out.println(kylastaja.koikKirjeldused());
        System.out.println(kylastaja.kuludeSumma());
    }

}
