package org.example;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Jugador {
    private Habitacion ubicacionActual;
    private List<Objeto> inventario;
    public Jugador(Habitacion ubicacionInicial) {
        this.ubicacionActual = ubicacionInicial;
        this.inventario = new ArrayList<>();
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

    public void recogerObjeto(Objeto objeto) {
        inventario.add(objeto);
    }

    public void usarObjeto(String nombreObjeto) {
        Objeto objeto = buscarObjeto(nombreObjeto);
        if (objeto != null) {
            System.out.println("Usando el objeto: " + objeto.getNombre());
            inventario.remove(objeto);
        } else {
            System.out.println("No tienes ese objeto.");
        }
    }

    private Objeto buscarObjeto(String nombre) {
        for (Objeto objeto : inventario) {
            if (objeto.getNombre().equalsIgnoreCase(nombre)) {
                return objeto;
            }
        }
        return null;
    }

    public List<Objeto> getInventario() {
        return inventario;
    }
}

