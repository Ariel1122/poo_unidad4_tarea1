package uni1a;

//subclase SerieDeTV que hereda de ContenidoAudiovisual
public class SerieDeTV extends ContenidoAudiovisual {

    private int temporadas; //numero de temporadas
    private Temporada temporadaPrincipal; //relacion de composición con temporada

    //constructor de la clase
    public SerieDeTV(String titulo, int duracionEnMinutos, String genero, int temporadas,
                     int numeroTemporada, int cantidadEpisodios, int anioEstreno) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = temporadas;
        this.temporadaPrincipal = new Temporada(numeroTemporada, cantidadEpisodios, anioEstreno);
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public Temporada getTemporadaPrincipal() {
        return temporadaPrincipal;
    }

    public void setTemporadaPrincipal(Temporada temporadaPrincipal) {
        this.temporadaPrincipal = temporadaPrincipal;
    }

        @Override  //devuelve los detalles de la serie 
    public String obtenerDetalles() {
        String detalles = "Detalles de la serie de tv:\n"
                + obtenerDatosBasicos()
                + "Temporadas: " + temporadas + "\n";

        if (temporadaPrincipal != null) {
            detalles += "Información de la temporada principal:\n"
                    + temporadaPrincipal.obtenerInformacion();
        }

        return detalles;
    }
}