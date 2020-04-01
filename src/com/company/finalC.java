package com.company;

import java.util.*;

public class finalC {
    private static int lletresEscollir; // Número de lLetres entre les que podem escollir  (Ex: 6)
    private static int lletresJugar;    // Número de lletres que jugarem   (Ex: 4)
    private static int numJugada = 1;   // Número de la jugada actual, 1 per a la primera jugada
    private static int jugadasMax;      // Número màxim de jugades que farem
    private static boolean repetirLletres = false;      // No es deixen repetir lletres a la combinació (o si)
    private static char[] lletres = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O'};
    private static char[] jugada;      // Manté un array amb la jugada actual	(Ex:  [A,C,A,F]
    private static char[] pensat;      // Manté un array amb la combinació que ha pensat la màquina (Ex: [B,A,C,A])


    private static boolean contingudes(char[] lletres, String s) {
        String cadena = passaCadena(lletres);
        return cadena.contains(s);
    }

    private static char[] pensaLletres(char[] lletres, int quantes) {
        String string = passaCadena(lletres);
        List<String> letters = Arrays.asList(string.split(""));
        Collections.shuffle(letters);
        String shuffled = "";
        for (String letter : letters) {
            shuffled += letter;
        }
        return passaVector(shuffled.substring(0, quantes));
    }

    private static char[] pensaRepetides(char[] lletres, int quantes) {
        char[] tablero = new char[quantes];
        for (int i = 0; i < tablero.length; i++) {
            tablero[i] += lletres[(int) (Math.random() * lletres.length)];
        }
        return tablero;
    }

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

    // // Pide al usuario que introduzca la próxima jugada, y la compara con la jugada que ha pensado
// // el programa. Le dice al usuario las letras que tiene bien y las que tiene regular (está la letra pero
// // mal puesta)
// // Incrementa el número de jugadas, y si el usuario acierta todas las letras, le felicita y devuelve
// // true, indicando que se ha terminado la partida. En caso contrario, devuelve false para continuar jugando.
    static boolean properaJugada() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("\n Jugada " + numJugada + " : ");
        String s = teclado.nextLine();
        jugada = passaVector(s);
        int B = 0;
        int R = 0;
        for (int i = 0, j = 0; i < jugada.length; i++) {
            if (pensat[i] == jugada[i]) {
                B++;
            } else if (pensat[j] == jugada[i]) {
                R++;
                j++;
            }
        }
        if (B >= 1 && B != jugada.length) {
            System.out.print(B + "B ");
        } else if (R >= 1) {
            System.out.print(B + "B ");
        } else if (B == jugada.length) {
            System.out.println("Felicidades, has encontrado la combinacion en el intento " + numJugada);
            return true;
        }
        if (numJugada > 1 && B != jugada.length) {
            numJugada--;
            properaJugada();
        } else if (numJugada == 1) {
            System.out.println("Lo siento, no has acerdado, intenta jugar otra vez");
            return false;
        }

        return false;
    }

//    private static int llegeixInt(String missatge, int min, int max) {
//
//    }

    public static void main(String[] args) {
        // Programa principal, s'indica complet a falta de les funcions
        llegeixDades();
        if (!repetirLletres)
            pensat = pensaLletres(lletres, lletresJugar);
        else
            pensat = pensaRepetides(lletres, lletresJugar);
        // Si volem saber les lletres que s'han pensat, descomentar
        System.out.println(java.util.Arrays.toString(pensat));
        while (!properaJugada() && numJugada <= jugadasMax) ;
        if (numJugada > jugadasMax)
            System.out.println("Ho sento, no l'has encertat.  Torna a jugar");
    }
}


