import static org.junit.jupiter.api.Assertions.*;

import org.example.Objeto;
import org.junit.jupiter.api.Test;

public class ObjetoTest {
    @Test
    public void testCrearObjeto() {
        Objeto objeto = new Objeto("Llave", "Una llave vieja y oxidada.");
        assertEquals("Llave", objeto.getNombre());
        assertEquals("Una llave vieja y oxidada.", objeto.getDescripcion());
    }
}

