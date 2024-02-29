package src.Estrategias;
import src.*;
import java.util.ArrayList;

public class Ambicioso extends Estrategia {

    @Override
    public Atributo seleccionarAtributo(Carta carta) {

        ArrayList<Atributo> atributos = carta.getAtributos();
        Atributo atributoMayor = atributos.get(0);

        for (Atributo atributo : atributos) {
            if (atributo.getValor() > atributoMayor.getValor()) {
                atributoMayor = atributo;
            }
        }

        return atributoMayor;
    }

}
