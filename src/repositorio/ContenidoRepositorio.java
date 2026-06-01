package repositorio;

import java.io.IOException;
import java.util.List;
import uni1a.ContenidoAudiovisual;

// Interfaz que define las operaciones para leer y guardar contenidos
public interface ContenidoRepositorio {

    // Lee contenidos desde una fuente de datos, en este caso un archivo CSV
    List<ContenidoAudiovisual> leerContenidos() throws IOException;

    // Guarda contenidos en una fuente de datos, en este caso un archivo CSV
    void guardarContenidos(List<ContenidoAudiovisual> contenidos) throws IOException;
}