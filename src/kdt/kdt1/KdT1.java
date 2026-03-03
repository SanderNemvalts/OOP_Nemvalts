package kdt.kdt1;

import java.util.Arrays;

public class KdT1 {

    public static int[][] combine(int[] poisid, int[] tydrukud) {

        Arrays.sort(poisid);
        Arrays.sort(tydrukud);

        int return_len = Math.min(poisid.length, tydrukud.length);
        int[][] return_arr = new int[return_len][2];
        for (int i = 0; i < return_len; i++) {
            return_arr[i][0] = poisid[i];
            return_arr[i][1] = tydrukud[i];
        }

        return return_arr;
    }


    public static void main(String[] args) {
        System.out.println("kdt.KdT1 -- Sander Nemvalts");
        System.out.println("-----------------------");

        int poisid_len = Integer.parseInt(args[0]);
        int[] poisid = new int[poisid_len];
        for (int i = 0; i < poisid_len; i++) {
            poisid[i] = Integer.parseInt(args[1+i]);
        }

        int tydrukud_len = Integer.parseInt(args[poisid_len + 1]);
        int[] tydrukud = new int[tydrukud_len];
        for (int i = 0; i < tydrukud_len; i++) {
            tydrukud[i] = Integer.parseInt(args[poisid_len + 2 + i]);
        }

        int[][] result = combine(poisid, tydrukud);

        for (int i = 0; i < result.length; i++) {
            System.out.printf("[p %d, t %d]\n", result[i][0], result[i][1]);
        }
    }
}