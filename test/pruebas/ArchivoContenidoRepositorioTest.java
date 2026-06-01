package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import repositorio.ArchivoContenidoRepositorio;
import uni1a.Actor;
import uni1a.ContenidoAudiovisual;
import uni1a.Pelicula;

public class ArchivoContenidoRepositorioTest {

    @TempDir
    Path carpetaTemporal;

    @Test
    public void testGuardarYLeerContenidos() throws IOException {
        Path archivoTemporal = carpetaTemporal.resolve("contenidos_test.csv");

        ArchivoContenidoRepositorio repositorio =
                new ArchivoContenidoRepositorio(archivoTemporal.toString());

        Actor actor = new Actor("Sam Worthington", 47, "Jake Sully");
        Pelicula pelicula = new Pelicula("Avatar", 125, "Accion", "20th Century Studios", actor);

        List<ContenidoAudiovisual> contenidos = new ArrayList<>();
        contenidos.add(pelicula);

        repositorio.guardarContenidos(contenidos);

        List<ContenidoAudiovisual> contenidosLeidos = repositorio.leerContenidos();

        assertEquals(1, contenidosLeidos.size());
        assertEquals("Avatar", contenidosLeidos.get(0).getTitulo());
        assertTrue(contenidosLeidos.get(0) instanceof Pelicula);
    }
}