package uni1a;


public class Temporada {//clase que representa una temporada de televisión

    private int numeroTemporada; //numero de temporada
    private int cantidadEpisodios; //cantidad de episodios
    private int anioEstreno; // Año de estreno de la temporada

    //constructor de la clase Temporada
    public Temporada(int numeroTemporada, int cantidadEpisodios, int anioEstreno) {
        this.numeroTemporada = numeroTemporada;
        this.cantidadEpisodios = cantidadEpisodios;
        this.anioEstreno = anioEstreno;
    }

    public int getNumeroTemporada() {
        return numeroTemporada;
    }

    public void setNumeroTemporada(int numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    public int getCantidadEpisodios() {
        return cantidadEpisodios;
    }

    public void setCantidadEpisodios(int cantidadEpisodios) {
        this.cantidadEpisodios = cantidadEpisodios;
    }

    public int getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(int anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

  
    public String obtenerInformacion() { //devuelve la informacion de la temporada
        return "Temporada número: " + numeroTemporada + "\n"
                + "Cantidad de episodios: " + cantidadEpisodios + "\n"
                + "Año de estreno: " + anioEstreno + "\n";
    }
}