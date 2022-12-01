

package practicapoo.palabra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Palabra {
    private enum NumLetras {
        CINCO,
        SEIS,

    }
    private static char[] palabra;
    private boolean regaloDeLetra;
    private Intento[] intento;
    private int numIntentos;

    //TODO Hacer constructor


    public Intento[] getIntento() {
        return intento;
    }

    public static char[] getPalabra() {
        return palabra;
    }

    public int getNumIntentos() {
        return numIntentos;
    }

    public static boolean enAlfabeto(String s) {
        /* devuelve true si todos los caracteres de s están en el alfabeto y false en caso contrario */
        boolean result = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (! Character.isAlphabetic(c)) {
                result = false;
            }
        }
        return result;
    }

    public static boolean intentoValido(String inten) {
        /* comprueba el String inten y devuelve true si cumple el formato de palabra
         * o false en caso contrario */
        boolean result = false;
        if (inten.length() == NumLetras && enAlfabeto(inten)) {
            result = true;
        }else if(inten.length() != NumLetras){
            System.out.println("La palabra debe contener " + NumLetras +" letras.");
        }else if(inten.length() == NumLetras && ! enAlfabeto(inten)){
            System.out.println("La palabra solo puede contener letras del alfabeto. ");
        }
        return result;
    }


    public static String leerIntento(int numeroIntento, Scanner consola) {
        /* lee un único intento del usuario y lo devuelve
         * parámetros:
         *   numeroIntento - número del intento por el que va
         *   consola - la palabra que meta el usuario
         */
        String s;
        do {
            System.out.print("Intento número " + numeroIntento + ": ");
            s = consola.next();
        } while (! intentoValido(s));

        return s.toLowerCase();
    }

    public static boolean incluye(String s, char c){
        /* devuelve true si c está en s y false en caso contrario */
        return s.contains(c + "");
    }

    public void jugar(){

    }

    public static boolean procesarIntento(String sIntento, String sPalabra){
        String result = "";
        boolean returnval = true;
        for (int i = 0; i < sIntento.length(); i++) {
            int test = numApariciones(sIntento.charAt(i), sPalabra.substring(i));
            if (sIntento.charAt(i) == sPalabra.charAt(i)){
                result += sIntento.charAt(i);
                result += " ";
            }else if(incluye(sPalabra, sIntento.charAt(i))){
                if (numApariciones(sIntento.charAt(i), sIntento) > numApariciones(sIntento.charAt(i), sPalabra)){
                    if (numInSamePosn(sIntento.charAt(i), sIntento, sPalabra) == 0 && test != 0){
                        result += "[" + sIntento.charAt(i) + "]";
                        result += " ";
                        returnval = false;
                        test --;
                    }else{
                        result += "_";
                        result += " ";
                    }
                }else{
                    result += "[" + sIntento.charAt(i) + "]";
                    result += " ";
                    returnval = false;}
            }else{
                result += "_";
                result += " ";
                returnval = false;
            }
        }
        System.out.println(result);
        return returnval;
    }
    
    private void comprobarColocadas(){
        String comp = new String(getIntento()[numIntentos].recogerIntento()); //Palabra a comparar
        String pal = new String(getPalabra());
        for (int i = 0; i < comp.length(); i++) {
            char c = comp.charAt(i);
            if (comp.charAt(i) == c && c == pal.charAt(i)) {
                System.out.println("La letra " + c + " de la posición" + i + " está en el lugar correcto");
            }
        }
    }

    public static int numApariciones(char c, String s){
        /* Cuenta y devuelve el número de veces que c ocurre en la palabra */
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c)
                result += 1;
        }
        return result;
    }

    private void comprobarDistintaPosicion(){

    }

    public void mostrarIntentoResuelto(){
        String s = new String(getPalabra());
        System.out.println(s);

    }

    public int puntosObtenidos(){
        return 0;
    }

    public void sacarPalabraAleatoria(){
        //Ficheros

    }

    public void secuenciaResultados(){
        for (int i = 0; i<=numIntentos; i++){
            System.out.println(getIntento()[i]);
        }
    }

}
