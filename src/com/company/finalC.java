package com.company;

import java.util.*;

public class finalC {
    private static int lletresEscollir; // Número de lLetres entre les que podem escollir  (Ex: 6)
    private static int lletresJugar;    // Número de lletres que jugarem   (Ex: 4)
    private static int numJugada = 1;   // Número de la jugada actual, 1 per a la primera jugada
    private static int jugadasMax;      // Número màxim de jugades que farem
    private static boolean repetirLletres = false;      // No es deixen repetir lletres a la combinació (o si)
    private static char[] lletres; // Manté un array amb totes les lletres possibles  (Ex:  [A,B,C,D,E,F])
    private static char[] jugada;      // Manté un array amb la jugada actual	(Ex:  [A,C,A,F]
    private static char[] pensat;      // Manté un array amb la combinació que ha pensat la màquina (Ex: [B,A,C,A])


    private static boolean contingudes(char[] lletres, String s) {//Input Comprobar
//        int count = 0;
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 0; j < lletres.length; j++) {
//                if (lletres[j] == s.charAt(i)) {
//                    count++;
//                }
//            }
//        }
//        if (count == s.length())
//            return true;
//        return false;
        String cadena = passaCadena(lletres);
        return cadena.contains(s);
    }

    private static char[] pensaLletres(char[] lletres, int quantes) {
        // Li pasem en quantes el número de lletres que hem de pensar, i retorna un vector de
        // longitud quantes, amb les lletres pensades, escollides (sense repetir) de lletres
//        char[] tablero = new char[quantes];
//        for (int i = 0; i < tablero.length; i++) {
//            tablero[i] += lletres[(int) (Math.random() * lletres.length)];
//        }
//
//        return tablero;
        return lletres;
    }
    //    private static char[] pensaRepetides(char[] lletres, int quantes) {
//        // Li pasem en quantes el número de lletres que hem de pensar, i retorna un vector de
//        // longitud quantes, amb les lletres pensades, escollides (repetint les lletres)
//
//    }

    private static void llegeixDades() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Escoje un numero de letras de donde seleccionar, por ejemple (2-6):");
        int lletresJugar = teclado.nextInt();
        System.out.print("Escoje un numero de letras para jugar por ejemple (1-6):");
        int lletresEscollir = teclado.nextInt();
        System.out.print("Numero maximo de jugadas antes de terminar la partida: ");
        int jugadasMax = teclado.nextInt();
    }

    static char[] passaVector(String s) {
        char[] miJugada = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            miJugada[i] = s.charAt(i);
        }
        return miJugada;
    }

    static String passaCadena(char[] lletres) {
        String v = new String(lletres);
        return v;
    }

//    static boolean properaJugada() {
//        // Demana a l'usuari que introdueixi la propera jugada, i la compara amb la jugada que ha pensat
//        // el programa.  Li diu a l'usuari les lletres que té be i les que té regular (està la lletra però
//        // mal posada)
//        // Incrementa el número de jugades, i si l'usuari encerta totes les lletres, li felicita i retorna
//        // true, indicant que s'ha acabat la partida.  En cas contrari, retorna false per continuar jugant.
//    }


//    private static int llegeixInt(String missatge, int min, int max) {
//        // Llegeix un enter positiu entre min i max amb control d'errors.  No retorna de la funció
//        // fins que el valor llegit és vàlid.  Proporciona els missatges d'error convenients
//
//    }

    public static void main(String[] args) {
        // Programa principal, s'indica complet a falta de les funcions
//        llegeixDades();
//        if (!repetirLletres)
//            pensat = pensaLletres(lletres, lletresJugar);
//        else
//            pensat = pensaRepetides(lletres, lletresJugar);
//        // Si volem saber les lletres que s'han pensat, descomentar
//        // System.out.println(java.util.Arrays.toString(pensat));
//        while (!properaJugada() && numJugada <= jugadasMax) ;
//        if (numJugada > jugadasMax)
//            System.out.println("Ho sento, no l'has encertat.  Torna a jugar");
    }
}


