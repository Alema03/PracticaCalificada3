package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Habitacion {
    private String nombre;
    private String descripcion;
    private Map<String, Habitacion> salidas;
    private List<Objeto> objetos;
    private Acertijo acertijo;
    private boolean acertijoResuelto;

    public Habitacion(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.salidas = new HashMap<>();
        this.objetos = new ArrayList<>();
        this.acertijoResuelto = false;
    }

    public void setSalida(String direccion, Habitacion habitacion) {
        salidas.put(direccion, habitacion);
    }

    public Habitacion getSalida(String direccion) {
        return salidas.get(direccion);
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarObjeto(Objeto objeto) {
        objetos.add(objeto);
    }

    public Objeto recogerObjeto(String nombre) {
        for (Objeto objeto : objetos) {
            if (objeto.getNombre().equalsIgnoreCase(nombre)) {
                objetos.remove(objeto);
                return objeto;
            }
        }
        return null;
    }


    public void setAcertijo(Acertijo acertijo) {
        this.acertijo = acertijo;
    }

    public String getDescripcion() {
        StringBuilder descripcionCompleta = new StringBuilder(descripcion);
        if (!objetos.isEmpty()) {
            for (Objeto objeto : objetos) {
                descripcionCompleta.append("\nVes una ").append(objeto.getNombre()).append(" en el suelo.");
            }
        }
        if (acertijo != null && !acertijoResuelto) {
            descripcionCompleta.append("\nAcertijo: ").append(acertijo.getPregunta());
        }
        return descripcionCompleta.toString();
    }
    public boolean resolverAcertijo(String respuesta) {
        if (acertijo != null && !acertijoResuelto) {
            boolean resultado = acertijo.resolver(respuesta);
            if (resultado) {
                acertijoResuelto = true;
            }
            return resultado;
        }
        return false;
    }
}
