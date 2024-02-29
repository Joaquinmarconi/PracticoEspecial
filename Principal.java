package src;

import src.Estrategias.*;
import src.Pocimas.*;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Mazo mazo = new Mazo();

        crearMazo(scanner, random, mazo);

        Jugador jugador_1 = crearJugador(scanner);
        Jugador jugador_2 = crearJugador(scanner);

        Partida partida = crearPartida(scanner, jugador_1, jugador_2, mazo);

        System.out.println("Presione enter para iniciar el juego:");
        scanner.nextLine();
        scanner.close();

        partida.jugar();

    }

    private static Estrategia obtenerEstrategia(Scanner scanner) {
        Estrategia estrategia = null;
        System.out.println("Ingrese '1' para Timbero, '2' para Ambicioso, y '3' para Obstinado.");
        while (estrategia == null) {
            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    estrategia = new Timbero();
                    break;
                case "2":
                    estrategia = new Ambicioso();
                    break;
                case "3":
                    System.out.println("Ingrese '1' para Altura, '2' para Peso, '3' para Fuerza y '4' para Velocidad");
                    String atributo = scanner.nextLine();

                    switch (atributo) {
                        case "1":
                            estrategia = new Obstinado("Altura");
                            break;
                        case "2":
                            estrategia = new Obstinado("Peso");
                            break;
                        case "3":
                            estrategia = new Obstinado("Fuerza");
                            break;
                        case "4":
                            estrategia = new Obstinado("Velocidad");
                            break;
                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                    }
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        return estrategia;
    }

    private static Carta crearCarta(String nombre, Random random) {

        Carta carta = new Carta(nombre);
        carta.agregarAtributo(new Atributo("Altura", random.nextInt(500) + 1));
        carta.agregarAtributo(new Atributo("Peso", random.nextInt(500) + 1));
        carta.agregarAtributo(new Atributo("Fuerza", random.nextInt(500) + 1));
        carta.agregarAtributo(new Atributo("Velocidad", random.nextInt(500) + 1));

        return carta;

    }

    private static void crearMazo(Scanner scanner, Random random, Mazo mazo) {
        
        boolean cartasValidas;

        Carta superman = crearCarta("Superman", random);
        mazo.agregarCarta(superman);
        Carta batman = crearCarta("Batman", random);
        mazo.agregarCarta(batman);
        Carta wonderWoman = crearCarta("Wonder Woman", random);
        mazo.agregarCarta(wonderWoman);
        Carta flash = crearCarta("Flash", random);
        mazo.agregarCarta(flash);
        Carta greenLantern = crearCarta("Green Lantern", random);
        mazo.agregarCarta(greenLantern);
        Carta aquaman = crearCarta("Aquaman",random);
        mazo.agregarCarta(aquaman);

        cartasValidas = mazo.verificarCartas();
        if (!cartasValidas) {
            System.out.println("Al menos una carta no es correcta.");
        }

    }

    private static Jugador crearJugador(Scanner scanner) {

        System.out.print("Ingrese el nombre del Jugador: ");
        String nombreJugador = scanner.nextLine();
        Estrategia estrategiaJugador1 = obtenerEstrategia(scanner);
        Jugador jugador = new Jugador(nombreJugador, estrategiaJugador1);

        return jugador;

    }

    private static Partida crearPartida(Scanner scanner, Jugador jugador_1, Jugador jugador_2, Mazo mazo) {

        System.out.println("Presiona Enter para crear una Partida");
        scanner.nextLine();

        int maxRondas = 0;
        while (true) {
            try {
                System.out.println("Ingresa el número máximo de rondas:");
                maxRondas = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingresa un número válido.");
                scanner.next();
            }
        }

        Partida partida = new Partida(jugador_1, jugador_2, maxRondas, mazo);

        PocimaFortalecedora fortalecedora = new PocimaFortalecedora("fortalecedora", maxRondas);
        partida.agregarPocima(fortalecedora);
        PocimaFortalecedora fortalecedoraPlus = new PocimaFortalecedora("FortalecedoraPlus", 50);
        partida.agregarPocima(fortalecedoraPlus);
        PocimaDebilitadora kriptonita = new PocimaDebilitadora("Kriptonita", 25);
        partida.agregarPocima(kriptonita);
        PocimaDebilitadora reductorPlomo = new PocimaDebilitadora("reductorPlomo", 55);
        partida.agregarPocima(reductorPlomo);
        PocimaValorFijo quieroValeCuatro = new PocimaValorFijo("quieroValeCuatro", 4);
        partida.agregarPocima(quieroValeCuatro);
        PocimaValorFijo numeroMagico = new PocimaValorFijo("numeroMagico", 35);
        partida.agregarPocima(numeroMagico);
        PocimaSelectiva pocimaSelectivaFuerza = new PocimaSelectiva("pocimaSelectivaFuerza", 0, "Fuerza");
        PocimaCocktail cocktail = new PocimaCocktail("cocktail", 0);

        cocktail.agregarPocima(pocimaSelectivaFuerza);
        cocktail.agregarPocima(numeroMagico);
        partida.agregarPocima(cocktail);

        System.out.println("¡Partida creada con éxito!");

        return partida;

    }
}