package com.company;

import java.util.*;

public class Main {
    private static boolean contingudees(char[] lletres, String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < lletres.length; j++) {
                if (lletres[j] == s.charAt(i)) {
                    count++;
                }
            }
        }
        if (count == s.length())
            return true;
        return false;
    }

    static String passaCadena(char[] lletres) {
        String v = new String(lletres);
        return v;
    }

    private static String[] pensaLletres(char[] lletres, int quantes) {
        char[] tablero = new char[quantes];
//        for (int i = 0; i < tablero.length; i++) {
//            tablero[i] += lletres[(int) (Math.random() * lletres.length)];
//        }
        HashSet<Character> uniqueCharSet = new HashSet<Character>();
        for (char each : lletres) {
            uniqueCharSet.add(each);
        }

        String[] v = new String[uniqueCharSet.size()];
        v = uniqueCharSet.toArray(v);
        return v;
    }

    public static void main(String[] args) {

        char[] lletres = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',};
        String s = "ABACEAA";


        System.out.println(Arrays.toString(pensaLletres(lletres, 5)));
    }

}
