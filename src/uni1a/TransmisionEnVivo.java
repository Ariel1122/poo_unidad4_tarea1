package uni1a;

public class TransmisionEnVivo extends ContenidoAudiovisual {
    private String plataforma;
    private int espectadores; //atributo pertenece a podcasr
    private Actor presentador; //relacion con la clase acotr


    public TransmisionEnVivo(String titulo, int duracionEnMinutos, String genero, String plataforma, int espectadores, Actor presentador) { //Este constructor recibe 4 datos
        super(titulo, duracionEnMinutos, genero);//suoer llama al constructor de la clase padre
        // Guarda los datos propios de la transmisión en vivo.
        this.plataforma = plataforma; //guarda el dato de la plataforma
        this.espectadores = espectadores; //guarda el dato de espetador
        this.presentador = presentador; //guarda el dato del presentador
    }

    public String getPlataforma() {  //getter para obtener nombre de la plataforma
        return plataforma;
    }

    public void setPlataforma(String plataforma) { // setter para modificar la plataforma
        this.plataforma = plataforma;
    }

    public int getEspectadores() {  //getter para obtener el numero de espectadores
        return espectadores;
    }


    public void setEspectadores(int espectadores) { // setter para modificar el numero de espetadores
        this.espectadores = espectadores;
    }

    public Actor getPresentador() {  //getter para obtener al presentador
        return presentador;
    }

    public void setPresentador(Actor presentador) { // setter para modificar al presentador
        this.presentador = presentador;
    }

    
    @Override //este método está sobrescribiendo un método de la clase padre
    public void mostrarDetalles() { //Dentro del método se imprimen los datos
        System.out.println("Detalles de la transmisión en vivo:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Plataforma: " + plataforma);
        System.out.println("Espectadores: " + espectadores);

        if (presentador != null) {
            System.out.println("Información del presentador:");
            presentador.mostrarInformacion();
        }

        System.out.println();
    }
}

//relacion de asición entre el presentador y la tranmision, porque el presentador existe por separado de la peli