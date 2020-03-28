package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static void MasterMind() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Escoje un numero de letras de donde seleccionar, por ejemple (2-15):");
        int charToSelect = teclado.nextInt();

        System.out.print("Escoje un numero de letras para jugar por ejemple (1-15):");
        int letrasJugar = teclado.nextInt();


        System.out.print("Numero maximo de jugadas antes de terminar la partida");
        int partidasNumber = teclado.nextInt();


        char[] Colors = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O'};
        char retorna[] = new char[charToSelect];
        for (int i = 0; i < retorna.length; i++) {
            retorna[i] = Colors[i];
        }
        fillArray(retorna, letrasJugar, partidasNumber);

        System.out.println("Tus letras son: " + Arrays.toString(retorna));
        int contador = 1;
        System.out.print("Jugada " + contador + ":");

        int miJugada = teclado.nextInt();
    }

    public static char[] fillArray(char toSelect[], int inputJugada, int Cuatesjugadas) {
        char Tablero[] = new char[inputJugada * Cuatesjugadas];
        for (int i = 0; i < Tablero.length; i++) {
            Tablero[i] += toSelect[(int) (Math.random() * toSelect.length)];
        }
        return Tablero;
    }


    public static void main(String[] args) {
        MasterMind();
    }
}
