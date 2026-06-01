package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uni1a.Actor;
import uni1a.Pelicula;

public class PeliculaTest {

    @Test
    public void testCrearPeliculaCorrectamente() {
        Actor actor = new Actor("Sam Worthington", 47, "Jake Sully");

        Pelicula pelicula = new Pelicula(
                "Avatar",
                125,
                "Accion",
                "20th Century Studios",
                actor
        );

        assertEquals("Avatar", pelicula.getTitulo());
        assertEquals(125, pelicula.getDuracionEnMinutos());
        assertEquals("Accion", pelicula.getGenero());
        assertEquals("20th Century Studios", pelicula.getEstudio());
        assertEquals("Sam Worthington", pelicula.getActorPrincipal().getNombre());
    }

    @Test
    public void testObtenerDetallesPelicula() {
        Actor actor = new Actor("Sam Worthington", 47, "Jake Sully");
        Pelicula pelicula = new Pelicula("Avatar", 125, "Accion", "20th Century Studios", actor);

        String detalles = pelicula.obtenerDetalles();

        assertTrue(detalles.contains("Avatar"));
        assertTrue(detalles.contains("20th Century Studios"));
        assertTrue(detalles.contains("Sam Worthington"));
    }
}