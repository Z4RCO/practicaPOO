package practicapoo.partida;

import practicapoo.Configuracion;
import practicapoo.interfaz.Main;
import practicapoo.interfaz.Palabra;
import practicapoo.interfaz.Sesion;
import practicapoo.jugador.Jugador;

import javax.swing.*;
import java.awt.*;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Partida implements Externalizable {

    private static int numPartidas;

    private int identificador;
    private int numPalabras;
    private Jugador jugador1;
    private Jugador jugador2;
    private Marcador marcador;

    private boolean regaloDePalabra;

    private boolean primeraLetra;

    //Atributo para llevar la cuenta de las palabras que se han jugado
    private int palabraActual;

    private Palabra[] palabras;


    /**
     * Constructor de la partida.
     * Crea una partida a partir de 2 jugadores y la información de la Configuración
     *
     * @param jugador1 primer jugador de la partida
     * @param jugador2 segundo jugador de la partida
     */
    public Partida(Jugador jugador1, Jugador jugador2) {
        this();
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        palabras[0] = new Palabra(this);
        palabras[0].sacarPalabraAleatoria();
        palabras[0].setTurno("Turno de: " + jugador1.getNombre());
        if (primeraLetra)
            palabras[0].appendToPane("La primera letra de la palabra es : " + palabras[palabraActual].getPalabra()[0] + "\n", Color.PINK);

        Main.cambiarContenido(palabras[0]);
    }

    /**
     * Constructor público no-args.
     * Utilizado por Externalizable cuando carga la información del almacén de partidas
     */
    public Partida() {
        jugador1 = new Jugador(null, null);
        jugador2 = new Jugador(null, null);
        identificador = numPartidas++;
        this.numPalabras = Configuracion.getNumPalabras();
        primeraLetra = Configuracion.isPrimeraLetra();
        regaloDePalabra = true;

        marcador = new Marcador();
        palabras = new Palabra[numPalabras * 2];

    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public boolean isRegaloDePalabra() {
        return this.regaloDePalabra;
    }

    /**
     * Método para cambiar el turno de la partida.
     * Comprueba si se han jugador todas las palabras para acabar la partida.
     * Si se han jugado, comprueba quién tiene más puntos para anunciar el ganador y actualizar sus estadísticas.
     * sino:
     * Comprueba quién es el jugador actual, y crea una palabra nueva para el otro jugador
     */
    public void cambiarTurno() {
        ++palabraActual;
        if (palabraActual < numPalabras * 2) {
            palabras[palabraActual] = new Palabra(this);
            palabras[palabraActual].sacarPalabraAleatoria();
            if (primeraLetra)
                palabras[palabraActual].appendToPane("La primera letra de la palabra es" + palabras[palabraActual].getPalabra()[0], Color.PINK);
            Main.cambiarContenido(palabras[palabraActual]);
            if (palabras[palabraActual - 1].getTurno().equals("Turno de: " + jugador1.getNombre())) {
                palabras[palabraActual].setTurno("Turno de: " + jugador2.getNombre());
                palabras[palabraActual].setPuntos(marcador.getPuntos_j2());
            } else {
                palabras[palabraActual].setTurno("Turno de: " + jugador1.getNombre());
                palabras[palabraActual].setPuntos(marcador.getPuntos_j1());
            }

        } else {
            String ganador;
            if (marcador.getPuntos_j1() > marcador.getPuntos_j2()) {
                ganador = jugador1.getNombre();
                jugador1.SumarVictoria();
                jugador1.sumarPuntos(marcador.getPuntos_j1());
                jugador2.sumarDerrota();
                jugador2.sumarPuntos(marcador.getPuntos_j2());

            } else if (marcador.getPuntos_j1() < marcador.getPuntos_j2()) {
                ganador = jugador2.getNombre();
                jugador2.SumarVictoria();
                jugador2.sumarPuntos(marcador.getPuntos_j2());
                jugador1.sumarDerrota();
                jugador1.sumarPuntos(marcador.getPuntos_j1());

            } else {
                ganador = "Empate!";
                jugador1.sumarEmpate();
                jugador2.sumarEmpate();
                jugador1.sumarPuntos(marcador.getPuntos_j1());
                jugador2.sumarPuntos(marcador.getPuntos_j2());
            }
            JOptionPane.showMessageDialog(Main.getLienzo(), "Ganador de la partida: " + ganador);
            Main.getJugadores().guardarArchivo();
            Main.getPartidas().insertarPartida(this);
            Main.cambiarContenido(new Sesion(jugador1));


        }


    }

    /**
     * Actualiza el marcador para el jugador y puntos pasador por parámetro
     * @param jugador Nombre del jugador del que se quiere actualizar el marcador
     * @param puntos puntos que se quieren sumar a su marcador
     */
    public void actualizarMarcador(String jugador, int puntos) {
        if (("Turno de: " + jugador1.getNombre()).equals(jugador)) {
            marcador.addPuntos_j1(puntos);
        } else {
            marcador.addPuntos_j2(puntos);
        }
    }

    /**
     * Usa la pista de letra de la palabra acual
     * @return true si el jugador tiene puntos suficientes para usar la pista. False si no tiene suficientes
     */
    public boolean usarPistaDeLetra() {
        if (palabras[palabraActual].getTurno().equals(jugador1.getNombre())) {
            if (marcador.getPuntos_j1() < 1 || !palabras[palabraActual].isRegaloDeLetra()) return false;
            marcador.addPuntos_j1(-1);
            return true;
        } else {
            if (marcador.getPuntos_j1() < 1 || !palabras[palabraActual].isRegaloDeLetra()) return false;
            marcador.addPuntos_j2(-1);
            return true;
        }
    }

    /**
     * Métoso para usar el regalo de palabra de la partida
     * @return true si todavía no se ha usado y el jugador tiene puntos suficientes para usarla. False en caso contrario
     */
    public boolean usarPistaDePalabra() {
        if (!regaloDePalabra) return false;
        regaloDePalabra = false;
        if (palabras[palabraActual].getTurno().equals(jugador1.getNombre())) {
            if (marcador.getPuntos_j1() >= 3) {
                marcador.addPuntos_j1(-3);
                cambiarTurno();
                return true;
            }
            return false;
        } else {
            if (marcador.getPuntos_j2() >= 3) {
                marcador.addPuntos_j2(-3);
                cambiarTurno();
                return true;
            }
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder p = new StringBuilder();
        for (int i = 0; i < numPalabras * 2; i++) {
            p.append(palabras[i].toString());
        }
        return "Identificador: " + identificador + "\n" + "Se muestra la primera letra: " + primeraLetra + "\n" + "Jugador 1: " + jugador1.getNombre() + ". Consiguio " + marcador.getPuntos_j1() + " puntos\n" + "Jugador 2: " + jugador2.getNombre() + ". Consiguio " + marcador.getPuntos_j2() + " puntos\n" + "Palabras de la partida:\n" + p + "\n";
    }


    /**
     * Método para cargar una partida desde un archivo
     * @param out the stream to write the object to
     * @throws IOException
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.write(identificador);
        out.write(numPalabras);
        out.writeBoolean(primeraLetra);
        out.writeBoolean(regaloDePalabra);
        out.writeObject(jugador1);
        out.writeObject(jugador2);
        out.writeObject(marcador);
        for (Palabra p : palabras) {
            p.writeExternal(out);
        }
    }

    /**
     * Método para guardar la partida en un archivo
     * Guarda la información en el mismo orden en el que luego será desrializada
     * @param in the stream to read data from in order to restore the object
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        identificador = in.read();
        numPalabras = in.read();
        primeraLetra = in.readBoolean();
        regaloDePalabra = in.readBoolean();
        jugador1 = (Jugador) in.readObject();
        jugador2 = (Jugador) in.readObject();
        marcador = (Marcador) in.readObject();
        palabras = new Palabra[numPalabras * 2];
        for (int i = 0; i < numPalabras * 2; i++) {
            palabras[i] = new Palabra();
            palabras[i].readExternal(in);
        }

    }
}
