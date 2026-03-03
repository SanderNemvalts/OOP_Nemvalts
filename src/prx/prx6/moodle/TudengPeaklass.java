package prx.prx6.moodle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TudengPeaklass {

    static void main() throws Exception {

        String failinimi = "data"+File.separatorChar+"prx6"+File.separatorChar+"punktid.txt";

        Tudeng tudeng = new Tudeng("Mati Mustikas", loePunktideFail(failinimi));
        System.out.println(tudeng);
        tudeng.salvestBinaarfaili("data"+File.separatorChar+"prx6"+File.separatorChar+"tudeng.bin");

        Tudeng tudeng2 = Tudeng.loeBinaarfailist("data"+File.separatorChar+"prx6"+File.separatorChar+"tudeng.bin");
        System.out.println(tudeng2);

    }

    public static List<AineHinne> loePunktideFail(String failinimi) throws Exception {
        List<AineHinne> hinneteList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(failinimi)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] result = line.split(",");
                String[] punktid = new String[result.length - 1];
                System.arraycopy(result, 1, punktid, 0, result.length - 1);
                hinneteList.add(new AineHinne(result[0], punktid));
            }
        }
        return hinneteList;
    }
}
