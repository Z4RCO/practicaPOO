package practicapoo.partida;

import practicapoo.Configuracion;
import practicapoo.interfaz.Main;
import practicapoo.interfaz.Palabra;

import javax.swing.*;
import java.awt.*;

public class Entrenamiento {

    private int puntos;
    private boolean regaloDePalabra;
    private Palabra palabra;

    public Entrenamiento() {
        regaloDePalabra = true;
        this.palabra = new Palabra(this);
        palabra.sacarPalabraAleatoria();
        palabra.setTurno("Entrenamiento");
        if(Configuracion.isPrimeraLetra())palabra.appendToPane("La primera letra de la palabra es: " + palabra.getPalabra()[0] + "\n", Color.PINK);
        Main.cambiarContenido(palabra);
    }

    public int mostrarPuntos() {
        return puntos;
    }

    public boolean usarPistaDePalabra() {
        if (!regaloDePalabra) {
            palabra.appendToPane("Ya has usado el regalo de palabra\n", Color.RED);
            return false;
        }
        if (puntos < 3) {
            palabra.appendToPane("No tienes puntos suficientes.\nAcumula más primero!", Color.RED);
            return false;
        }
        regaloDePalabra = false;
        puntos -= 3;
        Object[] obj = {"Has usado el regalo de palabra", "La palabra era " + new String(palabra.getPalabra())};
        JOptionPane.showMessageDialog(
                palabra,
                obj,
                "Regalo de palabra",
                JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon("resources/Logo.png")
        );
        palabra.sacarPalabraAleatoria();
        palabra.removeAll();
        return true;
    }

    public void addPuntos(int puntos) {
        this.puntos += puntos;
    }

}
