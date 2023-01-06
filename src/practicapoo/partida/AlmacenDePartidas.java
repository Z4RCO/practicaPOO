package practicapoo.partida;

import java.io.*;
import java.util.ArrayList;

public class AlmacenDePartidas implements Serializable {
    private ArrayList<Partida> partidas;

    public AlmacenDePartidas(){
        this.partidas = new ArrayList<Partida>();
        cargarArchivo();
    }

    public String infoPartidas(){
        StringBuilder sb = new StringBuilder();
        for (Partida p: partidas){
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }

    public void insertarPartida(Partida p){
        partidas.add(p);
        guardarArchivo();
    }

    private void cargarArchivo(){
        try{
            FileInputStream file = new FileInputStream("resources/partidas.lingo");
            ObjectInputStream input = new ObjectInputStream(file);
            Partida p = (Partida)input.readObject();

            while (p != null) {
                partidas.add(p);
                p = (Partida) input.readObject();
            }
            input.close();

        }catch (FileNotFoundException fnf){
            System.err.println("Se ha producido una excepción cargando el almacen de partidas: No se ha enontrado el archivo deseado.\n" + fnf);
        }catch(EOFException ignored){

        }catch (IOException | ClassNotFoundException ioex){
            System.err.println("Se ha producido una excepción de E/S cargando el almacen de partidas: " + ioex);
        }
    }

    private void guardarArchivo(){
        try{
            FileOutputStream file = new FileOutputStream("resources/partidas.lingo");
            ObjectOutputStream output = new ObjectOutputStream(file);
            for(Partida p: partidas){
                output.writeObject(p);
            }
        }catch (FileNotFoundException fnf){
            System.err.println("Se ha producido una excepción: No se ha enontrado el archivo deseado.\n" + fnf);
        }catch (IOException ioex){
            System.err.println("Se ha producido una excepción de E/S: " + ioex);
        }
    }
}
