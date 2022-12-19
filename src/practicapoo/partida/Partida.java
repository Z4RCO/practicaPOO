package practicapoo.partida;

import practicapoo.Configuracion;
import practicapoo.interfaz.InterfazPartida5;
import practicapoo.jugador.Jugador;
import practicapoo.palabra.Palabra;
public class Partida {

    private int identificador;
    private boolean regalo_de_palabra;
    private boolean primeraLetra;
    private int numPalabras;
    private Jugador jugador1;
    private Jugador jugador2;
    private Marcador marcador;
    private Palabra[] palabras;

    private InterfazPartida5 interfaz;

    public Partida(Jugador jugador1,Jugador jugador2, InterfazPartida5 interfaz){
        this.numPalabras = Configuracion.getNumPalabras();
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        marcador = new Marcador();
        palabras = new Palabra[numPalabras];
        this.interfaz = interfaz;

    }

    public void cambiarTurno(){
        if(interfaz.getJugador().equals(jugador1))interfaz = new InterfazPartida5(jugador2,this);
        else interfaz = new InterfazPartida5(jugador1,this);
    };

    public void actualizarMarcador(){};

    public boolean usar_Pista_de_Letra(){
        return true;
    };

    public boolean usar_Pista_de_Palabra(){
        return true;
    };

    @Override
    public String toString() {
        StringBuilder p = new StringBuilder();
        for (int i = 0; i < numPalabras; i++) {
            //TODO añadir array de palabras
            p.append(palabras[i]).append(" ");
        }
        return "Identificador: " + identificador + "\n" +
                "Jugador 1: " + jugador1 + ". Consiguió " + marcador.getPuntos_j1() + "\n" +
                "Jugador 2: " + jugador2 + ". Consiguió " + marcador.getPuntos_j2() + "\n" +
                "Palabras de la partida: " + p;
    }
}
