package practicapoo.jugador;

import practicapoo.interfaz.Main;

import javax.swing.*;
import java.io.*;
import java.util.*;


public class AlmacenDeJugadores implements Serializable {

    private ArrayList<Jugador> jugadores;


    /**
     * Constructor de la clase.
     * Inicializa el ArrayList y lo carga del archivo
     */
    public AlmacenDeJugadores() {
        jugadores = new ArrayList<Jugador>();
        cargarArchivo();
    }

    /**
     * Método para comprobar si un jugador existe en el almacén
     *
     * @param j jugador que se quiere comprobar
     * @return true si existe, false si no existe
     */
    public boolean autenticar(Jugador j) {
        boolean encontrado = false;
        Iterator<Jugador> i = jugadores.iterator();
        while (i.hasNext() && !encontrado) {
            Jugador p = i.next();
            if (p.equals(j)) encontrado = true;
        }
        return encontrado;
    }

    /**
     * Método para mostrar el ranking ordenado por victorias
     * Se ha implementado usando el método compareTo de la clase Jugador
     */
    public void rankingOrdenadoPorVictorias() {
        jugadores.sort(Jugador::compareTo);
        Iterator<Jugador> i = jugadores.iterator();
        StringBuilder sb = new StringBuilder("Jugadores:\n");
        while (i.hasNext()) {
            Jugador j = i.next();
            sb.append(j.toString());
        }
        JScrollPane sp = new JScrollPane();
        JTextArea t = new JTextArea(sb.toString());
        t.setColumns(30);
        t.setRows(10);
        sp.setViewportView(t);
        JOptionPane.showMessageDialog(
                Main.getLienzo(),
                sp,
                "Ranking ordenado por victorias",
                JOptionPane.INFORMATION_MESSAGE,
                null);
    }

    /**
     * Método para mostrar el almacén ordenado por nombre
     * Se ha implementado usando un Mapa ordenado de nombres y estadísticas
     */
    public void rankingOrdenadoPorNombre() {
        SortedMap<String, Estadisticas> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (Jugador j : jugadores) {
            map.put(j.getNombre(), j.getEstadisticas());
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Estadisticas> entry : map.entrySet()) {
            sb.append(entry.getKey())
                    .append("\n")
                    .append(entry.getValue().toString())
                    .append("\n");
            ;
        }
        JScrollPane sp = new JScrollPane();
        JTextArea t = new JTextArea(sb.toString());
        t.setColumns(30);
        t.setRows(10);
        sp.setViewportView(t);
        JOptionPane.showMessageDialog(
                Main.getLienzo(),
                sp,
                "Ranking ordenado alfabéticamente",
                JOptionPane.INFORMATION_MESSAGE,
                null);
    }

    /**
     * Método para añadir un nuevo Jugador al almacén
     *
     * @param j jugador que se quiere añadir
     *          Sólo se añade si no existe en el almacén
     */
    public void alta(Jugador j) {
        if (!autenticar(j)) {
            jugadores.add(j);
            guardarArchivo();
        }

    }

    /**
     * Método para eliminar un jugador del almacén
     *
     * @param j jugador que se quiere eliminar
     *          Si existe, se elimina del ArrayList y se actualiza el archivo
     */
    public void baja(Jugador j) {
        if (autenticar(j)) {
            jugadores.remove(j);
            guardarArchivo();
        }
    }

    /**
     * Método para cargar los datos de un fichero al ArrayList
     */
    private void cargarArchivo() {
        try {
            FileInputStream file = new FileInputStream("resources/jugadores.lingo");
            ObjectInputStream input = new ObjectInputStream(file);
            Jugador j = (Jugador) input.readObject();
            if (input != null) {
                while (j != null) {
                    jugadores.add(j);
                    j = (Jugador) input.readObject();
                }
                input.close();
            }
        } catch (EOFException ignored) {
        } catch (IOException | ClassNotFoundException exception) {
            System.err.println("Error. Se ha producido una excepción intentando cargar el archivo de jugadores: " + exception);
            exception.printStackTrace();
        }

    }

    /**
     * Método para serializar el ArrayList a un fichero
     */
    public void guardarArchivo() {
        try {
            FileOutputStream file = new FileOutputStream("resources/jugadores.lingo");
            ObjectOutputStream output = new ObjectOutputStream(file);

            for (Jugador j : jugadores) {
                output.writeObject(j);
            }
        } catch (IOException io) {
            System.err.println("Error. Se ha producido una excepción al serializar el almacen de jugadores: " + io);
            io.printStackTrace();
        }
    }


    /**
     * Método para obtener un jugador del almacén
     *
     * @param jugador jugador que se quiere obtener
     * @return Si el jugador parámetro existe, se devuelve una referencia al del almacén. Si no existe, devuelve null
     */
    public Jugador getJugador(Jugador jugador) {

        if (autenticar(jugador)) {
            Jugador t = new Jugador(null, null);
            for (Jugador j : jugadores) {
                if (j.equals(jugador)) {
                    t = j;
                }

            }
            return t;
        }
        return null;
    }

}
