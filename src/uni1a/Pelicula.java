/**
 * Class Pelicula
 */
package uni1a;

// Subclase Pelicula que extiende de ContenidoAudiovisual
public class Pelicula extends ContenidoAudiovisual { //extends, Significa que Pelicula hereda de ContenidoAudiovisual
    private String estudio; //atributo solo pertenece a Pelicula
    private Actor actorPrincipal; // Relación con la clase Actor


    public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio, Actor actorPrincipal) { //Este constructor recibe 4 datos
        super(titulo, duracionEnMinutos, genero); //suoer llama al constructor de la clase padre
        this.estudio = estudio; //guarda el dato propio de Pelicula
        this.actorPrincipal = actorPrincipal; // guarda el dato de actor
    }

    public String getEstudio() { //getter para obtener el estudio de la película
        return estudio;
    }

    public void setEstudio(String estudio) { // setter para modificar el estudio de la película
        this.estudio = estudio;
    }
    
    public Actor getActorPrincipal() { //getter para obtener el actor principal
        return actorPrincipal;
    }
    
    public void setActorPrincipal(Actor actorPrincipal) { //setter para modificar el actor principal
        this.actorPrincipal = actorPrincipal;
    }
    
    
    @Override //este método está sobrescribiendo un método de la clase padre
    public void mostrarDetalles() { //Dentro del método se imprimen los datos
        System.out.println("Detalles de la película:");
        System.out.println("ID: " + getId()); // encapsulamiento_Pelicule no accede directamente a id
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Estudio: " + estudio);
        
        if (actorPrincipal != null) { //si la película tiene un actor principal asignado
            System.out.println("Información del actor principal:");
            actorPrincipal.mostrarInformacion();
        }
        
        System.out.println();
    }
}


//relacion de asición entre actor y pelicula, porque el actor existe por separado de la peli