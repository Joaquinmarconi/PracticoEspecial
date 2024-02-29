package src.Pocimas;
import src.*;
import java.util.ArrayList;

public class PocimaCocktail extends Pocima {

    private ArrayList<Pocima> pocimas;

    public PocimaCocktail(String nombre, int valor) {
        super(nombre, valor);
        this.pocimas = new ArrayList<>();
    }

    public void agregarPocima(Pocima pocima) {
        this.pocimas.add(pocima);
    }

    @Override
    public void aplicarPocima(Carta carta) {
        for (Pocima pocima : pocimas) {
            pocima.aplicarPocima(carta);
        }
    }
}
