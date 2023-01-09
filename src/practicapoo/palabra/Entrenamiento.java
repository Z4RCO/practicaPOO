package practicapoo.palabra;

import practicapoo.interfaz.Main;
import practicapoo.interfaz.Palabra;
import practicapoo.jugador.Jugador;

public class Entrenamiento {

    private int puntos;
    private boolean regaloDePalabra;
    private Palabra palabra;

    public Entrenamiento(){
        Jugador invitado = new Jugador("Invitado","");
        regaloDePalabra = true;
        this.palabra = new Palabra();
        palabra.sacarPalabraAleatoria();
        palabra.setTurno("Entrenamiento");
        Main.cambiarContenido(palabra);
    }
    public int mostrarPuntos(){

        return 0;
    }

    public boolean usarPistaDePalabra(){
        if(!regaloDePalabra)return false;
        regaloDePalabra = false;


        return true;
    }

}
