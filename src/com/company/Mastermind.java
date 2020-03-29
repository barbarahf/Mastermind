package com.company;


import java.util.Arrays;
import java.util.Scanner;

public class Mastermind {
    public static void MasterMind() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Escoje un numero de letras de donde seleccionar, por ejemple (2-15):");
//        int charToSelect = teclado.nextInt();
        int charToSelect = 2;
        System.out.print("Escoje un numero de letras para jugar por ejemple (1-15):");
//        int letrasJugar = teclado.nextInt();
        int letrasJugar = 4;

        System.out.print("Numero maximo de jugadas antes de terminar la partida: ");
//        int partidasNumber = teclado.nextInt();
        int partidasNumber = 2;

        char[] Colors = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O'};
        char[] retorna = new char[charToSelect];
        for (int i = 0; i < retorna.length; i++) {
            retorna[i] = Colors[i];
        }
        System.out.println(" ");
        System.out.println("Tus letras son: " + Arrays.toString(retorna));
        //Jugada
        System.out.println("Jugada :");
        String s = "CABB";//Scanner da error al pasar next line
        System.out.println(Arrays.toString(tablero(retorna, letrasJugar, partidasNumber)));
        juego(tablero(retorna, letrasJugar, partidasNumber), inputJugada(s));


    }

    //Jugada array char
    public static char[] inputJugada(String jugada) {
        char[] miJugada = new char[jugada.length()];
        for (int i = 0; i < jugada.length(); i++) {
            miJugada[i] = jugada.charAt(i);
        }
        System.out.println(Arrays.toString(miJugada));
        return miJugada;
    }

    //Tablero
    public static char[] tablero(char v[], int jugada, int Cuantasjugadas) {
        char[] tablero = new char[jugada * Cuantasjugadas];
//        for (int i = 0; i < tablero.length; i++) {
//            tablero[i] += v[(int) (Math.random() * v.length)];
//        }
        tablero = new char[]{'B', 'A', 'B', 'C'};

        return tablero;
    }

    //JUEGO
    public static void juego(char tablero[], char jugada[]) {//Posiciones iguales, retorna las negras
        for (int i = 0; i < jugada.length; i++) {
            if (tablero[i] == jugada[i]) {
                System.out.println(i + "  Acertada, Blanca");
            } else {//Ojo con esto, no es factible
                for (int j = 0; j < jugada.length; j++) {
                    if (tablero[j] == jugada[i]) {
                        System.out.println(i + "  Acertada, negra");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        MasterMind();
        System.out.println();
    }
}
