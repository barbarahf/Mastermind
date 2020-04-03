///**
// * @author Barbara Herrera Flores
// */
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class MasterMindfinal {
//    // Variables globals que ens podem plantejar per no passar tants paràmetres entre les funcions. Es pot reduïr
//    private static int lletresEscollir; // Número de lLetres entre les que podem escollir  (Ex: 6)
//    private static int lletresJugar;    // Número de lletres que jugarem   (Ex: 4)
//    private static int numJugada = 1;   // Número de la jugada actual, 1 per a la primera jugada
//    private static int jugadasMax;      // Número màxim de jugades que farem
//    private static boolean repetirLletres = false;      // No es deixen repetir lletres a la combinació (o si)
//    private static char[] lletres;     // Manté un array amb totes les lletres possibles  (Ex:  [A,B,C,D,E,F])
//    private static char[] jugada;      // Manté un array amb la jugada actual	(Ex:  [A,C,A,F]
//    private static char[] pensat;      // Manté un array amb la combinació que ha pensat la màquina (Ex: [B,A,C,A])
//
//
//    private static boolean contingudes(char[] lletres, String s) {
//        // Retorna true si totes les lletes de s estan contingudes al vector.  Es fa servir per comprovar
//        // que les lletres introduïdes per l'usuari son vàlides (li passem el vector amb totes les possibles)
//
//    }
//
//    private static char[] pensaLletres(char[] lletres, int quantes) {
//        // Li pasem en quantes el número de lletres que hem de pensar, i retorna un vector de
//        // longitud quantes, amb les lletres pensades, escollides (sense repetir) de lletres
//
//    }
//
//    private static char[] pensaRepetides(char[] lletres, int quantes) {
//        // Li pasem en quantes el número de lletres que hem de pensar, i retorna un vector de
//        // longitud quantes, amb les lletres pensades, escollides (repetint les lletres)
//
//    }
//
//    private static int llegeixInt(String missatge, int min, int max) {
//        // Llegeix un enter positiu entre min i max amb control d'errors.  No retorna de la funció
//        // fins que el valor llegit és vàlid.  Proporciona els missatges d'error convenients
//
//    }
//
//    private static void llegeixDades() {
//
//        Scanner teclado = new Scanner(System.in);
//        System.out.print("Escoje un numero de letras de donde seleccionar, por ejemple (2-6):");
//        int lletresJugar = teclado.nextInt();
//
//        System.out.print("Escoje un numero de letras para jugar por ejemple (1-6):");
//        int lletresEscollir = teclado.nextInt();
//
//        System.out.print("Numero maximo de jugadas antes de terminar la partida: ");
//        int jugadasMax = teclado.nextInt();
//
//    }
//
//    static char[] passaVector(String s) {
//        char[] miJugada = new char[jugada.length()];
//        for (int i = 0; i < jugada.length(); i++) {
//            miJugada[i] = jugada.charAt(i);
//        }
//        return miJugada;
//
//    }
//
//    static String passaCadena(char[] lletres) {
//        // Converteix un vector de char en una cadena.  L'usuari introdueix cadenes
//        // e internament les guardem com vectors de char.
//
//    }
//
//    static boolean properaJugada() {
//        // Demana a l'usuari que introdueixi la propera jugada, i la compara amb la jugada que ha pensat
//        // el programa.  Li diu a l'usuari les lletres que té be i les que té regular (està la lletra però
//        // mal posada)
//        // Incrementa el número de jugades, i si l'usuari encerta totes les lletres, li felicita i retorna
//        // true, indicant que s'ha acabat la partida.  En cas contrari, retorna false per continuar jugant.
//
//
//    }
//
//
//    public static void main(String[] args) {
//        // Programa principal, s'indica complet a falta de les funcions
//        llegeixDades();
//        if (!repetirLletres)
//            pensat = pensaLletres(lletres, lletresJugar);
//        else
//            pensat = pensaRepetides(lletres, lletresJugar);
//        // Si volem saber les lletres que s'han pensat, descomentar
//        // System.out.println(java.util.Arrays.toString(pensat));
//        while (!properaJugada() && numJugada <= jugadasMax) ;
//        if (numJugada > jugadasMax)
//            System.out.println("Ho sento, no l'has encertat.  Torna a jugar");
//    }
//}
