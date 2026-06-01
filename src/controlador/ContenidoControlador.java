package controlador;

import java.io.IOException;

import repositorio.ArchivoContenidoRepositorio;
import repositorio.ContenidoRepositorio;
import servicio.ContenidoServicio;
import vista.ConsolaVista;

// Clase que conecta la vista con el servicio
public class ContenidoControlador {

    private ConsolaVista vista; // Vista encargada de mostrar y pedir datos
    private ContenidoServicio servicio; // Servicio encargado de la lógica del sistema

    // Constructor del controlador
    public ContenidoControlador() {
        ContenidoRepositorio repositorio = new ArchivoContenidoRepositorio("data/contenidos.csv");
        servicio = new ContenidoServicio(repositorio);
        vista = new ConsolaVista();
    }

    // Método principal que mantiene el menú activo
    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            vista.mostrarMenu();
            int opcion = vista.leerOpcion();

            switch (opcion) {
                case 1:
                    cargarContenidos();
                    break;

                case 2:
                    vista.mostrarContenidos(servicio.obtenerContenidos());
                    break;

                case 3:
                    servicio.agregarContenido(vista.pedirDatosPelicula());
                    vista.mostrarMensaje("Película agregada correctamente.");
                    break;

                case 4:
                    servicio.agregarContenido(vista.pedirDatosSerie());
                    vista.mostrarMensaje("Serie de TV agregada correctamente.");
                    break;

                case 5:
                    servicio.agregarContenido(vista.pedirDatosDocumental());
                    vista.mostrarMensaje("Documental agregado correctamente.");
                    break;

                case 6:
                    servicio.agregarContenido(vista.pedirDatosPodcast());
                    vista.mostrarMensaje("Podcast agregado correctamente.");
                    break;

                case 7:
                    servicio.agregarContenido(vista.pedirDatosTransmision());
                    vista.mostrarMensaje("Transmisión en vivo agregada correctamente.");
                    break;

                case 8:
                    guardarContenidos();
                    break;

                case 0:
                    vista.mostrarMensaje("Programa finalizado.");
                    salir = true;
                    break;

                default:
                    vista.mostrarError("Opción no válida.");
                    break;
            }
        }
    }

    // Carga contenidos desde el archivo CSV
    private void cargarContenidos() {
        try {
            servicio.cargarContenidos();
            vista.mostrarMensaje("Contenidos cargados correctamente desde el archivo.");
        } catch (IOException e) {
            vista.mostrarError("No se pudieron cargar los contenidos.");
        }
    }

    // Guarda contenidos en el archivo CSV
    private void guardarContenidos() {
        try {
            servicio.guardarContenidos();
            vista.mostrarMensaje("Contenidos guardados correctamente en el archivo.");
        } catch (IOException e) {
            vista.mostrarError("No se pudieron guardar los contenidos.");
        }
    }
}