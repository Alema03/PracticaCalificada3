import static org.junit.jupiter.api.Assertions.*;

import org.example.Habitacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HabitacionTest {
    private Habitacion habitacion;

    @BeforeEach
    public void setUp() {
        habitacion = new Habitacion("Entrada", "Estás en la entrada.");
    }

    @Test
    public void testCrearHabitacion() {
        assertEquals("Entrada", habitacion.getNombre());
        assertEquals("Estás en la entrada.", habitacion.getDescripcion());
    }

    @Test
    public void testSalidasHabitacion() {
        Habitacion salon = new Habitacion("Salon", "Estás en el salón.");
        habitacion.setSalida("norte", salon);
        assertEquals(salon, habitacion.getSalida("norte"));
    }
}