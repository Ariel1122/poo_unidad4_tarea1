package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uni1a.Documental;
import uni1a.Investigador;

public class DocumentalTest {

    @Test
    public void testCrearDocumentalCorrectamente() {
        Investigador investigador = new Investigador("Carl Sagan", "Astronomía", "NASA");

        Documental documental = new Documental(
                "Cosmos",
                45,
                "Science",
                "Astronomy",
                investigador
        );

        assertEquals("Cosmos", documental.getTitulo());
        assertEquals(45, documental.getDuracionEnMinutos());
        assertEquals("Science", documental.getGenero());
        assertEquals("Astronomy", documental.getTema());
        assertEquals("Carl Sagan", documental.getInvestigador().getNombre());
    }

    @Test
    public void testObtenerDetallesDocumental() {
        Investigador investigador = new Investigador("Carl Sagan", "Astronomía", "NASA");
        Documental documental = new Documental("Cosmos", 45, "Science", "Astronomy", investigador);

        String detalles = documental.obtenerDetalles();

        assertTrue(detalles.contains("Cosmos"));
        assertTrue(detalles.contains("Astronomy"));
        assertTrue(detalles.contains("Carl Sagan"));
    }
}