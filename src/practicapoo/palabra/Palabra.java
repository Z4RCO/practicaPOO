package practicapoo.palabra;

import practicapoo.Configuracion;
import practicapoo.Letras;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Palabra {
    private char[] palabra;
    private Letras numLetras;
    private boolean regaloDeLetra;

    public Palabra(String pal) {
        this.numLetras = pal.length();
        for(int i = 0; i < pal.length(); i++){
            this.palabra[i] = pal.charAt(i);
        }
        this.regaloDeLetra = false; // Todavía no ha usado el regalo
    }

    public Letras getNumLetras() {
        return numLetras;
    }

    public void jugar(){
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

    public void sacarPalabraAleatoria(AlmacenDePalabras almacen){
        int numLetras = Configuracion.getNumLetras().ordinal();
        if( numLetras == 5){
            int indiceAleatorio = ThreadLocalRandom.current().nextInt(0,  almacen.getPalabrasDeCinco().length);
            Palabra[] pals = new Palabra[almacen.getPalabrasDeCinco().length];
            Palabra pal = pals[indiceAleatorio];
            for(int i = 0; i < pal.toString().length(); i++){
                this.palabra[i] = pal.toString().charAt(i);
            }
        }

        if(numLetras == 6){
            int indiceAleatorio = ThreadLocalRandom.current().nextInt(0,  almacen.getPalabrasDeSeis().length);
            Palabra[] pals = new Palabra[almacen.getPalabrasDeSeis().length];
            Palabra pal = pals[indiceAleatorio];
            for(int i = 0; i < pal.toString().length(); i++){
                this.palabra[i] = pal.toString().charAt(i);
            }
        }

    }

    public void secuenciaResultados(){

    }

}
