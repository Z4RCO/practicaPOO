package practicapoo.partida;

import practicapoo.jugador.Jugador;

public class Partida {

    private int identificador;
    private boolean regalo_de_palabra;
    private boolean primeraLetra;
    private int numPalabras;

    private Jugador jugador1;
    private Jugador jugador2;

    public Partida(int numPalabras, Jugador jugador1,Jugador jugador2){
        //TODO lanzar excepcion
        if(numPalabras > 10 || numPalabras < 1){
           this.numPalabras = numPalabras;
           this.jugador1 = jugador1;
           this.jugador2 = jugador2;
        }
    }

    public void cambiarTurno(){};

    public void actualizarMarcador(){};

    public boolean usar_Pista_de_Letra(){
        return true;
    };

    public boolean usar_Pista_de_Palabra(){
        return true;
    };

    public void info_Partida(){};



}
