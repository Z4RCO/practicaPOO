package practicapoo.partida;

import java.io.Serializable;

/**
 * Clase que gestiona el marcador de una partida
 */
public class Marcador implements Serializable {
    private int puntos_j1;
    private int puntos_j2;

    public Marcador() {
        this.puntos_j1 = 0;
        this.puntos_j2 = 0;
    }

    public int getPuntos_j1() {
        return puntos_j1;
    }

    public int getPuntos_j2() {
        return puntos_j2;
    }

    public void addPuntos_j1(int puntos_j1) {
        this.puntos_j1 += puntos_j1;
    }

    public void addPuntos_j2(int puntos_j2) {
        this.puntos_j2 += puntos_j2;
    }
}
