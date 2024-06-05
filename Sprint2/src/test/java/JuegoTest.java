import static org.junit.jupiter.api.Assertions.*;

import org.example.Juego;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JuegoTest {
    private Juego juego;

    @BeforeEach
    public void setUp() {
        juego = new Juego();
    }

    @Test
    public void testInicializacionDelJuego() {
        assertNotNull(juego.getJugador());
        assertEquals("Entrada", juego.getJugador().getUbicacionActual().getNombre());
    }

    @Test
    public void testMovimientoJugador() {
        juego.procesarComando("mover norte");
        assertEquals("Salon", juego.getJugador().getUbicacionActual().getNombre());
        juego.procesarComando("mover oeste");
        assertEquals("Cocina", juego.getJugador().getUbicacionActual().getNombre());
        juego.procesarComando("mover este");
        assertEquals("Salon", juego.getJugador().getUbicacionActual().getNombre());
    }
}