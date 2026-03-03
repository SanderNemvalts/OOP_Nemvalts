package prx.prx6.inimene;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static void main() throws Exception{

        Inimene inimene = new Inimene("Mati", "Meremees", List.of("Merianne", "Laevaliisa", "Rummista"));
        System.out.println(inimene);

        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream("data"+File.separatorChar+"prx6"+File.separatorChar+"inimene.bin")
        )) {
            dos.writeUTF(inimene.getEesnimi());
            dos.writeUTF(inimene.getPerenimi());
            List<String> lasteNimed = inimene.getLasteNimed();
            dos.writeInt(lasteNimed.size());
            for (String s : lasteNimed) {
                dos.writeUTF(s);
            }
        }


        try (DataInputStream dis = new DataInputStream(
                new FileInputStream("data"+File.separatorChar+"prx6"+File.separatorChar+"inimene.bin")
        )) {
            String lEesnimi = dis.readUTF();
            String lPerenimi = dis.readUTF();
            int lasteArv = dis.readInt();
            List<String> lLasteNimed = new ArrayList<>();
            for (; lasteArv > 0; lasteArv--) lLasteNimed.add(dis.readUTF());

            Inimene inimene1 = new Inimene(lEesnimi, lPerenimi, lLasteNimed);
            System.out.println(inimene1);
        }
    }
}
