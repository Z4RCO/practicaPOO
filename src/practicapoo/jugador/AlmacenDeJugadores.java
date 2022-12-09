package practicapoo.jugador;

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
        while (i.hasNext()) {
            String element = i.next().getNombre();
            //TODO Devolver jugadores
        }
    }

    public void rankingOrdenadoPorNombre() {
        TreeSet<String> set = new TreeSet<String>();
        for (Jugador j : jugadores) {
            set.add(j.getNombre());
        }
        Iterator<String> i = set.iterator();
        while (i.hasNext()) {
            String element = i.next();
            //TODO Devolver jugadores
        }
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
            FileInputStream file = new FileInputStream("src/practicapoo/archivos/jugadores.lingo");
            ObjectInputStream input = new ObjectInputStream(file);
            Jugador j = (Jugador) input.readObject();
            if(input != null) {
                while (j != null) {
                    System.out.println("Jugador" + j.getNombre());
                    jugadores.add(j);
                    j = (Jugador) input.readObject();
                }
                input.close();
            }
        } catch(EOFException eof){

        }catch (IOException | ClassNotFoundException eof) {
            System.err.println("Error. Se ha producido un error: " + eof);
        }

    }

    private void guardarArchivo(){
        try {
            System.out.println("guardando...");
            FileOutputStream file = new FileOutputStream("src/practicapoo/archivos/jugadores.lingo");
            ObjectOutputStream input = new ObjectOutputStream(file);

            for(Jugador j:jugadores){
                input.writeObject(j);
            }
        } catch (IOException io) {
            System.err.println("Error. Se ha producido un error al guardar la información: " + io);
        }
    }
}
