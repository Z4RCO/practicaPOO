package practicapoo.partida;

import practicapoo.Configuracion;
import practicapoo.interfaz.InterfazPalabra5;
import practicapoo.jugador.Jugador;
import practicapoo.palabra.Palabra;

public class Partida {

    private int identificador;
    private static int numPartidas;
    private boolean regalo_de_palabra;
    private boolean primeraLetra;
    private int numPalabras;
    private Jugador jugador1;
    private Jugador jugador2;
    private Marcador marcador;
    private Palabra[] palabras;

    public Partida(Jugador jugador1, Jugador jugador2) {
        identificador = numPartidas++;
        this.numPalabras = Configuracion.getNumPalabras();

        this.jugador1 = jugador1;
        this.jugador2 = jugador2;

        primeraLetra = Configuracion.isPrimeraLetra();
        regalo_de_palabra = true;

        marcador = new Marcador();
        palabras = new Palabra[numPalabras];

        palabras[0] = new Palabra();
        palabras[0].sacarPalabraAleatoria();
        //palabras[0].setInterfaz(new InterfazPalabra5(jugador1,palabras[0],));

    }

    public Palabra getPalabra(int palabra){
        return palabras[palabra];
    }

    public void cambiarTurno() {
        //TODO hacer método cambiarTurno
        actualizarMarcador();

    }

    public void actualizarMarcador() {
        //TODO hacer método ActualizarMarcador
        //if()marcador.addPuntos_j1(palabras[0].puntosObtenidos());
        //else marcador.addPuntos_j2(palabras[0].puntosObtenidos());
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
            p.append(palabras[i]).append(" ");
        }
        return "Identificador: " + identificador + "\n" +
                "Se muestra la primera letra: " + primeraLetra +
                "Jugador 1: " + jugador1 + ". Consiguió " + marcador.getPuntos_j1() + "\n" +
                "Jugador 2: " + jugador2 + ". Consiguió " + marcador.getPuntos_j2() + "\n" +
                "Palabras de la partida: " + p + "\n";
    }
}
