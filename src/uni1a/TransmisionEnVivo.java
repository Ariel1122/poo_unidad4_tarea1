package uni1a;

// Subclase TransmisionEnVivo que hereda de ContenidoAudiovisual
public class TransmisionEnVivo extends ContenidoAudiovisual {

    private String plataforma; //plataforma de transmisipn
    private int espectadores; //numero de espectadores
    private Actor presentador; //relacion con la clase Actor

 
    public TransmisionEnVivo(String titulo, int duracionEnMinutos, String genero, String plataforma,
                             int espectadores, Actor presentador) {
        super(titulo, duracionEnMinutos, genero);
        this.plataforma = plataforma;
        this.espectadores = espectadores;
        this.presentador = presentador;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getEspectadores() {
        return espectadores;
    }

    public void setEspectadores(int espectadores) {
        this.espectadores = espectadores;
    }

    public Actor getPresentador() {
        return presentador;
    }

    public void setPresentador(Actor presentador) {
        this.presentador = presentador;
    }

    
    
    
    @Override //devuelve los detalles de la transmision
    public String obtenerDetalles() {
        String detalles = "Detalles de la transmisión en vivo:\n"
                + obtenerDatosBasicos()
                + "Plataforma: " + plataforma + "\n"
                + "Espectadores: " + espectadores + "\n";

        if (presentador != null) {
            detalles += "Información del presentador:\n"
                    + presentador.obtenerInformacion();
        }

        return detalles;
    }
}