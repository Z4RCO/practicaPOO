package practicapoo.jugador;

import practicapoo.interfaz.Main;
import practicapoo.partida.AlmacenDePartidas;
import practicapoo.partida.Partida;

import java.io.*;
import java.util.*;

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
            AlmacenDePartidas a = Main.getPartidas();
            List <Partida> l = new ArrayList(a.getPartidas());
            ListIterator i = l.listIterator(l.size());

            while (i.hasNext()){
                Partida aux = (Partida) i.previous();
                Jugador j1 = aux.getJugador1();
                Jugador j2 = aux.getJugador2();
                if (j.equals(j1) || j.equals(j2)){
                    System.out.println(aux.toString());
                }
            }

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
