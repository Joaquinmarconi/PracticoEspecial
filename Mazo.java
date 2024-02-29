package src;
import java.util.ArrayList;

public class Mazo {

    private ArrayList<Carta> mazo;

    public Mazo(){
        this.mazo = new ArrayList<>();
    }

    public Carta getCarta(int i){
        return mazo.get(i);
    }

    public ArrayList<Carta> getCartas() {
        return new ArrayList<Carta>(mazo);
    }

    public void agregarCarta(Carta carta) {
        mazo.add(carta);
    }

    public void removerCarta(int indice){
        mazo.remove(indice);
    }

    public int getCantidadCartas() {
        return mazo.size();
    }

    public boolean verificarCartas() {

        for (int i = 0; i < mazo.size(); i++) {
            if (!mazo.get(i).tieneMismosAtributos(mazo.get(0))) {
                return false;
            }
        }
        return true;
    }



}