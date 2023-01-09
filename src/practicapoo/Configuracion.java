package practicapoo;

import practicapoo.enums.Letras;

import java.io.*;

public class Configuracion {
    private static Letras letras;
    private static int numPalabras;
    private static boolean primeraLetra;

    public static Letras getNumLetras(){
        return letras;
    }
    public static int getNumPalabras() {
        return numPalabras;
    }
    public static boolean isPrimeraLetra() {
        return primeraLetra;
    }

    public static void setter(String archivo){
        try{
            FileReader fr = new FileReader(archivo);
            BufferedReader entrada = new BufferedReader(fr);

            String s = entrada.readLine();

            if(s.charAt(0) == '5') letras = Letras.CINCO;
            else letras = Letras.SEIS;


            numPalabras = Integer.parseInt(s.substring(2,3));
            primeraLetra = s.substring(4, 6).equals("si");


        }catch(FileNotFoundException fnf){
            System.err.println("Se ha producido una excepción. Archivo No encontrado: " + fnf);
        }catch(IOException io){
            System.err.println("Excepción de Entrada/Salida: " + io);
        }
    }

    public static void setLetras(Letras letras) {
        Configuracion.letras = letras;
    }
}
