package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Why {
    static void Master() {
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        System.out.print("Escoje un numero de letras de donde seleccionar, por ejemple (2-15):");
        int charToSelect = teclado.nextInt();

        System.out.print("Escoje un numero de letras para jugar por ejemple (1-15):");
        int letrasJugar = teclado.nextInt();

        System.out.print("Numero maximo de jugadas antes de terminar la partida: ");
        int partidasNumber = teclado.nextInt();

        char[] Colors = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O'};

        char[] retorna = new char[charToSelect];
        for (int i = 0; i < retorna.length; i++) {
            retorna[i] = Colors[i];
        }

        System.out.println("Tus letras son: " + Arrays.toString(retorna));

        System.out.print("Jugada :");
        String miJugada = teclado.nextLine();//CASTTOUPER

    }

    public static void main(String[] args) {
        Master();
    }
}
