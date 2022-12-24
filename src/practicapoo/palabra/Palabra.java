package practicapoo.palabra;

import practicapoo.enums.Letras;
import java.util.concurrent.ThreadLocalRandom;

public class Palabra {
    private char[] palabra;
    private Letras numLetras;
    private boolean regaloDeLetra;

    public Palabra(String pal) {
        if (pal.length() == 5) {
            this.numLetras = Letras.CINCO;
        } else if (pal.length() == 6) {
            this.numLetras = Letras.SEIS;
        }
        palabra = new char[numLetras.getSize()];
        for (int i = 0; i < pal.length(); i++) {
            this.palabra[i] = pal.charAt(i);
        }
        this.regaloDeLetra = true; // Tienes disponible el regalo
    }

    public Letras getNumLetras() {
        return numLetras;
    }

    public void jugar() {
    }

    private void comprobarColocadas(char[] palabraMisteriosa, char[] miIntento) {
        for (int i = 0; i < numLetras.getSize(); i++) {
            if (palabraMisteriosa[i] == miIntento[i]) {
                //Interfaz verde
            }
        }
    }

    private int numApariciones(char c, String palabraMisteriosa) {
        int res = 0;
        for (int i = 0; i < palabraMisteriosa.length(); i++) {
            if (palabraMisteriosa.charAt(i) == c) res++;
        }
        return res;
    }

    private void comprobarDistintaPosicion(char[] palabraMisteriosa, char[] miIntento) {
        String s1 = new String(palabraMisteriosa);
        String s2 = new String(miIntento);
        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            if (numApariciones(c, s1) > 0 && s1.charAt(i) != s2.charAt(i)) {
                //Interfaz amarillo
            } else {
                //Interfaz gris
            }
        }
    }

    public void mostrarIntentoResuelto() {

    }

    public int puntosObtenidos(int numIntentos) {
        return (6 - numIntentos);
    }

    public void sacarPalabraAleatoria(AlmacenDePalabras almacen) {

        if (numLetras == Letras.CINCO) {
            int indice = ThreadLocalRandom.current().nextInt(0, almacen.getPalabrasDeCinco().length);
            Palabra[] pals = almacen.getPalabrasDeCinco();

            Palabra pal = pals[indice];

            for (int i = 0; i < pal.toString().length(); i++) {
                this.palabra[i] = pal.toString().charAt(i);
            }
        } else {
            int indiceAleatorio = ThreadLocalRandom.current().nextInt(0, almacen.getPalabrasDeSeis().length);
            Palabra[] pals = almacen.getPalabrasDeSeis();
            Palabra pal = pals[indiceAleatorio];

            for (int i = 0; i < pal.toString().length(); i++) {
                this.palabra[i] = pal.toString().charAt(i);
            }
        }
    }

    public void secuenciaResultados() {

    }

}
