package practicapoo.jugador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

//TODO implementar serializable
public class AlmacenDeJugadores {

    private ArrayList<Jugador> jugadores;

    public AlmacenDeJugadores(){
        jugadores = new ArrayList<Jugador>();
        jugadores.add(new Jugador("admin","admin"));
    }
    public boolean autenticar(Jugador j){
        boolean encontrado = false;
        Iterator<Jugador> i = jugadores.iterator();
        while(i.hasNext() && !encontrado){
            Jugador p = i.next();
            if(p.equals(j))encontrado = true;
        }
        return encontrado;
    }

    public void rankingOrdenadoPorVictorias(){
        jugadores.sort(Jugador::compareTo);
        Iterator<Jugador> i = jugadores.iterator();
        while(i.hasNext()){
            String element = i.next().getNombre();
            //TODO Devolver jugadores
        }
    }

    public void rankingOrdenadoPorNombre(){
        TreeSet<String> set = new TreeSet<String>();
        for(Jugador j: jugadores){
            set.add(j.getNombre());
        }
        Iterator<String> i = set.iterator();
        while(i.hasNext()){
            String element = i.next();
            //TODO Devolver jugadores
        }
    }

    public void alta(Jugador j){
        if(!autenticar(j)){
            jugadores.add(j);
        }
    }

    public void baja(Jugador j){
        if(autenticar(j)){
            jugadores.remove(j);
        }
    }
}
