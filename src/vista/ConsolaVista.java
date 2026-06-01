package vista;

import java.util.List;
import java.util.Scanner;

import uni1a.Actor;
import uni1a.ContenidoAudiovisual;
import uni1a.Documental;
import uni1a.Investigador;
import uni1a.Pelicula;
import uni1a.Podcast;
import uni1a.SerieDeTV;
import uni1a.TransmisionEnVivo;

// Clase encargada de la interacción con el usuario por consola
public class ConsolaVista {

    private Scanner scanner; // Permite leer datos ingresados por el usuario

    // Constructor de la vista
    public ConsolaVista() {
        scanner = new Scanner(System.in);
    }

    // Muestra el menú principal del sistema
    public void mostrarMenu() {
        System.out.println("====================================");
        System.out.println(" SISTEMA DE CONTENIDOS AUDIOVISUALES");
        System.out.println("====================================");
        System.out.println("1. Cargar contenidos desde archivo");
        System.out.println("2. Mostrar contenidos");
        System.out.println("3. Agregar película");
        System.out.println("4. Agregar serie de TV");
        System.out.println("5. Agregar documental");
        System.out.println("6. Agregar podcast");
        System.out.println("7. Agregar transmisión en vivo");
        System.out.println("8. Guardar contenidos en archivo");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Lee la opción seleccionada por el usuario
    public int leerOpcion() {
        return leerEntero("");
    }

    // Muestra un mensaje normal en consola
    public void mostrarMensaje(String mensaje) {
        System.out.println("\n" + mensaje + "\n");
    }

    // Muestra un mensaje de error en consola
    public void mostrarError(String mensaje) {
        System.out.println("\nError: " + mensaje + "\n");
    }

    // Muestra la lista de contenidos audiovisuales
    public void mostrarContenidos(List<ContenidoAudiovisual> contenidos) {
        if (contenidos == null || contenidos.isEmpty()) {
            mostrarMensaje("No hay contenidos registrados.");
            return;
        }

        System.out.println("\n===== LISTA DE CONTENIDOS =====\n");

        for (ContenidoAudiovisual contenido : contenidos) {
            System.out.println(contenido.obtenerDetalles());
            System.out.println("--------------------------------");
        }
    }

    // Pide los datos necesarios para crear una película
    public Pelicula pedirDatosPelicula() {
        System.out.println("\n===== AGREGAR PELÍCULA =====");

        String titulo = leerTexto("Título: ");
        int duracion = leerEntero("Duración en minutos: ");
        String genero = leerTexto("Género: ");
        String estudio = leerTexto("Estudio: ");

        Actor actor = pedirDatosActor("actor principal");

        return new Pelicula(titulo, duracion, genero, estudio, actor);
    }

    // Pide los datos necesarios para crear una serie de TV
    public SerieDeTV pedirDatosSerie() {
        System.out.println("\n===== AGREGAR SERIE DE TV =====");

        String titulo = leerTexto("Título: ");
        int duracion = leerEntero("Duración en minutos: ");
        String genero = leerTexto("Género: ");
        int temporadas = leerEntero("Cantidad total de temporadas: ");
        int numeroTemporada = leerEntero("Número de temporada principal: ");
        int cantidadEpisodios = leerEntero("Cantidad de episodios: ");
        int anioEstreno = leerEntero("Año de estreno: ");

        return new SerieDeTV(titulo, duracion, genero, temporadas, numeroTemporada, cantidadEpisodios, anioEstreno);
    }

    // Pide los datos necesarios para crear un documental
    public Documental pedirDatosDocumental() {
        System.out.println("\n===== AGREGAR DOCUMENTAL =====");

        String titulo = leerTexto("Título: ");
        int duracion = leerEntero("Duración en minutos: ");
        String genero = leerTexto("Género: ");
        String tema = leerTexto("Tema: ");

        Investigador investigador = pedirDatosInvestigador("investigador del documental");

        return new Documental(titulo, duracion, genero, tema, investigador);
    }

    // Pide los datos necesarios para crear un podcast
    public Podcast pedirDatosPodcast() {
        System.out.println("\n===== AGREGAR PODCAST =====");

        String titulo = leerTexto("Título: ");
        int duracion = leerEntero("Duración en minutos: ");
        String genero = leerTexto("Género: ");
        String plataforma = leerTexto("Plataforma: ");
        int numeroEpisodio = leerEntero("Número de episodio: ");

        Investigador investigador = pedirDatosInvestigador("investigador invitado");

        return new Podcast(titulo, duracion, genero, plataforma, numeroEpisodio, investigador);
    }

    // Pide los datos necesarios para crear una transmisión en vivo
    public TransmisionEnVivo pedirDatosTransmision() {
        System.out.println("\n===== AGREGAR TRANSMISIÓN EN VIVO =====");

        String titulo = leerTexto("Título: ");
        int duracion = leerEntero("Duración en minutos: ");
        String genero = leerTexto("Género: ");
        String plataforma = leerTexto("Plataforma: ");
        int espectadores = leerEntero("Número de espectadores: ");

        Actor presentador = pedirDatosActor("presentador");

        return new TransmisionEnVivo(titulo, duracion, genero, plataforma, espectadores, presentador);
    }

    // Pide los datos de un actor o presentador
    private Actor pedirDatosActor(String tipoActor) {
        System.out.println("\nDatos del " + tipoActor + ":");

        String nombre = leerTexto("Nombre: ");
        int edad = leerEntero("Edad: ");
        String personaje = leerTexto("Personaje o rol: ");

        return new Actor(nombre, edad, personaje);
    }

    // Pide los datos de un investigador
    private Investigador pedirDatosInvestigador(String tipoInvestigador) {
        System.out.println("\nDatos del " + tipoInvestigador + ":");

        String nombre = leerTexto("Nombre: ");
        String especialidad = leerTexto("Especialidad: ");
        String institucion = leerTexto("Institución: ");

        return new Investigador(nombre, especialidad, institucion);
    }

    // Lee texto ingresado por el usuario
    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    // Lee números enteros y controla errores si el usuario escribe texto
    private int leerEntero(String mensaje) {
        while (true) {
            try {
                if (!mensaje.isEmpty()) {
                    System.out.print(mensaje);
                }

                String entrada = scanner.nextLine();
                return Integer.parseInt(entrada);

            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }
}