import org.example.Acertijo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AcertijoTest {
    @Test
    public void testResolverAcertijo() {
        Acertijo acertijo = new Acertijo("¿Qué tiene una cabeza, una cola, es marrón, y no tiene patas?", "Una moneda");
        assertTrue(acertijo.resolver("Una moneda"));
        assertFalse(acertijo.resolver("Un gato"));
    }
}
