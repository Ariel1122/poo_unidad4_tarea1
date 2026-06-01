package uni1a;

//subclase Documental que hereda de ContenidoAudiovisual
public class Documental extends ContenidoAudiovisual {

    private String tema; //eema principal 
    private Investigador investigador; //relación con la clase Investigador

  
    public Documental(String titulo, int duracionEnMinutos, String genero, String tema, Investigador investigador) {
        super(titulo, duracionEnMinutos, genero);
        this.tema = tema;
        this.investigador = investigador;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Investigador getInvestigador() {
        return investigador;
    }

    public void setInvestigador(Investigador investigador) {
        this.investigador = investigador;
    }

  
    @Override //devuelve los detalles
    public String obtenerDetalles() {
        String detalles = "Detalles del documental:\n"
                + obtenerDatosBasicos()
                + "Tema: " + tema + "\n";

        if (investigador != null) {
            detalles += "Información del investigador:\n"
                    + investigador.obtenerInformacion();
        }

        return detalles;
    }
}