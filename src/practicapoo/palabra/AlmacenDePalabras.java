package practicapoo.palabra;

import practicapoo.interfaz.Palabra;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AlmacenDePalabras {

    private Palabra[] palabrasDeCinco;
    private Palabra[] palabrasDeSeis;

    public AlmacenDePalabras() {
        cargarFichero();
    }

    public void cargarFichero() {
        try {
            FileReader file = new FileReader("resources/configuracion.txt");
            BufferedReader entrada = new BufferedReader(file);
            String linea = entrada.readLine();

            int numPalabras = Integer.parseInt(linea.substring(2, 3));

            palabrasDeCinco = new Palabra[numPalabras];
            palabrasDeSeis = new Palabra[numPalabras];

            int lineas = 0;
            ArrayList<String> pal = new ArrayList<>();
            String lineaSiguiente = entrada.readLine();
            while(!lineaSiguiente.equals("6")){
                pal.add(lineaSiguiente);
                lineaSiguiente = entrada.readLine();
                ++lineas;
            }

            palabrasDeCinco = new Palabra[lineas];
            palabrasDeSeis = new Palabra[lineas];
            for (int i = 0; i < lineas; i++) {
                palabrasDeCinco[i] = new Palabra();
                palabrasDeSeis[i] = new Palabra();
                palabrasDeCinco[i].setPalabra(pal.get(i).toCharArray());
                palabrasDeSeis[i].setPalabra(entrada.readLine().toCharArray());
            }

            entrada.close();
        } catch (FileNotFoundException fnfex) {
            System.out.println("Fichero no encontrado: " + fnfex);
        } catch (IOException ioex) {
            System.out.println("Excepción de E/S: " + ioex);
        }
    }

    public Palabra[] getPalabrasDeCinco() {
        return palabrasDeCinco;
    }

    public Palabra[] getPalabrasDeSeis() {
        return palabrasDeSeis;
    }
}
