/**
 * Class Documental
 */
package uni1a;

// Subclase Documental que extiende de ContenidoAudiovisual
public class Documental extends ContenidoAudiovisual {
    private String tema;
    private Investigador investigador;

    public Documental(String titulo, int duracionEnMinutos, String genero, String tema, Investigador investigador) { ////Este constructor recibe 4 datos
        super(titulo, duracionEnMinutos, genero); ///suoer llama al constructor de la clase padre
        this.tema = tema; // atributo es propio_guarda el dato propio del documental
        this.investigador = investigador; //agregacion_clase documental recibe un investigador que ya existe
    }

   
    public String getTema() { //getter para obtener el tema
        return tema;
    }
    

    public void setTema(String tema) {  // setter para modificar el tema
        this.tema = tema;
    }
    
   
    public Investigador getInvestigador() { //getter para obtener el investigador
        return investigador;
    }
    
    public void setInvestigador(Investigador investigador) {  // setter para modificar al investigador
        this.investigador = investigador;
    }
    
    @Override //este método está sobrescribiendo un método de la clase padre
    public void mostrarDetalles() {  //Dentro del método se imprimen los datos
        System.out.println("Detalles de la película:");
        System.out.println("ID: " + getId()); // encapsulamiento_documental no accede directamente a id
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Tema: " + this.tema);
        
        if (investigador != null) { // si existe un investigador asignado, se muestra su informacion
            System.out.println("Información del investigador:");
            investigador.mostrarInformacion();
        }
        
        System.out.println();
    }
}

//relacion de agregacion donde una clase usa o contiene a otra, pero esa otra clase puede existir sola