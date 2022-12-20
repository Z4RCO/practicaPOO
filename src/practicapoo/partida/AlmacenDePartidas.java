package practicapoo.partida;

import java.util.ArrayList;

//TODO implementar serializable
public class AlmacenDePartidas {
    private ArrayList<Partida> partidas;

    public AlmacenDePartidas(){
        this.partidas = new ArrayList<Partida>();
    }

    public String infoPartidas(){
        StringBuilder sb = new StringBuilder();
        for (Partida p: partidas){
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }

    public void insertarPartida(Partida p){

    }
}
