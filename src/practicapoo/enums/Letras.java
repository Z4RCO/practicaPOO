package practicapoo.enums;

public enum Letras{
    CINCO(5),
    SEIS(6);

    private final int size;
    Letras(int letras){
        size = letras;
    }

    public int getSize(){
        return this.size;
    }
}