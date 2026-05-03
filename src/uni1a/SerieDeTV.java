/**
 * Class SerieDeTV
 */
package uni1a;

// Subclase SerieDeTV que extiende de ContenidoAudiovisual
public class SerieDeTV extends ContenidoAudiovisual {
    private int temporadas;
    private Temporada temporadaPrincipal; //conecta SerieDeTV con clase Temporada

    
    public SerieDeTV(String titulo, int duracionEnMinutos, String genero, int temporadas,  int numeroTemporada, int cantidadEpisodios, int anioEstreno) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = temporadas;
        this.temporadaPrincipal = new Temporada(numeroTemporada, cantidadEpisodios, anioEstreno);
    }

    public int getTemporadas() {//getter para obtener el dato
        return temporadas;
    }

    public void setTemporadas(int temporadas) {//setter para modificar 
        this.temporadas = temporadas;
    }
    
    public Temporada getTemporadaPrincipal() {//getter para obtener el dato
        return temporadaPrincipal;
    }
    
    public void setTemporadaPrincipal(Temporada temporadaPrincipal) {//setter para modificar 
        this.temporadaPrincipal = temporadaPrincipal;
    }
    
    @Override //este método está sobrescribiendo un método de la clase padre
    public void mostrarDetalles() { //Dentro del método se imprimen los datos
        System.out.println("Detalles de la serie de tv:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Temporadas: " + this.temporadas);
        
        if (temporadaPrincipal != null) {  //si la serie tiene una temporada principal
            System.out.println("Información de la temporada principal:");
            temporadaPrincipal.mostrarInformacion();
        }
        
        System.out.println();
    }
}


//relación de composicion porque una clase esta conformada por otra