package practicapoo.enums;

import java.awt.*;

/**
 * Enumerado que gestiona los colores para las casillas
 */
public enum Colores {
    /**
     * Color gris, usado cuando una letra no está en la palabra
     */
    GRIS(Color.GRAY),

    /**
     * Color Amarillo, usado cuando la letra está en la palabra pero en distinta posición
     */
    AMARILLO(Color.ORANGE),

    /**
     * Color verde, usado cuando la posición es correcta
     */
    VERDE(Color.GREEN),


    /**
     * Color cian, usado por el programa cuando se utiliza una pista
     */
    PISTA(Color.CYAN);

    private final Color color;

    Colores(Color color){

        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }
}
