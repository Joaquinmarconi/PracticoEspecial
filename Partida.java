package src;

import src.Pocimas.*;
import java.util.ArrayList;

public class Partida {

    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorEnTurno;
    private final int maxRondas;
    private Mazo mazo;
    private ArrayList<Pocima> pocimas;

    public Partida(Jugador jugador1, Jugador jugador2, int maxRondas, Mazo mazo) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.jugadorEnTurno = jugador1;
        this.maxRondas = maxRondas;
        this.mazo = mazo;
        this.pocimas = new ArrayList<>();
    }

    public void repartir() {

        ArrayList<Carta> cartas = mazo.getCartas();

        if (pocimas.size() != 0) {

            for (Pocima pocima : this.pocimas) {
                int indiceAleatorio = (int) (Math.random() * cartas.size());
                cartas.get(indiceAleatorio).setPocima(pocima);
            }
        }

        for (int i = 0; i < cartas.size(); i++) {
            if (i % 2 == 0) {
                jugador1.getMazo().agregarCarta(cartas.get(i));
            } else {
                jugador2.getMazo().agregarCarta(cartas.get(i));
            }
        }
    }

    public void setMazo(Mazo mazo) {

        this.mazo = mazo;

    }

    public void agregarPocima(Pocima pocima) {
        this.pocimas.add(pocima);
    }

    public ArrayList<Pocima> getPocimas(){
        return new ArrayList<Pocima>(pocimas);
    }

    public void jugar() {

        this.repartir();
        int rondas = 0;
        this.jugadorEnTurno = this.jugador1;

        while (jugador1.leQuedanCartas() && jugador2.leQuedanCartas() && rondas < maxRondas) {
            jugarRonda();
            rondas++;
        }

        System.out.println("Juego finalizado.");

    }

    public void jugarRonda() {

        Jugador otroJugador = obtenerOtroJugador();
        Carta cartaJugadorEnTurno = obtenerCarta(jugadorEnTurno);
        Carta cartaOtroJugador = obtenerCarta(otroJugador);

        Atributo atributoJugadorEnTurno = jugadorEnTurno.getEstrategia().seleccionarAtributo(cartaJugadorEnTurno);
        Atributo atributoOtroJugador = cartaOtroJugador.obtenerAtributoPorNombre(atributoJugadorEnTurno.getNombre());

        imprimirMensajeCarta(cartaJugadorEnTurno, atributoJugadorEnTurno, jugadorEnTurno);
        aplicarPocimaSiExiste(cartaJugadorEnTurno, atributoJugadorEnTurno);
        imprimirMensajeCarta(cartaOtroJugador, atributoOtroJugador, otroJugador);
        aplicarPocimaSiExiste(cartaOtroJugador, atributoOtroJugador);
        compararAtributosYResolverRonda(atributoJugadorEnTurno, atributoOtroJugador, otroJugador);

        mostrarCantidadDeCartas();
    }

    public void resolverRonda(Jugador ganador, Jugador perdedor) {
        
        Carta carta_1 = ganador.getMazo().getCarta(0);
        Carta carta_2 = perdedor.getMazo().getCarta(0);
        ganador.getMazo().agregarCarta(carta_1);
        ganador.getMazo().agregarCarta(carta_2);
        ganador.getMazo().removerCarta(0);
        perdedor.getMazo().removerCarta(0);
    }

    public void manejarEmpate() {
        
        Carta carta_1 = jugador1.getMazo().getCarta(0);
        Carta carta_2 = jugador2.getMazo().getCarta(0);
        jugador1.getMazo().agregarCarta(carta_1);
        jugador2.getMazo().agregarCarta(carta_2);
        jugador1.getMazo().removerCarta(0);
        jugador2.getMazo().removerCarta(0);
        
    }

    private Jugador obtenerOtroJugador() {
        return (this.jugadorEnTurno == this.jugador1) ? this.jugador2 : this.jugador1;
    }

    private Carta obtenerCarta(Jugador jugador) {
        return jugador.getMazo().getCartas().get(0);
    }

    private void aplicarPocimaSiExiste(Carta carta, Atributo atributo) {
        if (carta.tienePocima()) {
            carta.getPocima().aplicarPocima(carta);
            System.out.println(", se aplicó pócima " + carta.getPocima().getNombre() + " valor resultante "
                    + atributo.getValor());
        }
    }

    private void imprimirMensajeCarta(Carta carta, Atributo atributo, Jugador jugador) {
        System.out.println("La carta de " + jugador + " es " + carta.getNombre() + " con "
                + atributo.getNombre() + " " + atributo.getValor());
    }

    private void compararAtributosYResolverRonda(Atributo atributoJugadorEnTurno, Atributo atributoOtroJugador,
            Jugador otroJugador) {
        if (atributoOtroJugador.getValor() > atributoJugadorEnTurno.getValor()) {
            resolverRonda(otroJugador, jugadorEnTurno);
            jugadorEnTurno = otroJugador;
            System.out.println("Gana la ronda " + jugadorEnTurno);
        } else if (atributoJugadorEnTurno.getValor() > atributoOtroJugador.getValor()) {
            resolverRonda(jugadorEnTurno, otroJugador);
            System.out.println("Gana la ronda " + jugadorEnTurno);
        } else {
            manejarEmpate();
            System.out.println("Empate.");
        }
    }

    private void mostrarCantidadDeCartas() {
        System.out
                .println(jugador1.getNombre() + " posee ahora " + jugador1.getMazo().getCantidadCartas() + " cartas y "
                        + jugador2.getNombre() + " posee ahora " + jugador2.getMazo().getCantidadCartas() + " cartas.");
    }

}
