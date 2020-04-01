package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class Mastermind {
    public static int contador = 0;

    public static void MasterMind() {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Escoje un numero de letras de donde seleccionar, por ejemple (2-6):");
        int charToSelect = teclado.nextInt();

        System.out.print("Escoje un numero de letras para jugar por ejemple (1-6):");
        int letrasJugar = teclado.nextInt();

        System.out.print("Numero maximo de jugadas antes de terminar la partida: ");
        int partidasNumber = teclado.nextInt();

        char[] Colors = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O'};
        char[] retorna = new char[charToSelect];
        for (int i = 0; i < retorna.length; i++) {
            retorna[i] = Colors[i];
        }
        System.out.println("Tus letras son: " + Arrays.toString(retorna));
        juego(tablero(retorna, letrasJugar), inputJugada(), partidasNumber);
    }

    public static char[] inputJugada() {
        Scanner teclado = new Scanner(System.in);
        contador++;
        System.out.println("Jugada " + contador + " : ");
        String jugada = teclado.nextLine();
        char[] miJugada = new char[jugada.length()];
        for (int i = 0; i < jugada.length(); i++) {
            miJugada[i] = jugada.charAt(i);
        }
        System.out.println(Arrays.toString(miJugada));
        return miJugada;
    }

    public static char[] tablero(char v[], int jugada) {
        char[] tablero = new char[jugada];
        for (int i = 0; i < tablero.length; i++) {
            tablero[i] += v[(int) (Math.random() * v.length)];
        }
        System.out.println("este es el tablero" + Arrays.toString(tablero));
        return tablero;
    }

    public static void juego(char tablero[], char jugada[], int numPartidas) {
        int blancas = 0;
        int negras = 0;
        for (int i = 0, j = 0; i < jugada.length; i++) {
            if (tablero[i] == jugada[i]) {
                blancas++;
            } else if (tablero[j] == jugada[i]) {
                negras++;
                j++;
            }
        }
        if (blancas >= 1 && blancas != jugada.length) {
            System.out.print(blancas + "B ");
        } else if (negras >= 1) {
            System.out.print(blancas + "B ");
        } else if (blancas == jugada.length) {
            System.out.println("Felicidades, has encontrado la combinacion en el intento " + contador);
        }
        if (numPartidas > 1 && blancas != jugada.length) {
            numPartidas--;
            juego(tablero, inputJugada(), numPartidas);
        } else if (numPartidas == 1) {
            System.out.println("Lo siento, no has acerdado, intenta jugar otra vez");
        }


    }

    public static void main(String[] args) {
        MasterMind();
    }
}
