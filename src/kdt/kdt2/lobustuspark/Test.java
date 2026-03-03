package kdt.kdt2.lobustuspark;

import java.util.ArrayList;
import java.util.List;

public class Test {

    static void main() {

        List<Lobustus> lobustused = new ArrayList<>();

        Vaateratas vaateratas = new Vaateratas();
        TasulineLobustus vaateratasTasuline = new TasulineLobustus(2.25, vaateratas);

        Lasketiir lasketiir = new Lasketiir();
        TasulineLobustus lasketiirTasuline = new TasulineLobustus(1.5, lasketiir);
        VanuseKontrollija lasketiirTasulineKontrolliga = new VanuseKontrollija(10, lasketiirTasuline);
        /*
            Kui delegeerimine oleks teises järjestuses, siis kõigepealt laseks kood läbi
            Tasulise decoratori ja alles hiljem kontrolliks vanust. Selle ülesande puhul
            tähendaks see, et külastaja maksab lõbustuse eest enne, kui on kindel, kas
            seda üldse külastada saab.
        */

        lobustused.add(vaateratasTasuline);
        lobustused.add(lasketiirTasulineKontrolliga);

        Lobustuspark lobustuspark = new Lobustuspark(lobustused);
        Kylastaja kylastaja = new Kylastaja(new ArrayList<>(), 11);
        Kylastaja kylastaja1 = new Kylastaja(new ArrayList<>(), 9);

        lobustuspark.alustaSeiklust(kylastaja);
        lobustuspark.alustaSeiklust(kylastaja1);

    }
}
