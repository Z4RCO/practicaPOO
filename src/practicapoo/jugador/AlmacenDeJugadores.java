package practicapoo.jugador;

import practicapoo.jugador.Jugador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class AlmacenDeJugadores {

    private ArrayList<Jugador> jugadores;

    public boolean autenticar(Jugador j){
        boolean encontrado = false;
        Iterator i = jugadores.iterator();
        while(i.hasNext() && !encontrado){
            Jugador p = (Jugador) i.next();
            if(p.equals(j))encontrado = true;
        }

        //TODO Acabar método autenticar
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
