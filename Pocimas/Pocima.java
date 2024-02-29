package src.Pocimas;
import src.*;

public abstract class Pocima {
    
    protected String nombre;
    protected int valor;

    public Pocima(String nombre, int valor){
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void aplicarPocima(Carta carta){};
}
