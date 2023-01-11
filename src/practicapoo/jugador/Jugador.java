package practicapoo.jugador;

import practicapoo.interfaz.Main;
import practicapoo.partida.Partida;

import javax.swing.*;
import java.io.Serializable;

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
            StringBuilder sb = new StringBuilder();
            for(Partida p : Main.getPartidas().getPartidas()){
                if(p.getJugador1().equals(this) && p.getJugador2().equals(j))sb.append(p);
                if(p.getJugador2().equals(this) && p.getJugador1().equals(j))sb.append(p);
            }
            if(sb.isEmpty())sb.append("Todavía no habéis jugado partidas.\nJugad más para que aparezcan aquí!");
            JScrollPane sp = new JScrollPane();
            JTextArea t = new JTextArea(sb.toString());
            t.setColumns(30);
            t.setRows(10);
            sp.setViewportView(t);
            JOptionPane.showMessageDialog(
                    Main.getLienzo(),
                    sp,
                    "Partidas contra otro",
                    JOptionPane.INFORMATION_MESSAGE,
                    null);

        }catch(NullPointerException npe){
            System.err.println("El jugador especificado no existe: " + npe);
            npe.printStackTrace();
        }

    }

    /**
     * Compara si 2 jugadores son iguales
     * @param o Jugador con el que se quiere comparar
     * @return true si coinciden nombre y contraseña. False en cualquier otro caso
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return this.nombre.equals(jugador.nombre) && this.password.equals(jugador.password);
    }

    @Override
    public String toString() {
        return "Jugador: " + nombre + "\n" +
                "Estadísticas :\n" +
                estadisticas.toString();
    }


    /**
     * Método para comparar 2 jugadores
     * @param o the object to be compared.
     * @return 1, 0 o -1 en función de sus victorias
     */
    @Override
    public int compareTo(Object o) {
        Jugador j= (Jugador) o;
        if(estadisticas.getGanadas() > j.estadisticas.getGanadas())return -1;
        if(estadisticas.getGanadas() < j.estadisticas.getGanadas())return 1;
        return 0;
    }


    //Getters y setters
   public String getNombre(){
        return this.nombre;
    }
    public Estadisticas getEstadisticas(){
        return estadisticas;
    }

    public void SumarVictoria(){
        estadisticas.addVictorias(1);
    }

    public void sumarDerrota(){
        estadisticas.addDerrotas(1);
    }

    public void sumarEmpate(){
        estadisticas.addEmpates(1);
    }

    public void sumarPuntos(int puntos){
        estadisticas.addPuntos(puntos);
    }
}
