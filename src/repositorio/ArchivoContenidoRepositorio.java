package repositorio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import uni1a.Actor;
import uni1a.ContenidoAudiovisual;
import uni1a.Documental;
import uni1a.Investigador;
import uni1a.Pelicula;
import uni1a.Podcast;
import uni1a.SerieDeTV;
import uni1a.Temporada;
import uni1a.TransmisionEnVivo;

// Clase encargada de leer y guardar contenidos audiovisuales en un archivo CSV
public class ArchivoContenidoRepositorio implements ContenidoRepositorio {

    private String rutaArchivo; // Ruta del archivo CSV

    public ArchivoContenidoRepositorio(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public List<ContenidoAudiovisual> leerContenidos() throws IOException {
        List<ContenidoAudiovisual> contenidos = new ArrayList<>();

        Path ruta = Paths.get(rutaArchivo);

        // Si el archivo no existe, se crea vacío
        if (!Files.exists(ruta)) {
            if (ruta.getParent() != null) {
                Files.createDirectories(ruta.getParent());
            }

            Files.createFile(ruta);
            return contenidos;
        }

        try (BufferedReader lector = Files.newBufferedReader(ruta)) {
            String linea;
            boolean primeraLinea = true;

            while ((linea = lector.readLine()) != null) {

                // Saltar la primera línea porque es el encabezado
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                // Ignorar líneas vacías
                if (linea.trim().isEmpty()) {
                    continue;
                }

                ContenidoAudiovisual contenido = crearContenidoDesdeLinea(linea);

                if (contenido != null) {
                    contenidos.add(contenido);
                }
            }
        }

        return contenidos;
    }

    @Override
    public void guardarContenidos(List<ContenidoAudiovisual> contenidos) throws IOException {
        Path ruta = Paths.get(rutaArchivo);

        if (ruta.getParent() != null) {
            Files.createDirectories(ruta.getParent());
        }

        try (BufferedWriter escritor = Files.newBufferedWriter(ruta)) {
            escritor.write("TIPO,TITULO,DURACION,GENERO,DATO1,DATO2,DATO3,DATO4,DATO5");
            escritor.newLine();

            for (ContenidoAudiovisual contenido : contenidos) {
                escritor.write(convertirContenidoACsv(contenido));
                escritor.newLine();
            }
        }
    }

    // Crea un contenido audiovisual dependiendo del tipo escrito en el CSV
    private ContenidoAudiovisual crearContenidoDesdeLinea(String linea) {
        String[] datos = linea.split(",", -1);

        try {
            String tipo = obtenerDato(datos, 0).toUpperCase();
            String titulo = obtenerDato(datos, 1);
            int duracion = convertirEntero(obtenerDato(datos, 2));
            String genero = obtenerDato(datos, 3);

            switch (tipo) {
                case "PELICULA":
                    return crearPelicula(datos, titulo, duracion, genero);

                case "SERIE":
                    return crearSerie(datos, titulo, duracion, genero);

                case "DOCUMENTAL":
                    return crearDocumental(datos, titulo, duracion, genero);

                case "PODCAST":
                    return crearPodcast(datos, titulo, duracion, genero);

                case "TRANSMISION":
                    return crearTransmision(datos, titulo, duracion, genero);

                default:
                    return null;
            }

        } catch (Exception e) {
            // Si una línea tiene datos incorrectos, se ignora para evitar que el programa se cierre
            return null;
        }
    }

    private Pelicula crearPelicula(String[] datos, String titulo, int duracion, String genero) {
        String estudio = obtenerDato(datos, 4);
        String nombreActor = obtenerDato(datos, 5);
        int edadActor = convertirEntero(obtenerDato(datos, 6));
        String personaje = obtenerDato(datos, 7);

        Actor actor = new Actor(nombreActor, edadActor, personaje);

        return new Pelicula(titulo, duracion, genero, estudio, actor);
    }

    private SerieDeTV crearSerie(String[] datos, String titulo, int duracion, String genero) {
        int temporadas = convertirEntero(obtenerDato(datos, 4));
        int numeroTemporada = convertirEntero(obtenerDato(datos, 5));
        int cantidadEpisodios = convertirEntero(obtenerDato(datos, 6));
        int anioEstreno = convertirEntero(obtenerDato(datos, 7));

        return new SerieDeTV(titulo, duracion, genero, temporadas, numeroTemporada, cantidadEpisodios, anioEstreno);
    }

    private Documental crearDocumental(String[] datos, String titulo, int duracion, String genero) {
        String tema = obtenerDato(datos, 4);
        String nombreInvestigador = obtenerDato(datos, 5);
        String especialidad = obtenerDato(datos, 6);
        String institucion = obtenerDato(datos, 7);

        Investigador investigador = new Investigador(nombreInvestigador, especialidad, institucion);

        return new Documental(titulo, duracion, genero, tema, investigador);
    }

    private Podcast crearPodcast(String[] datos, String titulo, int duracion, String genero) {
        String plataforma = obtenerDato(datos, 4);
        int numeroEpisodio = convertirEntero(obtenerDato(datos, 5));
        String nombreInvestigador = obtenerDato(datos, 6);
        String especialidad = obtenerDato(datos, 7);
        String institucion = obtenerDato(datos, 8);

        Investigador investigador = new Investigador(nombreInvestigador, especialidad, institucion);

        return new Podcast(titulo, duracion, genero, plataforma, numeroEpisodio, investigador);
    }

    private TransmisionEnVivo crearTransmision(String[] datos, String titulo, int duracion, String genero) {
        String plataforma = obtenerDato(datos, 4);
        int espectadores = convertirEntero(obtenerDato(datos, 5));
        String nombrePresentador = obtenerDato(datos, 6);
        int edadPresentador = convertirEntero(obtenerDato(datos, 7));
        String rolPresentador = obtenerDato(datos, 8);

        Actor presentador = new Actor(nombrePresentador, edadPresentador, rolPresentador);

        return new TransmisionEnVivo(titulo, duracion, genero, plataforma, espectadores, presentador);
    }

    // Convierte un objeto Java a una línea de texto CSV
    private String convertirContenidoACsv(ContenidoAudiovisual contenido) {

        if (contenido instanceof Pelicula) {
            Pelicula pelicula = (Pelicula) contenido;
            Actor actor = pelicula.getActorPrincipal();

            return unirDatos(
                    "PELICULA",
                    pelicula.getTitulo(),
                    String.valueOf(pelicula.getDuracionEnMinutos()),
                    pelicula.getGenero(),
                    pelicula.getEstudio(),
                    actor != null ? actor.getNombre() : "",
                    actor != null ? String.valueOf(actor.getEdad()) : "",
                    actor != null ? actor.getPersonajeInterpretado() : "",
                    ""
            );
        }

        if (contenido instanceof SerieDeTV) {
            SerieDeTV serie = (SerieDeTV) contenido;
            Temporada temporada = serie.getTemporadaPrincipal();

            return unirDatos(
                    "SERIE",
                    serie.getTitulo(),
                    String.valueOf(serie.getDuracionEnMinutos()),
                    serie.getGenero(),
                    String.valueOf(serie.getTemporadas()),
                    temporada != null ? String.valueOf(temporada.getNumeroTemporada()) : "",
                    temporada != null ? String.valueOf(temporada.getCantidadEpisodios()) : "",
                    temporada != null ? String.valueOf(temporada.getAnioEstreno()) : "",
                    ""
            );
        }

        if (contenido instanceof Documental) {
            Documental documental = (Documental) contenido;
            Investigador investigador = documental.getInvestigador();

            return unirDatos(
                    "DOCUMENTAL",
                    documental.getTitulo(),
                    String.valueOf(documental.getDuracionEnMinutos()),
                    documental.getGenero(),
                    documental.getTema(),
                    investigador != null ? investigador.getNombre() : "",
                    investigador != null ? investigador.getEspecialidad() : "",
                    investigador != null ? investigador.getInstitucion() : "",
                    ""
            );
        }

        if (contenido instanceof Podcast) {
            Podcast podcast = (Podcast) contenido;
            Investigador investigador = podcast.getInvestigadorInvitado();

            return unirDatos(
                    "PODCAST",
                    podcast.getTitulo(),
                    String.valueOf(podcast.getDuracionEnMinutos()),
                    podcast.getGenero(),
                    podcast.getPlataforma(),
                    String.valueOf(podcast.getNumeroEpisodio()),
                    investigador != null ? investigador.getNombre() : "",
                    investigador != null ? investigador.getEspecialidad() : "",
                    investigador != null ? investigador.getInstitucion() : ""
            );
        }

        if (contenido instanceof TransmisionEnVivo) {
            TransmisionEnVivo transmision = (TransmisionEnVivo) contenido;
            Actor presentador = transmision.getPresentador();

            return unirDatos(
                    "TRANSMISION",
                    transmision.getTitulo(),
                    String.valueOf(transmision.getDuracionEnMinutos()),
                    transmision.getGenero(),
                    transmision.getPlataforma(),
                    String.valueOf(transmision.getEspectadores()),
                    presentador != null ? presentador.getNombre() : "",
                    presentador != null ? String.valueOf(presentador.getEdad()) : "",
                    presentador != null ? presentador.getPersonajeInterpretado() : ""
            );
        }

        return "";
    }

    // Obtiene un dato del arreglo de forma segura
    private String obtenerDato(String[] datos, int posicion) {
        if (posicion < datos.length) {
            return datos[posicion].trim();
        }

        return "";
    }

    // Convierte texto a número entero
    private int convertirEntero(String valor) {
        return Integer.parseInt(valor.trim());
    }

    // Une varios datos en una sola línea CSV
    private String unirDatos(String... datos) {
        StringBuilder linea = new StringBuilder();

        for (int i = 0; i < datos.length; i++) {
            linea.append(limpiarDato(datos[i]));

            if (i < datos.length - 1) {
                linea.append(",");
            }
        }

        return linea.toString();
    }

    // Limpia comas para no dañar el formato del archivo CSV
    private String limpiarDato(String dato) {
        if (dato == null) {
            return "";
        }

        return dato.replace(",", " ");
    }
}