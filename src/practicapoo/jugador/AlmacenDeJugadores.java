package practicapoo.jugador;

import practicapoo.interfaz.Main;
import javax.swing.*;
import java.io.*;
import java.util.*;


public class AlmacenDeJugadores implements Serializable {

    private ArrayList<Jugador> jugadores;

    public AlmacenDeJugadores() {
        jugadores = new ArrayList<Jugador>();
        cargarArchivo();
    }

    public boolean autenticar(Jugador j) {
        boolean encontrado = false;
        Iterator<Jugador> i = jugadores.iterator();
        while (i.hasNext() && !encontrado) {
            Jugador p = i.next();
            if (p.equals(j)) encontrado = true;
        }
        return encontrado;
    }

    public void rankingOrdenadoPorVictorias() {
        jugadores.sort(Jugador::compareTo);
        Iterator<Jugador> i = jugadores.iterator();
        StringBuilder sb = new StringBuilder("Jugador   Victorias\n");
        while (i.hasNext()) {
            Jugador j = i.next();
            sb.append(j.getNombre()).append("     ").append(j.getEstadisticas().getGanadas()).append("\n");

        }
        JOptionPane.showMessageDialog(
                Main.getLienzo(),
                sb,
                "Ranking ordenado por victorias",
                JOptionPane.INFORMATION_MESSAGE,
                null);
    }

    public void rankingOrdenadoPorNombre() {
        SortedMap<String,Integer> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (Jugador j : jugadores) {
            map.put(j.getNombre(),j.getEstadisticas().getGanadas());
        }
        StringBuilder sb = new StringBuilder("Jugador   Victorias\n");
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            sb.append(entry.getKey()).append("     ").append(entry.getValue()).append("\n");
        }
        JOptionPane.showMessageDialog(
                Main.getLienzo(),
                sb,
                "Ranking ordenado alfabéticamente",
                JOptionPane.INFORMATION_MESSAGE,
                null);
    }

    public void alta(Jugador j) {
        if (!autenticar(j)) {
            jugadores.add(j);
            guardarArchivo();
        }

    }

    public void baja(Jugador j) {
        if (autenticar(j)) {
            jugadores.remove(j);
            guardarArchivo();
        }
    }

    private void cargarArchivo() {
        try {
            FileInputStream file = new FileInputStream("resources/jugadores.lingo");
            ObjectInputStream input = new ObjectInputStream(file);
            Jugador j = (Jugador) input.readObject();
            System.out.println(j.getNombre());
            if(input != null) {
                while (j != null) {
                    jugadores.add(j);
                    j = (Jugador) input.readObject();
                    int rnd = (int)(Math.random() * 10);
                    j.getEstadisticas().addGanadas(rnd);
                    System.out.println(j.getNombre());
                }
                input.close();
            }
        } catch(EOFException ignored){
        }catch (IOException | ClassNotFoundException exception) {
            System.err.println("Error. Se ha producido una excepción intentando cargar el archivo de jugadores: " + exception);
        }

    }

    private void guardarArchivo(){
        try {
            FileOutputStream file = new FileOutputStream("resources/jugadores.lingo");
            ObjectOutputStream input = new ObjectOutputStream(file);

            for(Jugador j:jugadores){
                input.writeObject(j);
            }
        } catch (IOException io) {
            System.err.println("Error. Se ha producido una excepción al serializar el almacen de jugadores: " + io);
        }
    }
}
