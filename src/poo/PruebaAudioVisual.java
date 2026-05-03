package poo;
import uni1a.*;

public class PruebaAudioVisual { 
	public static void main(String[] args) { //punto de inicio del programa
        System.out.println("Sistema de Contenidos Audiovisuales");//primer mensaje del programa

        Actor actorAvatar = new Actor("Sam Worthington", 47, "Jake Sully"); //crear un objeto de la clase actor
        Investigador investigadorCosmos = new Investigador("Carl Sagan", "Astronomía", "NASA");
        Investigador investigadorPodcast = new Investigador("Jane Goodall", "Primatología", "Instituto Jane Goodall");
        Actor presentadorLive = new Actor("Ana Torres", 25, "Presentadora principal");
        
        // Crear instancias de las subclases
        ContenidoAudiovisual[] contenidos = new ContenidoAudiovisual[5];//se crea el arreglo contenidos, que guarda varios datos del mismo tipo, en este caso guarda 5 datos
        contenidos[0] = new Pelicula("Avatar", 125, "Accion", "20th Century Studios", actorAvatar); //aqui se crea el objeto para la clase pelicula, objeto que tiene datos, el cual se guarda en la posicion 0
        // aqui agregamos actor avatar, porque le digimos al contructor que ahora son 5 datos en la clase peli
        contenidos[1] = new SerieDeTV("Game of Thrones", 60, "Fantasy", 8, 1, 10, 2011); //aqui se crea un objeto de la clase seriedeTV
        contenidos[2] = new Documental("Cosmos", 45, "Science", "Astronomy", investigadorCosmos); //aqui se crea un objeto de la clase Documental
        contenidos[3] = new Podcast("Ciencia para Todos", 40, "Educativo", "Spotify", 12, investigadorPodcast);
        contenidos[4] = new TransmisionEnVivo("Entrevista Especial", 90, "Entrevista", "Twitch", 2500, presentadorLive);
        
        // Mostrar los detalles de cada contenido audiovisual
        for (ContenidoAudiovisual contenido : contenidos) { //Por cada contenido audiovisual dentro del arreglo contenidos, muestra sus detalles.
            contenido.mostrarDetalles();
        }
    }
}