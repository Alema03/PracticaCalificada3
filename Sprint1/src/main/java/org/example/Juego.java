package org.example;

import java.util.HashMap;
import java.util.Map;

public class Juego {
    private Jugador jugador;
    private Map<String, Habitacion> habitaciones;

    public Juego() {
        habitaciones = new HashMap<>();
        inicializarHabitaciones();
        jugador = new Jugador(habitaciones.get("entrada"));
    }

    private void inicializarHabitaciones() {
        Habitacion entrada = new Habitacion("Entrada", "");
        Habitacion salon = new Habitacion("Salon", "Estás en un salón.");
        Habitacion cocina = new Habitacion("Cocina", "Estás en una cocina.");

        entrada.setSalida("norte", salon);
        salon.setSalida("sur", entrada);
        salon.setSalida("oeste", cocina);
        cocina.setSalida("este", salon);

        habitaciones.put("entrada", entrada);
        habitaciones.put("salon", salon);
        habitaciones.put("cocina", cocina);
    }

    public void jugar() {
        // Lógica del juego
        System.out.println(jugador.getUbicacionActual().getDescripcion());
    }

    public void procesarComando(String comando) {
        // Procesar comandos como "mover sur"
        if (comando.startsWith("mover ")) {
            String direccion = comando.split(" ")[1];
            jugador.mover(direccion);
            System.out.println("Te mueves al "+ direccion+". "+jugador.getUbicacionActual().getDescripcion());

        } else {
            System.out.println("Comando no reconocido.");
        }
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        System.out.println("Estás en una habitación oscura. Las salidas están al norte y al este.");
        juego.jugar();
        juego.procesarComando("mover norte");
        juego.procesarComando("mover oeste");
    }

    public Jugador getJugador() {
        return jugador;
    }
}
