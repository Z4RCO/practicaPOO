package practicapoo.jugador;

import java.io.*;

public class Jugador implements Comparable, Serializable {
    private String nombre;
    private String password;
    private Estadisticas estadisticas;

    public Jugador(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
        this.estadisticas = new Estadisticas();
    }

    public void partidasContraOtro(Jugador j){
        try{
            //TODO hacer partidas contra otro

        }catch(NullPointerException npe){
            System.err.println("El jugador especificado no existe: " + npe);
        }

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return this.nombre.equals(jugador.nombre) && this.password.equals(jugador.password);
    }

    @Override
    public int compareTo(Object o) {
        Jugador j= (Jugador) o;
        if(estadisticas.getGanadas() > j.estadisticas.getGanadas())return 1;
        if(estadisticas.getGanadas() < j.estadisticas.getGanadas())return -1;
        return 0;
    }

   public String getNombre(){
        return this.nombre;
    }
    public Estadisticas getEstadisticas(){
        return estadisticas;
    }
}
