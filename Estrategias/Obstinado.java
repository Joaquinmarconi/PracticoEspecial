package src.Estrategias;
import src.*;
import java.util.ArrayList;

public class Obstinado extends Estrategia {

   private String nombre_atributo;

   public Obstinado (String nombre_atributo){
    this.nombre_atributo = nombre_atributo;
   }

    @Override
    public Atributo seleccionarAtributo(Carta carta) {

        ArrayList<Atributo> atributos = new ArrayList<Atributo>(carta.getAtributos());
        Atributo atributo_definitivo = null;

        for (Atributo atributo : atributos) {
            if (atributo.getNombre().equals(nombre_atributo)) {
                atributo_definitivo = atributo;
                break;
            }
        }
        return atributo_definitivo;
    }
}
