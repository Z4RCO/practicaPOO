package practicapoo.palabra;

import practicapoo.Configuracion;
import practicapoo.enums.*;
import practicapoo.interfaz.InterfazPalabra5;
import java.util.concurrent.ThreadLocalRandom;

public class Palabra {
    private char[] palabra;
    private Intento[] intentos;
    private Letras numLetras;
    private boolean regaloDeLetra;

    private InterfazPalabra5 interfaz;
    private PistaDeLetra pistaDeLetra;

    public void setInterfaz(InterfazPalabra5 interfaz) {
        this.interfaz = interfaz;
    }

    public Palabra() {
        this.numLetras = Configuracion.getNumLetras();
        this.intentos = new Intento[numLetras.getSize()];

        //TODO añadir atributo almacenDePalabras
        AlmacenDePalabras almacen = new AlmacenDePalabras();
        almacen.cargarFichero();
        sacarPalabraAleatoria(almacen);
        pistaDeLetra = new PistaDeLetra();
        palabra = new char[numLetras.getSize()];
       this.regaloDeLetra = true;
    }

    public void jugar(char[] intento, int numIntento){
        intentos[numIntento] = new Intento(intento);
        comprobarColocadas(intento);
        comprobarDistintaPosicion(intento);
    }

    private void comprobarColocadas(char[] miIntento){
        String s1 = new String(this.palabra);
        String s2 = new String(miIntento);
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == s2.charAt(i)){
                interfaz.cambiarColor(Colores.VERDE, i);
            }
        }
    }

    private int numApariciones(char c){
        int res = 0;
        String s1 = new String(this.palabra);
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == c){
                res++;
            }
        }
        return res;
    }

    private void comprobarDistintaPosicion(char[] miIntento){
        String s1 = new String(this.palabra);
        String s2 = new String(miIntento);
        for(int i = 0; i < s1.length(); i++){
            char c = s2.charAt(i);
            if(numApariciones(c) > 0 && s1.charAt(i) != s2.charAt(i)){
                interfaz.cambiarColor(Colores.AMARILLO, i);
            } else{
                interfaz.cambiarColor(Colores.GRIS, i);
            }
        }
    }
    public int puntosObtenidos(int numIntentos){
        return (6-numIntentos);
    }

    public void sacarPalabraAleatoria(AlmacenDePalabras almacen){
        almacen.cargarFichero();
        this.numLetras = Configuracion.getNumLetras();
        if(numLetras == Letras.CINCO){
            int indiceAleatorio = ThreadLocalRandom.current().nextInt(0,  almacen.getPalabrasDeCinco().length);
            Palabra[] pals = new Palabra[almacen.getPalabrasDeCinco().length];
            for(int i=0; i<almacen.getPalabrasDeCinco().length; i++){
                pals[i]=almacen.getPalabrasDeCinco()[i];
            }
            Palabra pal = pals[indiceAleatorio];
            for(int i = 0; i < pal.toString().length(); i++){
                this.palabra[i] = pal.toString().charAt(i);
            }
        } else if(numLetras == Letras.SEIS){
            int indiceAleatorio = ThreadLocalRandom.current().nextInt(0,  almacen.getPalabrasDeSeis().length);
            Palabra[] pals = new Palabra[almacen.getPalabrasDeSeis().length];
            for(int i=0; i<almacen.getPalabrasDeSeis().length; i++){
                pals[i]=almacen.getPalabrasDeSeis()[i];
            }
            Palabra pal = pals[indiceAleatorio];
            for(int i = 0; i < pal.toString().length(); i++){
                this.palabra[i] = pal.toString().charAt(i);
            }
        }
    }

    public void secuenciaResultados(){
    }

}
