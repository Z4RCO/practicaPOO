package practicapoo;

public class Partida {

    private int identificador;
    private boolean regalo_de_palabra;
    private boolean primeraLetra;
    private int numPalabras;

    public Partida(int numPalabras){
        if(numPalabras > 10 || numPalabras < 1){
           this.numPalabras = numPalabras;
        }
    }

    public void cambiarTurno(){};

    public void actualizarMarcador(){};

    public boolean usar_Pista_de_Letra(){
        return true;
    };

    public boolean usar_Pista_de_Palabra(){
        return true;
    };

    public void info_Partida(){};



}
