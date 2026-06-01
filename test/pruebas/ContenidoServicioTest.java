package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import repositorio.ContenidoRepositorio;
import servicio.ContenidoServicio;
import uni1a.Actor;
import uni1a.ContenidoAudiovisual;
import uni1a.Pelicula;

public class ContenidoServicioTest {

    @Test
    public void testAgregarContenido() {
        ContenidoRepositorio repositorioFalso = new ContenidoRepositorio() {

            @Override
            public List<ContenidoAudiovisual> leerContenidos() throws IOException {
                return new ArrayList<>();
            }

            @Override
            public void guardarContenidos(List<ContenidoAudiovisual> contenidos) throws IOException {
                // No hace nada porque es una prueba
            }
        };

        ContenidoServicio servicio = new ContenidoServicio(repositorioFalso);

        Actor actor = new Actor("Leonardo DiCaprio", 49, "Jack Dawson");
        Pelicula pelicula = new Pelicula("Titanic", 195, "Drama", "Paramount Pictures", actor);

        servicio.agregarContenido(pelicula);

        assertEquals(1, servicio.obtenerContenidos().size());
        assertFalse(servicio.estaVacio());
    }

    @Test
    public void testListaInicialVacia() {
        ContenidoRepositorio repositorioFalso = new ContenidoRepositorio() {

            @Override
            public List<ContenidoAudiovisual> leerContenidos() throws IOException {
                return new ArrayList<>();
            }

            @Override
            public void guardarContenidos(List<ContenidoAudiovisual> contenidos) throws IOException {
                // No hace nada porque es una prueba
            }
        };

        ContenidoServicio servicio = new ContenidoServicio(repositorioFalso);

        assertTrue(servicio.estaVacio());
        assertEquals(0, servicio.obtenerContenidos().size());
    }
}