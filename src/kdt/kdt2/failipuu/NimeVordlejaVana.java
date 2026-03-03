package kdt.kdt2.failipuu;

import java.util.Comparator;

public class NimeVordlejaVana implements Comparator<String> {

    public int compare2(String o1, String o2) {

        char[] o1Array = o1.toLowerCase().toCharArray();
        char[] o2Array = o2.toLowerCase().toCharArray();

        // võrdleb char-e kuni lühema sõne lõpuni
        for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
            if (o1Array[i] < o2Array[i]) {return 1;}
            else if (o1Array[i] > o2Array[i]) {return -1;}
        }
        // kui sama chararray, aga üks on pikem, seatakse see kõrgemale
        if (o1.length() < o2.length()) {return 1;}
        else if (o1.length() > o2.length()) {return -1;}
        else {return 0;}
    }

    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }

}
