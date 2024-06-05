package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Juego {
    private Jugador jugador;
    private Map<String, Habitacion> habitaciones;

    public Juego() {
        habitaciones = new HashMap<>();
        inicializarHabitaciones();
        jugador = new Jugador(habitaciones.get("entrada"));
    }

    private void inicializarHabitaciones() {
        Habitacion entrada = new Habitacion("Entrada", "Estás en una habitación oscura. Las salidas están al norte y al este.");
        Habitacion salon = new Habitacion("Salon", "Estás en un salón.");
        Habitacion cocina = new Habitacion("Cocina", "Estás en una cocina.");

        entrada.setSalida("norte", salon);
        salon.setSalida("sur", entrada);
        salon.setSalida("este", cocina);
        cocina.setSalida("oeste", cocina);

        Objeto llave = new Objeto("llave", "Una llave vieja y oxidada.");
        salon.agregarObjeto(llave);

        Acertijo acertijo = new Acertijo("¿Qué tiene una cabeza, una cola, es marrón, y no tiene patas?", "moneda");
        cocina.setAcertijo(acertijo);
        habitaciones.put("entrada", entrada);
        habitaciones.put("salon", salon);
        habitaciones.put("cocina", cocina);
    }

    public void jugar() {
        // Lógica del juego
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(jugador.getUbicacionActual().getDescripcion());
            System.out.print("> ");
            String comando = scanner.nextLine();
            procesarComando(comando);
        }
    }

    public void procesarComando(String comando) {
        if (comando.startsWith("mover ")) {
            String direccion = comando.split(" ")[1];
            jugador.mover(direccion);
        } else if (comando.startsWith("recoger ")) {
            String nombreObjeto = comando.split(" ")[1];
            Objeto objeto = jugador.getUbicacionActual().recogerObjeto(nombreObjeto);
            if (objeto != null) {
                jugador.recogerObjeto(objeto);
                System.out.println("Has recogido la " + objeto.getNombre() + ".");
            } else {
                System.out.println("No hay tal objeto aquí.");
            }
        } else if (comando.startsWith("usar ")) {
            String nombreObjeto = comando.split(" ")[1];
            jugador.usarObjeto(nombreObjeto);
        } else if (comando.startsWith("resolver acertijo")) {
            System.out.print("Introduce tu respuesta: ");
            Scanner scanner = new Scanner(System.in);
            String respuesta = scanner.nextLine();
            if (jugador.getUbicacionActual().resolverAcertijo(respuesta)) {
                System.out.println("¡Acertijo resuelto!");
            } else {
                System.out.println("Respuesta incorrecta.");
            }
        } else {
            System.out.println("Comando no reconocido.");
        }
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.jugar();
    }

    public Jugador getJugador() {
        return jugador;
    }
}



