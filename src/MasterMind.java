import java.util.*;

public class MasterMind {
    private static int lletresJugar;
    private static int numJugada = 1;
    private static int jugadasMax;
    private static boolean repetirLletres = false;
    private static char[] lletres;
    private static char[] jugada;
    private static char[] pensat;
    private static int lletresEscollir;

    static Scanner teclado = new Scanner(System.in).useDelimiter("\n"); //Scanner global

    private static void llegeixDades() {
        String missatge = "Escoge un numero de letras de donde seleccionar, por ejemple (2-15): ";
        lletresEscollir = llegeixInt(missatge, 2, 15);
        String letras = "ABCDEFGHIJKLMNO";
        letras = letras.substring(0, lletresEscollir);
        lletres = passaVector(letras);
        String missatge2 = "Escoge un numero de letras para jugar, por ejemplo (1-15): ";
        lletresJugar = llegeixInt(missatge2, 1, 15);


        if (lletresEscollir > lletresJugar) {
            Scanner teclado = new Scanner(System.in);
            System.out.print("Vols que hi hagi lletres repetides en el joc? S/N:  ");
            boolean aux;//Podria mejorarse con InputMismatchException?catch try what wateva
            do {
                aux = true;
                String input = teclado.nextLine();
                if ("S".contains(input))
                    repetirLletres = true;
                else if ("N".contains(input))
                    repetirLletres = false;
                else {
                    System.out.print("Error de input, intente con S o N: ");
                    aux = false;
                }
            } while (!aux);
        }


        System.out.print("Numero maximo de jugadas antes de terminar la partida 1/100: ");
        jugadasMax = teclado.nextInt();


        System.out.println("Introdueix un total" + lletresJugar + " de lletres entre les que s'indiquen a continuació: ");
        System.out.println(Arrays.toString(lletres));
    }


    private static int llegeixInt(String missatge, int min, int max) {
        int intro;
        do {
            System.out.print(missatge);
            intro = teclado.nextInt();
        } while (intro < min || intro > max);
        return intro;
    }

    private static boolean contingudes(char[] lletres, String s) {//Comprobar inputs
        String cadena = passaCadena(lletres);
        String r = cadena.toUpperCase();
        return r.contains(s);
    }
/////////////////////////////////////////////////////////////////


    private static char[] pensaLletres(char[] lletres, int quantes) {
        String string = passaCadena(lletres);
        List<String> letters = Arrays.asList(string.split(""));
        Collections.shuffle(letters);
        String shuffled = "";
        for (String letter : letters) shuffled += letter;
        return passaVector(shuffled.substring(0, quantes));
    }

    private static char[] pensaRepetides(char[] lletres, int quantes) {
        char[] tablero = new char[quantes];
        for (int i = 0; i < tablero.length; i++) {
            tablero[i] += lletres[(int) (Math.random() * lletres.length)];
        }
        return tablero;
    }

    static char[] passaVector(String s) {
        jugada = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            jugada[i] = s.charAt(i);
        }
        return jugada;
    }

    static String passaCadena(char[] lletres) {
        return new String(lletres);
    }

    static boolean properaJugada() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Jugada " + numJugada + " : ");
        String s = teclado.nextLine();
        jugada = passaVector(s);
        /*Todo esto control de errores*/
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
        if (B >= 1 && B != jugada.length) {
            System.out.print(B + "B ");
        }
        if (R >= 1) {
            System.out.print(R + "R ");
        } else if (B == jugada.length) {
            System.out.println("Felicitats, has trobat la combinació en l'intent " + numJugada);
            return true;
        }
        numJugada++;
        return false;
    }

    public static void main(String[] args) {
        llegeixDades();
        if (!repetirLletres)
            pensat = pensaLletres(lletres, lletresJugar);
        else
            pensat = pensaRepetides(lletres, lletresJugar);

        System.out.println(java.util.Arrays.toString(pensat));

        while (!properaJugada() && numJugada < jugadasMax) {
            properaJugada();
        }
        if (numJugada > jugadasMax)
            System.out.println("\nHo sento, no l'has encertat.  Torna a jugar");
    }
}
