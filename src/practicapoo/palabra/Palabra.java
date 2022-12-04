package practicapoo.palabra;

import java.util.Scanner;

public class Palabra {
    private enum NumLetras {
        CINCO,
        SEIS,
    }
    private static char[] palabra;
    private boolean regaloDeLetra;
    private Intento[] intento;

    public Palabra() {
        // this.NumLetras = La longitud que el ususario seleccione en configuración
        sacarPalabraAleatoria(); // Se guarda en el array de chars palabra
        this.regaloDeLetra = false; // Todavía no ha usado el regalo
        for(int i = 0; i < 5; i++){
            intento[i] = new Intento();
        }
    }

    public void jugar(int numIntentos){
        Palabra palabraMisteriosa = new Palabra();
    }

    private void comprobarColocadas(char[] palabraMisteriosa, char[] miIntento){
        String s1 = new String(palabraMisteriosa);
        String s2 = new String(miIntento);
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == s2.charAt(i)){
                //Interfaz verde
            }
        }
    }

    private int numApariciones(char c, String palabraMisteriosa){
        int res = 0;
        for(int i = 0; i < palabraMisteriosa.length(); i++){
            if(palabraMisteriosa.charAt(i) == c){
                res++;
            }
        }
        return res;
    }

    private void comprobarDistintaPosicion(char[] palabraMisteriosa, char[] miIntento){
        String s1 = new String(palabraMisteriosa);
        String s2 = new String(miIntento);
        for(int i = 0; i < s1.length(); i++){
            char c = s2.charAt(i);
            if(numApariciones(c, s1) > 0 && s1.charAt(i) != s2.charAt(i)){
                //Interfaz amarillo
            } else{
                //Interfaz rojo
            }
        }
    }

    public void mostrarIntentoResuelto(){

    }

    public int puntosObtenidos(int numIntentos){
        return (6-numIntentos);
    }

    public void sacarPalabraAleatoria(){
        //Ficheros

    }

    public void secuenciaResultados(){
        for(int i = 0; i < /*La longitud que el ususario seleccione en configuración*/; i++){
            System.out. println(intento[i]);
        }
    }

}
