package practicapoo.palabra;

import java.util.Scanner;

public class Palabra {
    private enum NumLetras {
        CINCO,
        SEIS,
    }
    private char[] palabra;
    private boolean regaloDeLetra;

    public Palabra(String pal) {
        //this.NumLetras = pal.length();
        for(int i = 0; i < pal.length(); i++){
            this.palabra[i] = pal.charAt(i);
        }
        this.regaloDeLetra = false; // Todavía no ha usado el regalo
    }

    public void jugar(int numIntentos){
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

    }

}
