package prx.prx5.pank;

public class TestPank {

    static void main() {

        int kliendiArv = 100;
        Klient[] kliendid = new Klient[kliendiArv];
        for (int i = 0; i < kliendiArv*0.8; i++) {
            kliendid[i] = new Klient(String.valueOf(Math.round(Math.random()*90000 + 10000)), Math.random()*1000 + 100);
        }
        for (int i = 0; i < kliendiArv*0.2; i++) {
            kliendid[(int)Math.ceil(kliendiArv*0.8) + i] = new Kuldklient(String.valueOf(Math.round(Math.random()*90000 + 10000)), Math.random()*1000000 + 100000, "haldur" + i);
        }



    }

}
