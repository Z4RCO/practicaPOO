package practicapoo.palabra;

import practicapoo.Configuracion;
import practicapoo.enums.*;
import practicapoo.interfaz.InterfazPalabra5;
import practicapoo.interfaz.Main;

public class Palabra {
    private char[] palabra;
    private Intento[] intentos;
    private Letras numLetras;
    private boolean regaloDeLetra;
    private AlmacenDePalabras almacen;

    private InterfazPalabra5 interfaz;
    private PistaDeLetra pistaDeLetra;

    public void setInterfaz(InterfazPalabra5 interfaz) {
        this.interfaz = interfaz;
    }
    public boolean getRegaloDeLetra(){
        return regaloDeLetra;
    }

    public void setPalabra(char[] palabra) {
        this.palabra = palabra;
    }
    public InterfazPalabra5 getInterfaz(){
        return this.interfaz;
    }

    public Palabra() {
        this.numLetras = Configuracion.getNumLetras();
        this.intentos = new Intento[numLetras.getSize()];
        pistaDeLetra = new PistaDeLetra();
        palabra = new char[numLetras.getSize()];
        this.regaloDeLetra = true;
        almacen = Main.getPalabras();
    }

    public void jugar(char[] intento, int numIntento) {
        //TODO COmprobar el número de intentos y si se ha acertado
        intentos[numIntento] = new Intento(intento);
        comprobarColocadas(intento);
        comprobarDistintaPosicion(intento);
    }

    private void comprobarColocadas(char[] miIntento) {
        String s1 = new String(this.palabra);
        String s2 = new String(miIntento);
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                interfaz.cambiarColor(Colores.VERDE, i);
            }
        }
    }

    private int numApariciones(char c) {
        int res = 0;
        String s1 = new String(this.palabra);
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == c) {
                res++;
            }
        }
        return res;
    }

    private void comprobarDistintaPosicion(char[] miIntento) {
        String s1 = new String(this.palabra);
        String s2 = new String(miIntento);
        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            if (numApariciones(c) > 0 && s1.charAt(i) != s2.charAt(i)) {
                interfaz.cambiarColor(Colores.AMARILLO, i);
            } else if(numApariciones(c) == 0){
                interfaz.cambiarColor(Colores.GRIS, i);
            }
        }
    }

    public int puntosObtenidos() {
        return (6);
    }

    public void sacarPalabraAleatoria() {
        if (numLetras == Letras.CINCO) {
            Palabra[] palabras = almacen.getPalabrasDeCinco();
            int rnd = (int) (Math.random() * palabras.length);
            this.palabra = palabras[rnd].palabra;
        } else if (numLetras == Letras.SEIS) {
            Palabra[] palabras = almacen.getPalabrasDeSeis();
            int rnd = (int) (Math.random() * palabras.length);
            this.palabra = palabras[rnd].palabra;
        }
    }

    public void setAlmacen(AlmacenDePalabras almacen) {
        this.almacen = almacen;
    }

    public void secuenciaResultados() {
    }

}
