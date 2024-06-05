package org.example;

public class Acertijo {
    private String pregunta;
    private String respuesta;

    public Acertijo(String pregunta, String respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public boolean resolver(String respuesta) {
        return this.respuesta.equalsIgnoreCase(respuesta);
    }

    public String getPregunta() {
        return pregunta;
    }
}
