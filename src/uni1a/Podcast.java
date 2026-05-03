package uni1a;


public class Podcast extends ContenidoAudiovisual {
    private String plataforma; //plataforma donde se publica el podcast, por ejemplo Spotify
    private int numeroEpisodio;
    private Investigador investigadorInvitado;

    public Podcast(String titulo, int duracionEnMinutos, String genero, String plataforma, int numeroEpisodio, Investigador investigadorInvitado) {
        super(titulo, duracionEnMinutos, genero); //suoer llama al constructor de la clase padre
        this.plataforma = plataforma; //guarda la plataforma del podcast
        this.numeroEpisodio = numeroEpisodio;//guarda el numero del episodio del podxast
        this.investigadorInvitado = investigadorInvitado; // guarda el dato del invitado
    }

    public String getPlataforma() { //getter para obtener la plataforma del podcast
        return plataforma;
    }

    public void setPlataforma(String plataforma) { // setter para modificar la plataforma del podcast
        this.plataforma = plataforma;
    }

    public int getNumeroEpisodio() { //getter para obtener el numero del episodio
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(int numeroEpisodio) { // setter para modificar el numero del episodio
        this.numeroEpisodio = numeroEpisodio;
    }

    public Investigador getInvestigadorInvitado() { //getter para obtener al investifador invitado al podcast
        return investigadorInvitado;
    }

    public void setInvestigadorInvitado(Investigador investigadorInvitado) { // setter para modificar al investigador modificado del podcast
        this.investigadorInvitado = investigadorInvitado;
    }


    @Override //este método está sobrescribiendo un método de la clase padre
    public void mostrarDetalles() { //Dentro del método se imprimen los datos
        System.out.println("Detalles del podcast:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Plataforma: " + plataforma);
        System.out.println("Número de episodio: " + numeroEpisodio);


        if (investigadorInvitado != null) {
            System.out.println("Información del investigador invitado:");
            investigadorInvitado.mostrarInformacion();
        }

        System.out.println();
    }
}   


//relacion de asición entre el investigador invitado y el podcast, porque el actor investifador puede existir separado del podcast 