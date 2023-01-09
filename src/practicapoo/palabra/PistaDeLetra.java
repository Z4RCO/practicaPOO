package practicapoo.palabra;

import practicapoo.Configuracion;
import practicapoo.interfaz.Palabra;

import java.awt.*;
import java.io.Serializable;

public class PistaDeLetra implements Serializable {
    public PistaDeLetra(Palabra palabra) {
        this.palabra = palabra;
    }

    private Palabra palabra;

    public boolean regalarLetra() {
        if (!palabra.isRegaloDeLetra()) {
            return false;
        }

        if (letrasCorrectas().length() < Configuracion.getNumLetras().getSize() - 1) {
            mostrarPalabraActualizada();
            return true;
        }
        return false;
    }

    public void mostrarPalabraActualizada() {
        char c = '.';
        String s = letrasCorrectas();
        boolean encontrado = false;
        for (int i = 0; i < palabra.getPalabra().length && !encontrado; i++) {
            c = palabra.getPalabra()[i];

            if(!s.contains(new StringBuilder(String.valueOf(c))))encontrado = true;
        }

        if(s.length() < Configuracion.getNumLetras().getSize() - 1){
            System.out.println(s.length());
            palabra.appendToPane( "La letra " + c + " está en la solución\n",Color.PINK);
        }


    }

    private String letrasCorrectas() {
        StringBuilder letras = new StringBuilder();
        Intento[] intentos = palabra.getIntentos();
        for (Intento i : intentos){
            for (int j = 0; j < Configuracion.getNumLetras().getSize(); j++) {
                if(i != null && i.recogerIntento()[j] == palabra.getPalabra()[j])letras.append(palabra.getPalabra()[j]);
            }
        }
        return letras.toString();
    }



}
