

package practicapoo.palabra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Palabra {
    private enum numLetras{
        Cinco,
        Seis,
    }
    private char[] palabra;
    private boolean regaloDeLetra;
    private Intento[] intento;
    private int numIntentos;

    //TODO Hacer constructor




    public void jugar(){

    }

    private void comprobarColocadas(){

        for(int i = 0; i< palabra.length; i++){
            char[] comp = intento[numIntentos].recogerIntento; //Palabra a comparar
            if(palabra[i]==comp[i]){
                // Cuadrado verde;
            }
        }

    }

    private void comprobarDistintaPosicion(){
        ArrayList <Character> l = new ArrayList<Character>(palabra);

    }

    public void mostrarIntentoResuelto(){


    }

    public int puntosObtenidos(){
        return 0;
    }

    public void sacarPalabraAleatoria(){


    }

    public void secuenciaResultados(){

    }

}
