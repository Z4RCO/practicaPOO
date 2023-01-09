package practicapoo.palabra;

import java.io.Serializable;

public class Intento implements Serializable {
    private final char[] intento;


    public Intento(char[] intento) {
       this.intento = intento;
    }
    public char[] recogerIntento(){
        return this.intento;
    }
}
