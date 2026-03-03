package prx.prx6.moodle;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Tudeng {

    private final String nimi;
    private final List<AineHinne> hinneteList;

    public Tudeng(String nimi, List<AineHinne> hinneteList) {
        this.nimi = nimi;
        this.hinneteList = hinneteList;
    }

    public static Tudeng loeBinaarfailist(String failinimi) throws Exception {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(failinimi))) {
            String loetudNimi = dis.readUTF();
            int aineteArv = dis.readInt();
            List<AineHinne> loetudHinneteList = new ArrayList<>();
            for (int i = 0; i < aineteArv; i++) {
                loetudHinneteList.add(new AineHinne(dis.readUTF(), dis.readChar()));
            }
            dis.close();
            return new Tudeng(loetudNimi, loetudHinneteList);
        }
    }

    public void salvestBinaarfaili(String failinimi) throws Exception{
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(failinimi))) {
            dos.writeUTF(nimi);
            dos.writeInt(hinneteList.size());
            for (AineHinne hinne : hinneteList) {
                dos.writeUTF(hinne.getNimetus());
                dos.writeChar(hinne.getHinne());
            }
        }
    }

    @Override
    public String toString() {
        return nimi + hinneteList.toString();
    }
}

