package practicapoo.jugador;

import java.io.*;

public class Estadisticas implements Serializable {
    private int ganadas;
    private int empatadas;
    private int perdidas;
    private int puntos;

    public int getGanadas() {
        return ganadas;
    }

    public int getEmpatadas() {
        return empatadas;
    }

    public int getPerdidas() {
        return perdidas;
    }

    public int getPuntos() {
        return puntos;
    }

    /**
     * Suma el valor del parámetro al atributo ganadas
     * @param ganadas valor a sumar al atributo
     */
    public void addVictorias(int ganadas) {
        if(ganadas < 0)throw new IllegalArgumentException("Parametro negativo no aceptado");
        this.ganadas += ganadas;
    }

    /**
     * Suma el valor del parámetro al atributo empatadas
     * @param empatadas valor a sumar al atributo
     */
    public void addEmpates(int empatadas) {
        if(empatadas < 0)throw new IllegalArgumentException("Parametro negativo no aceptado");
        this.empatadas += empatadas;
    }

    /**
     * Suma el valor del parámetro al atributo perdidas
     * @param perdidas valor a sumar al atributo
     */
    public void addDerrotas(int perdidas) {
        if(perdidas < 0)throw new IllegalArgumentException("Parametro negativo no aceptado");
        this.perdidas += perdidas;
    }

    /**
     * Suma el valor del parámetro al atributo puntos
     * @param puntos valor a sumar al atributo
     */
    public void addPuntos(int puntos) {
        if(puntos < 0)throw new IllegalArgumentException("Parametro negativo no aceptado");
        this.puntos += puntos;
    }

    /**
     * Crea un String a partir de la clase. Incluye todos los atributos
     * @return Un String con la información de los atributos de la clase
     */
    @Override
    public String toString() {
        return  "Victorias: " + ganadas + "\n" +
                "Empates: " + empatadas + "\n" +
                "Derrotas: " + perdidas + "\n" +
                "Puntos totales: " + puntos
        ;
    }
}
