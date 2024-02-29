package src;

import src.Estrategias.*;

public class Jugador {

    private String nombre;
    private Mazo mazo;
    private Estrategia estrategia;

    public Jugador(String nombre, Estrategia estrategia) {

        this.nombre = nombre;
        this.mazo = new Mazo();
        this.estrategia = estrategia;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    public Mazo getMazo() {
        return this.mazo;
    }

    public String getNombre() {
        return nombre;
    }

    public Estrategia getEstrategia() {
        return estrategia;
    }

    public boolean leQuedanCartas(){
       return mazo.getCantidadCartas() != 0;

    }

}
