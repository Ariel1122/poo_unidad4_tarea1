package uni1a;//clase Actor pertenece al paquete uni1a

public class Temporada {//una temporada perteneciente a una serie de television

    private int numeroTemporada; // atributo, guarda el numero de la temporada

    private int cantidadEpisodios;// atributo, guarda la cntidad de episodios en temporadas

    private int anioEstreno;// atributo, guarda el año de estreno

  //PRIVATE: dato está protegido y no se puede modificar directamente desde otra clase
    public Temporada(int numeroTemporada, int cantidadEpisodios, int anioEstreno) {// constructor de la clase temporar
        this.numeroTemporada = numeroTemporada;//guarda el numero de temporada recibido en el atributo del numeroTemporada
        this.cantidadEpisodios = cantidadEpisodios;//guarda el numero de temporada recibido en el atributo del numeroTemporada
        this.anioEstreno = anioEstreno; //guarda el año de estreno recibido en el atributo anioEstreno
    }

    public int getNumeroTemporada() {//get para obtener el numero de tempora
        return numeroTemporada;
    }


    public void setNumeroTemporada(int numeroTemporada) {//set para modificar la tempora
        this.numeroTemporada = numeroTemporada;
    }

    public int getCantidadEpisodios() {//get para obtener la cantidad de episodio
        return cantidadEpisodios;
    }

    public void setCantidadEpisodios(int cantidadEpisodios) {//set para modificar la cantidad de episodios
        this.cantidadEpisodios = cantidadEpisodios;
    }

    public int getAnioEstreno() {//get para obtener el año de estreño
        return anioEstreno;
    }

    public void setAnioEstreno(int anioEstreno) {//set para modificar el año de estreno
        this.anioEstreno = anioEstreno;
    }


    public void mostrarInformacion() {// metodo que muestra en consola la información de la temporada
        System.out.println("Temporada número: " + numeroTemporada);
        System.out.println("Cantidad de episodios: " + cantidadEpisodios);
        System.out.println("Año de estreno: " + anioEstreno);
    }
}