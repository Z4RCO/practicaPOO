package practicapoo.palabra;

import practicapoo.enums.Letras;
import practicapoo.interfaz.InterfazPalabra5;
import practicapoo.interfaz.InterfazPalabra6;
import practicapoo.interfaz.Main;
import practicapoo.jugador.Jugador;

public class Entrenamiento {

    private int puntos;
    private boolean regaloDePalabra;
    private Palabra palabra;

    public Entrenamiento(Letras letras){
        Jugador invitado = new Jugador("Invitado","");
        regaloDePalabra = true;
        this.palabra = new Palabra();
        switch (letras){
            case CINCO -> palabra.setInterfaz(new InterfazPalabra5(invitado,palabra));
            case SEIS ->  palabra.setInterfaz(new InterfazPalabra6(invitado,palabra));
        }
        Main.cambiarContenido(palabra.getInterfaz());
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
