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


        System.out.print("Numero maximo de jugadas antes de terminar la partida: ");
        int partidasNumber = teclado.nextInt();


        char[] Colors = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O'};
        char retorna[] = new char[charToSelect];
        for (int i = 0; i < retorna.length; i++) {
            retorna[i] = Colors[i];
        }

        System.out.println("Tus letras son: " + Arrays.toString(retorna));
        int contador = 1;
        System.out.print("Jugada " + contador + ":");

        int miJugada = teclado.nextInt();

        fillArray(retorna, letrasJugar, partidasNumber);//Hey
    }

    public static char[] fillArray(char toSelect[], int inputJugada, int Cuatesjugadas) {
        char[] copyV = Arrays.copyOf(toSelect, toSelect.length);//Ineficiente Borrar
        char Tablero[] = new char[inputJugada * Cuatesjugadas];
        for (int i = 0; i < Tablero.length; i++) {
            Tablero[i] += toSelect[(int) (Math.random() * toSelect.length)];
        }
        return Tablero;
    }

    public static void juego(char tablero[], char input[]) {
        for (int i = 0; i < input.length; i++) {
            if (tablero[i] == input[i]) {
                System.out.println(i);
                //Posiciones iguales, retorna las negras
            }
        }
    }

    public static void main(String[] args) {
//        MasterMind();
        char[] Colors = {'A', 'B', 'C', 'D', 'E'};
        char[] jugada = {'A', 'B', 'E', 'D'};
        juego(Colors, jugada);
    }
}
