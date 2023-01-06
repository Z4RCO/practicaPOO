package practicapoo.palabra;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

            for (int i = 0; i < numPalabras; i++) {
                palabrasDeCinco[i] = new Palabra();
                palabrasDeCinco[i].setPalabra(entrada.readLine().toCharArray());

            }
            entrada.readLine();
            for (int i = 0; i < numPalabras; i++) {
                palabrasDeSeis[i] = new Palabra();
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
