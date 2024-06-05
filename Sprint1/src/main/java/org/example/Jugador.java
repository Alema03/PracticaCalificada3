package org.example;

public class Jugador {
    private Habitacion ubicacionActual;

    public Jugador(Habitacion ubicacionInicial) {
        this.ubicacionActual = ubicacionInicial;
    }

    public void mover(String direccion) {
        Habitacion nuevaUbicacion = ubicacionActual.getSalida(direccion);
        if (nuevaUbicacion != null) {
            ubicacionActual = nuevaUbicacion;
        } else {
            System.out.println("No puedes moverte en esa dirección.");
        }
    }

    public Habitacion getUbicacionActual() {
        return ubicacionActual;
    }
}
