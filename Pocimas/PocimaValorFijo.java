package src.Pocimas;
import src.*;

public class PocimaValorFijo  extends Pocima {

    public PocimaValorFijo(String nombre, int valor) {
        super(nombre, valor);
    }

    @Override
    public void aplicarPocima(Carta carta) {
        for (Atributo atributo : carta.getAtributos()) {
            atributo.setValor(valor);
        }
    }

}
