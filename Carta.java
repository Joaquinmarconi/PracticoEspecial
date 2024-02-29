package src;
import src.Pocimas.*;
import java.util.ArrayList;

public class Carta {
    private String nombre;
    private ArrayList<Atributo> atributos;
    private Pocima pocima;

    public Carta(String nombre) {
        this.nombre = nombre;
        this.atributos = new ArrayList<Atributo>();
        this.pocima = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPocima(Pocima pocima) {
        this.pocima = pocima;
    }

    public boolean tieneMismosAtributos(Carta otra) {
        if (this.atributos.size() != otra.getAtributos().size()) {
            return false;
        }

        for (Atributo atributo : this.atributos) {
            if (!otra.getAtributos().contains(atributo)) {
                return false;
            }
        }

        return true;
    }

    public void agregarAtributo(Atributo atributo) {
        this.atributos.add(atributo);
    }

    public Atributo getAtributo(int indice) {
        return atributos.get(indice);
    }

    public Atributo obtenerAtributoPorNombre(String nombreAtributo) {
        for (Atributo atributo : this.atributos) {
            if (atributo.getNombre().equalsIgnoreCase(nombreAtributo)) {
                return atributo;
            }
        }
        return null;
    }

    public ArrayList<Atributo> getAtributos() {
        return new ArrayList<Atributo>(atributos);
    }

    public boolean tienePocima() {
        return pocima != null;
    }

    public Pocima getPocima() {

        return this.pocima;

    }

}
