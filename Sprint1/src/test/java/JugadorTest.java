import static org.junit.jupiter.api.Assertions.*;

import org.example.Habitacion;
import org.example.Jugador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JugadorTest {
    private Jugador jugador;
    private Habitacion entrada;
    private Habitacion salon;

    @BeforeEach
    public void setUp() {
        entrada = new Habitacion("Entrada", "Estás en la entrada.");
        salon = new Habitacion("Salon", "Estás en el salón.");
        entrada.setSalida("norte", salon);
        jugador = new Jugador(entrada);
    }

    @Test
    public void testMoverJugador() {
        assertEquals("Entrada", jugador.getUbicacionActual().getNombre());
        jugador.mover("norte");
        assertEquals("Salon", jugador.getUbicacionActual().getNombre());
    }

    @Test
    public void testMovimientoInvalido() {
        assertEquals("Entrada", jugador.getUbicacionActual().getNombre());
        jugador.mover("sur");
        assertEquals("Entrada", jugador.getUbicacionActual().getNombre());
    }
}
