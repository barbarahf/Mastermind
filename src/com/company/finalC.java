package com.company;
import java.util.*;
public class finalC {
    private static int lletresJugar;
    private static int numJugada = 1;
    private static int jugadasMax;
    private static boolean repetirLletres = false;
    private static char[] lletres = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O'};
    private static char[] jugada;
    private static char[] pensat;
    private static int lletresEscollir;

    private static boolean contingudes(char[] lletres, String s) {//Comprobar inputs
        String cadena = passaCadena(lletres);
        return cadena.contains(s);
    }

    private static char[] pensaLletres(char[] lletres, int quantes) {
        String string = passaCadena(lletres);
        string = string.substring(0, quantes);
        List<String> letters = Arrays.asList(string.split(""));
        Collections.shuffle(letters);
        String shuffled = "";
        for (String letter : letters) {
            shuffled += letter;
        }
        return passaVector(shuffled);
    }

    private static char[] pensaRepetides(char[] lletres, int quantes) {
        char[] tablero = new char[quantes];
        for (int i = 0; i < tablero.length; i++) {
            tablero[i] += lletres[(int) (Math.random() * quantes)];
        }
        return tablero;
    }

    private static void llegeixDades() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Escoje un numero de letras de donde seleccionar, por ejemple (2-6):");
//        int lletresJugar = teclado.nextInt();
        lletresJugar = 4;
        System.out.print("Escoje un numero de letras para jugar por ejemple (1-6):");
//        int lletresEscollir = teclado.nextInt();
        lletresEscollir = 4;
        System.out.print("Numero maximo de jugadas antes de terminar la partida: ");
//        int jugadasMax = teclado.nextInt();
        jugadasMax = 12;//NO SE EJECUTAN LAS 12

    }

    static char[] passaVector(String s) {
        jugada = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            jugada[i] = s.charAt(i);
        }
        return jugada;
    }

    static String passaCadena(char[] lletres) {
        String v = new String(lletres);
        return v;
    }

    static boolean properaJugada() {
//        Scanner teclado = new Scanner(System.in);
        System.out.print("\n Jugada " + numJugada + " : ");//        String s = teclado.nextLine();
        String s = "ABCD";
        System.out.println(s);
        jugada = passaVector(s);
        int B = 0, R = 0;
        for (int i = 0; i < jugada.length; i++) {
            if (pensat[i] == jugada[i]) {
                B++;
            } else {
                for (int k = 0; k < jugada.length; k++) {
                    if (jugada[i] == pensat[k])
                        R++;
                }
            }
        }
        numJugada++;
        if (B >= 1 && B != jugada.length) {
            System.out.print(B + "B ");
        }
        if (R >= 1) {
            System.out.print(R + "R ");
        } else if (B == jugada.length) {
            System.out.println("Felicidades, has encontrado la combinacion en el intento " + numJugada);
            return true;
        }
        return false;
    }
//    private static int llegeixInt(String missatge, int min, int max) {
//
//    }

    public static void main(String[] args) {
        llegeixDades();
        if (!repetirLletres)
            pensat = pensaLletres(lletres, lletresJugar);
        else
            pensat = pensaRepetides(lletres, lletresJugar);
        // Si volem saber les lletres que s'han pensat, descomentar
        System.out.println(" ");
        System.out.println(java.util.Arrays.toString(pensat));
        while (!properaJugada() && numJugada <= jugadasMax) {
//            jugadasMax--;
            properaJugada();
        }
        if (numJugada > jugadasMax)
            System.out.println("\nHo sento, no l'has encertat.  Torna a jugar");
    }
}


