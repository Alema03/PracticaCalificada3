import static org.junit.jupiter.api.Assertions.*;

import org.example.Habitacion;
import org.example.Objeto;
import org.example.Acertijo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HabitacionTest {
    private Habitacion habitacion;
    private Objeto llave;

    @BeforeEach
    public void setUp() {
        habitacion = new Habitacion("Entrada", "Estás en la entrada.");
        llave = new Objeto("Llave", "Una llave vieja y oxidada.");
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

    @Test
    public void testAgregarYRecogerObjeto() {
        habitacion.agregarObjeto(llave);
        Objeto recogido = habitacion.recogerObjeto("Llave");
        assertEquals(llave, recogido);
    }

    @Test
    public void testResolverAcertijo() {
        Acertijo acertijo = new Acertijo("Pregunta", "Respuesta");
        habitacion.setAcertijo(acertijo);
        assertTrue(habitacion.resolverAcertijo("Respuesta"));
    }
}