package uni1a;


public class Pelicula extends ContenidoAudiovisual {//subclase Pelicula que hereda ContenidoAudiovisual

    private String estudio; // estudio que produjo la pelicula
    private Actor actorPrincipal; //relacion con la clase Actor

    // constructor de la clase
    public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio, Actor actorPrincipal) {
        super(titulo, duracionEnMinutos, genero);
        this.estudio = estudio;
        this.actorPrincipal = actorPrincipal;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public Actor getActorPrincipal() {
        return actorPrincipal;
    }

    public void setActorPrincipal(Actor actorPrincipal) {
        this.actorPrincipal = actorPrincipal;
    }

    
    @Override //devuelve los detalles de la pelocula 
    public String obtenerDetalles() {
        String detalles = "Detalles de la película:\n"
                + obtenerDatosBasicos()
                + "Estudio: " + estudio + "\n";

        if (actorPrincipal != null) {
            detalles += "Información del actor principal:\n"
                    + actorPrincipal.obtenerInformacion();
        }

        return detalles;
    }
}