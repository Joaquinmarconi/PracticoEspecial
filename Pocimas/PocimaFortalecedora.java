package src.Pocimas;
import src.*;

public class PocimaFortalecedora extends Pocima {
    
    public PocimaFortalecedora(String nombre, int valor) {
        super(nombre, valor);

    }

    @Override
    public void aplicarPocima(Carta carta){
        
        double porcentaje = valor / 100.0;

        for(Atributo atributo: carta.getAtributos()){
            int valor_actual = atributo.getValor();
            atributo.setValor((int)(valor_actual * (1 + porcentaje)));
        }
    };
    


}
