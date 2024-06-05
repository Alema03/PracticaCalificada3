package org.example;

import java.util.HashMap;
import java.util.Map;

public class Habitacion {
    private String nombre;
    private String descripcion;
    private Map<String, Habitacion> salidas;

    public Habitacion(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.salidas = new HashMap<>();
    }

    public void setSalida(String direccion, Habitacion habitacion) {
        salidas.put(direccion, habitacion);
    }

    public Habitacion getSalida(String direccion) {
        return salidas.get(direccion);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }
}
