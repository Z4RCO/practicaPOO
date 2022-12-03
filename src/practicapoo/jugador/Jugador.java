package practicapoo.jugador;

import java.util.Comparator;
import java.util.Objects;

public class Jugador implements Comparable {
    private String nombre;
    private String password;
    private Estadisticas estadisticas;

    public void partidasContraOtro(Jugador j){

    }

    public String getNombre(){
        return this.nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return this.nombre == jugador.nombre;
    }

    @Override
    public int compareTo(Object o) {
        Jugador j= (Jugador) o;
        if(estadisticas.getGanadas() > ((Jugador) o).estadisticas.getGanadas())return 1;
        if(estadisticas.getGanadas() < ((Jugador) o).estadisticas.getGanadas())return -1;
        return 0;
    }

    public Estadisticas getEstadisticas(){
        return estadisticas;
    }
}
