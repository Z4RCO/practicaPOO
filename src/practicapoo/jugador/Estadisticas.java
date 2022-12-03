package practicapoo.jugador;

public class Estadisticas {
    private int ganadas;
    private int empatadas;
    private int perdidas;
    private int puntos;

    public int getGanadas() {
        return ganadas;
    }

    public void setGanadas(int ganadas) {
        this.ganadas = ganadas;
    }

    public void setEmpatadas(int empatadas) {
        this.empatadas = empatadas;
    }

    public void setPerdidas(int perdidas) {
        this.perdidas = perdidas;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return  "Victorias: " + ganadas + "\n" +
                "Empates: " + empatadas + "\n" +
                "Derrotas: " + perdidas + "\n" +
                "Puntos totales: " + puntos
        ;
    }
}
