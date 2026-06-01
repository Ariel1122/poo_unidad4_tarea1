package servicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import repositorio.ContenidoRepositorio;
import uni1a.ContenidoAudiovisual;

// Clase que contiene la lógica principal del sistema
public class ContenidoServicio {

    private List<ContenidoAudiovisual> contenidos; //Lista donde se guardan los contenidos
    private ContenidoRepositorio repositorio; //Dependencia hacia la interfaz del repositorio

    // Constructor del servicio
    public ContenidoServicio(ContenidoRepositorio repositorio) {
        this.repositorio = repositorio;
        this.contenidos = new ArrayList<>();
    }

    // Carga los contenidos desde el archivo CSV usando el repositorio
    public void cargarContenidos() throws IOException {
        contenidos = repositorio.leerContenidos();
    }

    // Guarda los contenidos actuales en el archivo CSV
    public void guardarContenidos() throws IOException {
        repositorio.guardarContenidos(contenidos);
    }

    // Agrega un nuevo contenido a la lista
    public void agregarContenido(ContenidoAudiovisual contenido) {
        if (contenido != null) {
            contenidos.add(contenido);
        }
    }

    // Devuelve la lista actual de contenidos
    public List<ContenidoAudiovisual> obtenerContenidos() {
        return contenidos;
    }

    // Verifica si la lista está vacía
    public boolean estaVacio() {
        return contenidos.isEmpty();
    }
}