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

    private static char[] pensaLletres(char[] lletres, int quantes) {
        int save = 1;
        char[] tablero = new char[quantes];
        for (int i = 0; i < tablero.length; i++) {
            tablero[i] += lletres[(int) (Math.random() * lletres.length)];
        }
        return tablero;
    }

    public static String s(String string) {
        List<String> letters = Arrays.asList(string.split(""));
        Collections.shuffle(letters);
        String shuffled = "";
        for (String letter : letters) {
            shuffled += letter;
        }
        return shuffled;
    }

    static char[] passaVector(String s) {
        char[] miJugada = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            miJugada[i] = s.charAt(i);
        }
        return miJugada;
    }

    private static char[] pensaLletress(char[] lletres, int quantes) {
        String string = passaCadena(lletres);
        List<String> letters = Arrays.asList(string.split(""));
        Collections.shuffle(letters);
        String shuffled = "";
        for (String letter : letters) {
            shuffled += letter;
        }
        return passaVector(shuffled.substring(0, quantes));
    }

    public static void main(String[] args) {

        char[] lletres = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        System.out.println(Arrays.toString(pensaLletress(lletres, 8)));
    }

}
