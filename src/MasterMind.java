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

    static Scanner teclado = new Scanner(System.in).useDelimiter("\n");//Delimitador para evitar errores

    private static void llegeixDades() {
        System.out.println("PROGRAMA MASTERMIND AMB LLETRES, HAS ENDEVINAR LA COMBINACIÓ QUE PENSARÉ");
        String missatge = "Escull un nombre de lletres d'on seleccionar, per exemple (2-15): ";
        lletresEscollir = llegeixInt(missatge, 2, 15);
        String letras = "ABCDEFGHIJKLMNO";
        letras = letras.substring(0, lletresEscollir);
        lletres = passaVector(letras);
        String missatge2 = "Escull un nombre de lletres per jugar, per exemple (1-15): ";
        lletresJugar = llegeixInt(missatge2, 1, 15);

        if (lletresEscollir > lletresJugar) {//Control de repetidas
            String sn;
            do {
                System.out.print("Vols que hi hagi lletres repetides en el joc? S/N:  ");
                sn = teclado.nextLine().toUpperCase();
                if (sn.equals("S")) {
                    System.out.println("Hi haurà lletres repetides en la combinació per encertar");
                    repetirLletres = true;
                } else if (sn.equals("N")) {
                    System.out.println("No hi haurà lletres repetides en la combinació per encertar");
                    repetirLletres = false;
                }
            } while (!(sn.matches("N") || sn.matches("S")));
        }

        String missatge3 = "Nombre màxim de jugades abans d'acabar la partida 1/100: ";
        jugadasMax = llegeixInt(missatge3, 1, 100);


        System.out.println("Introdueix un total " + lletresJugar + " de lletres entre les que s'indiquen a continuació: ");
        System.out.println(Arrays.toString(lletres));
    }

    private static int llegeixInt(String missatge, int min, int max) {
        String intro;/*Sirve para comprobar un input numerico, la forma más factible es meidante strings y luego
        utilizar Integer.parseInt*/
        do {
            System.out.print(missatge);
            intro = teclado.nextLine();
        } while (!intro.matches("[0-9]*") || intro.contains(" ") || intro.equals("")
                /*Control de cadenas vacías y numeros, evitando cifras extremas basandome en la longitud,
                así evitar las excepciones*/
                || intro.length() > 4 || Integer.parseInt(intro) < min || Integer.parseInt(intro) > max);
        return Integer.parseInt(intro);
    }

    private static boolean contingudes(char[] lletres, String s) {
        for (int i = 0; i < s.length(); i++)
            if (passaCadena(lletres).indexOf(s.charAt(i)) == -1) {//Obtener los caracteres que no coinciden.
                System.out.println("El valor introduit '" + s.charAt(i) + "' en la posició " + (i + 1) + " no és vàlid.");
                return false;
            }
        return true;
    }

    private static char[] pensaLletres(char[] lletres, int quantes) {
        //Shuffled es la mejor forma para obtener caracteres no repetidos
        String string = passaCadena(lletres);
        List<String> letters = Arrays.asList(string.split(""));
        Collections.shuffle(letters);
        String shuffled = "";
        for (String letter : letters) shuffled += letter;
        String s = shuffled.substring(0, quantes);//Seleccionar los caracteres necesarios generados aleatoriamente
        return passaVector(s);
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
        return new String(lletres); //Transformar vector en cadena, esta es la forma más corta.
    }

    static boolean properaJugada() {
        String s;
        do {
            System.out.print("\nJugada " + numJugada + " : ");
            s = teclado.nextLine().toUpperCase();//Tambien recibe minusculas

        } while (!contingudes(lletres, s) || s.length() > lletresJugar || s.length() < lletresJugar);

        jugada = passaVector(s);
        int B = 0, R = 0;//Encontrar las posiciones
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
        do {
            properaJugada();
        } while (!properaJugada() && numJugada <= jugadasMax);
        if (numJugada > jugadasMax)
            System.out.println("\nHo sento, no l'has encertat.  Torna a jugar");
    }
}

