package org.example;
import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private Habitacion ubicacionActual;
    private List<Objeto> inventario;

    public Jugador(Habitacion ubicacionInicial) {
        this.ubicacionActual = ubicacionInicial;
        this.inventario = new ArrayList<>();
    }

    public void mover(String direccion) {
        if (ubicacionActual.tienePuerta(direccion)) {
            System.out.println("La puerta está cerrada. Necesitas un objeto para abrirla.");
            return;
        }
        Habitacion nuevaUbicacion = ubicacionActual.getSalida(direccion);
        if (nuevaUbicacion != null) {
            ubicacionActual = nuevaUbicacion;
        } else {
            System.out.println("No puedes ir en esa dirección.");
        }
    }

    public Habitacion getUbicacionActual() {
        return ubicacionActual;
    }

    public void recogerObjeto(Objeto objeto) {
        inventario.add(objeto);
    }

    public void usarObjeto(String nombreObjeto) {
        for (Objeto objeto : inventario) {
            if (objeto.getNombre().equalsIgnoreCase(nombreObjeto)) {
                if (!ubicacionActual.abrirPuerta(nombreObjeto)) {
                    System.out.println("Has abierto la puerta con " + objeto.getNombre() + ".");
                    inventario.remove(objeto);
                    return;
                } else {
                    System.out.println("Este objeto no puede usarse para abrir una puerta.");
                    return;
                }
            }
        }
        System.out.println("No tienes ese objeto.");
    }



    public List<Objeto> getInventario() {
        return inventario;
    }
}

