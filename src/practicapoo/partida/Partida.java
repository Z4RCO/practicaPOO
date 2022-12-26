package practicapoo.partida;

import practicapoo.Configuracion;
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

    public Partida(Jugador jugador1, Jugador jugador2) {
        this.numPalabras = Configuracion.getNumPalabras();
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        marcador = new Marcador();
        palabras = new Palabra[numPalabras];

        palabras[0] = new Palabra();
        //palabras[0].jugar();

    }

    public void cambiarTurno() {
        //TODO hacer método cambiarTurno
        actualizarMarcador();
    }

    public void actualizarMarcador() {
        //TODO hacer método ActualizarMarcador
    }

    public boolean usar_Pista_de_Letra() {
        //TODO hacer método usarPistaDeLetra
        return true;
    }

    public boolean usar_Pista_de_Palabra() {
        //TODO hacer método usarPistaDePalabra
        return true;
    }

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
