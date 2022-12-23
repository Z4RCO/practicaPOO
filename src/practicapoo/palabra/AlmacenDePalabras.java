package practicapoo.palabra;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AlmacenDePalabras {

    private Palabra[] palabrasDeCinco;
    private Palabra[] palabrasDeSeis;

    public AlmacenDePalabras(Palabra[] palabras_de_cinco, Palabra[] palabras_de_seis) {

    }

    public void cargarFichero(){
        StringBuilder archivo = new StringBuilder();
        try {
            FileReader fr = new FileReader("resources/configuracion.txt");
            BufferedReader entrada = new BufferedReader(fr);
            int numletras;
            int numpalabras;
            String decisionPrimeraLetra;
            String aux;
            aux = entrada.readLine();
            numletras = Integer.parseInt(String.valueOf(aux.charAt(0)));
            numpalabras = Integer.parseInt(String.valueOf(aux.charAt(2)));
            decisionPrimeraLetra = aux.substring(3,5);
            palabrasDeCinco = new Palabra[numpalabras];
            palabrasDeSeis = new Palabra[numpalabras];
            for(int i = 0; i < numpalabras; i++){
                palabrasDeCinco[i] =  new Palabra(entrada.readLine());
            }
            numletras = Integer.parseInt(String.valueOf(entrada.readLine()));
            for(int i = 0; i < numpalabras; i++){
                palabrasDeSeis[i] =  new Palabra(entrada.readLine());
            }
            entrada.close();
        }
        catch(FileNotFoundException fnfex) {
            System.out.println("Fichero no encontrado: " + fnfex);
        }
        catch(IOException ioex) {
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
