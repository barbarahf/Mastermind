package com.company;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    private static Scanner teclado = new Scanner(System.in);//Variable global

    static void MasterMind() {

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
        }//CREACION DE OPCIONES

        System.out.println("Tus letras son: " + Arrays.toString(retorna));
        //COMENZAR A JUGAR
        int contador = 0;
        while (partidasNumber <= contador) {
            InputJugador();
            contador++;
        }
    }


    //Rellenar lo datos de la partida, el numero de jugadas y creacion del tablero
    public static char[] fillArray(char toSelect[], int inputJugada, int Cuantasjugadas) {
//        char[] copyV = Arrays.copyOf(toSelect, toSelect.length);//Ineficiente Borrar//Creoquehayquecopiar
//        char[] copyV = Arrays.copyOf(toSelect, toSelect.length);//Ineficiente Borrar//Creoquehayquecopiar
        char Tablero[] = new char[inputJugada * Cuantasjugadas];
        for (int i = 0; i < Tablero.length; i++) {
            Tablero[i] += toSelect[(int) (Math.random() * toSelect.length)];
        }
        return Tablero;
    }

    public static void InputJugador() {
        System.out.print("Jugada :");
        String miJugada = teclado.nextLine();
        char[] miJugadaA = new char[miJugada.length()];
        for (int i = 0; i < miJugada.length(); i++) {
            miJugadaA[i] = miJugada.charAt(i);
        }
        System.out.println(Arrays.toString(miJugadaA));
    }

    //Comparar si son validas las posiciones o no, fichas negras y blancas.
    public static void juego(char tablero[], char input[]) {//Posiciones iguales, retorna las negras
        for (int i = 0; i < input.length; i++) {
            if (tablero[i] == input[i]) {
                System.out.println(i + "  Acertada, Blanca");
            } else {//Ojo con esto, no es factible
                for (int j = 0; j < input.length; j++) {
                    if (tablero[j] == input[i]) {
                        System.out.println(i + "  Acertada, negra");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
//        MasterMind();
//        char[] Colors = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',};
//        char[] jugada = {'A', 'B', 'C', 'D'};

    }

}
