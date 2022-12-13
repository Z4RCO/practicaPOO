package practicapoo.partida;

public class Marcador {
    private int puntos_j1;
    private int puntos_j2;


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
