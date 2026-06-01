package uni1a;

//subclase Podcast que hereda de ContenidoAudiovisual
public class Podcast extends ContenidoAudiovisual {

    private String plataforma; //plataforma donde se publica el podcast
    private int numeroEpisodio; //numero del episodio
    private Investigador investigadorInvitado; //relación con Investigador

    //constructor
    public Podcast(String titulo, int duracionEnMinutos, String genero, String plataforma,
                   int numeroEpisodio, Investigador investigadorInvitado) {
        super(titulo, duracionEnMinutos, genero);
        this.plataforma = plataforma;
        this.numeroEpisodio = numeroEpisodio;
        this.investigadorInvitado = investigadorInvitado;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(int numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public Investigador getInvestigadorInvitado() {
        return investigadorInvitado;
    }

    public void setInvestigadorInvitado(Investigador investigadorInvitado) {
        this.investigadorInvitado = investigadorInvitado;
    }

    
    
    @Override // Devuelve los detalles
    public String obtenerDetalles() {
        String detalles = "Detalles del podcast:\n"
                + obtenerDatosBasicos()
                + "Plataforma: " + plataforma + "\n"
                + "Número de episodio: " + numeroEpisodio + "\n";

        if (investigadorInvitado != null) {
            detalles += "Información del investigador invitado:\n"
                    + investigadorInvitado.obtenerInformacion();
        }

        return detalles;
    }
}