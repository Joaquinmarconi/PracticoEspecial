package src.Pocimas;
import src.*;

public class PocimaSelectiva extends Pocima {

    private String atributo;

    public PocimaSelectiva(String nombre, int valor, String atributo) {
        super(nombre, valor);
        this.atributo = atributo;
     
    }

    @Override
    public void aplicarPocima(Carta carta){
        
        double porcentaje = valor / 100.0;
        
        for(Atributo atributo: carta.getAtributos()){
            int valor_actual = atributo.getValor();
            if(atributo.getNombre().equals(this.atributo)){
            atributo.setValor((int)(valor_actual * (1 + porcentaje)));
            }
        }
    };
    

}
