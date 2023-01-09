package practicapoo.partida;

import java.io.*;
import java.util.ArrayList;

/**
 * Almacén de Partidas
 * Cada vez que empieza una partida se añade al almacén
 * Implementa serializble para poder ser almacenado en un fichero
 */
public class AlmacenDePartidas implements Externalizable {
    private ArrayList<Partida> partidas;

    public ArrayList<Partida> getPartidas() {
        return partidas;
    }
    private int i;

    /**
     * Constructor de la clase
     * Crea el Arraylist y lo llena a partir del archivo
      */
    public AlmacenDePartidas(){
        System.out.println(i++);
        this.partidas = new ArrayList<Partida>();
        System.out.println(i++);
        cargarArchivo();
        System.out.println(i++);
    }

    /**
     * Método que saca la información de todas las partidas
     * @return String con la información de todas las partidas
     */
    public String infoPartidas(){
        StringBuilder sb = new StringBuilder();
        for (Partida p: partidas){
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Inserta una partida en el Almacén y la añade al archivo
     * @param p Partida que se quiere insertar
     */
    public void insertarPartida(Partida p){
        partidas.add(p);
        guardarArchivo();
    }

    /**
     * Método que llena el ArrayList a partir de un fichero
     */
    private void cargarArchivo(){
        try{
            System.out.println(i++);
            FileInputStream file = new FileInputStream("resources/partidas.lingo");
            System.out.println(i++);
            ObjectInputStream input = new ObjectInputStream(file);
            System.out.println(i++);
            readExternal(input);


        }catch (FileNotFoundException fnf){
            System.err.println("Se ha producido una excepción cargando el almacen de partidas: No se ha enontrado el archivo deseado.\n" + fnf);
        }catch(EOFException ignored){
        }catch (IOException | ClassNotFoundException ioex){
            System.err.println("Se ha producido una excepción de E/S cargando el almacen de partidas: " + ioex);
            ioex.printStackTrace();
        }
    }

    /**
     * Método que guarda el ArrayList en un fichero
     */
    private void guardarArchivo(){
        try{

            FileOutputStream file = new FileOutputStream("resources/partidas.lingo");

            ObjectOutputStream output = new ObjectOutputStream(file);
            writeExternal(output);

        }catch (FileNotFoundException fnf){
            System.err.println("Se ha producido una excepción: No se ha enontrado el archivo deseado.\n" + fnf);
        }catch (IOException ioex){
            System.err.println("Se ha producido una excepción de E/S: " + ioex);
            ioex.printStackTrace();
        }
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        int cantidad = partidas.size();
        out.write(cantidad);
        for(Partida p: partidas){
            out.writeObject(p);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int cantidad = in.read();
        for (int i = 0; i < cantidad; i++) {
            System.out.println(this.i++);
            Partida p = (Partida) in.readObject();
            System.out.println(i++);
            System.out.println(p.toString());
            partidas.add(p);
        }
    }
}
