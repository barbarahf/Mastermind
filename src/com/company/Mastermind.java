package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Mastermind {
    public static void MasterMind() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Escoje un numero de letras de donde seleccionar, por ejemple (2-6):");
//        int charToSelect = teclado.nextInt();
        int charToSelect = 2;
        System.out.print("Escoje un numero de letras para jugar por ejemple (1-6):");
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
        System.out.println("Tus letras son: " + Arrays.toString(retorna));
        juego(tablero(Colors, letrasJugar, partidasNumber), inputJugada(), partidasNumber);
    }

    public static char[] inputJugada() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Jugada :");
        String jugada = teclado.nextLine();
        char[] miJugada = new char[jugada.length()];
        for (int i = 0; i < jugada.length(); i++) {
            miJugada[i] = jugada.charAt(i);
        }
        System.out.println(Arrays.toString(miJugada));
        return miJugada;
    }

    public static char[] tablero(char v[], int jugada, int Cuantasjugadas) {
        char[] tablero = new char[jugada * Cuantasjugadas];
//        for (int i = 0; i < tablero.length; i++) {
//            tablero[i] += v[(int) (Math.random() * v.length)];
//        }
        tablero = new char[]{'B', 'A', 'B', 'B', 'B', 'A', 'B', 'A'};
        System.out.print("este es el tablero" + Arrays.toString(tablero));
        System.out.println("");
        return tablero;
    }

    public static void juego(char tablero[], char jugada[], int numPartidas) {//Posiciones iguales, retorna las negras
        char[] v = new char[tablero.length];
        System.arraycopy(tablero, 0, v, 0, tablero.length);
        for (int i = 0; i < jugada.length; i++) {
            if (v[i] == jugada[i]) {
                System.out.print(i + " Acertada, Blanca ");
            } else {//Ojo con esto, no es factible
                for (int j = 0; j < jugada.length; j++) {
                    if (v[j] == jugada[i]) {
                        System.out.print(i + " negra ");
                    }
                }
            }
        }
        if (numPartidas > 1) {
            numPartidas--;
            juego(v, inputJugada(), numPartidas);
        }
    }

    public static void main(String[] args) {
        MasterMind();
    }
}
