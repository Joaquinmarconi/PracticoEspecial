package src.Estrategias;
import src.*;
import java.util.Random;

public class Timbero extends Estrategia {

    @Override
    public Atributo seleccionarAtributo(Carta carta) {
        
        Random rand = new Random();
        int indiceAleatorio = rand.nextInt(carta.getAtributos().size());

        Atributo atributo = carta.getAtributo(indiceAleatorio);

        return atributo;
    }
    
}
