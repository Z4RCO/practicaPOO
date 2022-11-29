package practicapoo;
public class Configuracion {
    private static enum letras{
        Cinco,
        Seis,
    };
    private static int numPalabras;
    private static boolean primeraLetra;

    public static int getNumPalabras() {
        return numPalabras;
    }
    public static boolean isPrimeraLetra() {
        return primeraLetra;
    }

    public static void setNumPalabras(int numPalabras) {
        Configuracion.numPalabras = numPalabras;
    }

    public static void setPrimeraLetra(boolean primeraLetra) {
        Configuracion.primeraLetra = primeraLetra;
    }
}
