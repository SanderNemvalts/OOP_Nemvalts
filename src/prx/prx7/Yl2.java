package prx.prx7;

import java.util.ArrayList;

public class Yl2 {

    static void main() throws Exception{

        ArrayList<Integer> aList = new ArrayList<>();

        Loendur loendur = new Loendur(aList);

        Thread loim1 = new Thread(new Loim(loendur, "loim1"));
        Thread loim2 = new Thread(new Loim(loendur, "loim2"));

        loim1.start();
        loim2.start();

        loim1.join();
        loim2.join();

        System.out.println(aList);

    }
}

class Loim implements Runnable {

    private Loendur loendur;
    private String nimi;

    public Loim(Loendur loendur, String nimi) {
        this.loendur = loendur;
        this.nimi = nimi;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            loendur.insert(i);
        }
    }
}

class Loendur {

    ArrayList<Integer> aList;

    public Loendur(ArrayList<Integer> aList) {
        this.aList = aList;
    }

    public synchronized void insert(int i) {
        aList.add(i);
    }
}