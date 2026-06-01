package uni1a;


public abstract class ContenidoAudiovisual {//clase padre abstracta para todos los tipos de contenido
    private static int contar = 0; //permite generar un ID automatico
    private int id; //identificador unico del contenido
    private String titulo; //titulo del contenido
    private int duracionEnMinutos; //duracion del contenido
    private String genero; //genero del contenido

   
    public ContenidoAudiovisual(String titulo, int duracionEnMinutos, String genero) { //vonstructor de la clase padre
        this.id = contar++;
        this.titulo = titulo;
        this.duracionEnMinutos = duracionEnMinutos;
        this.genero = genero;
    }

    public int getId() {// Getter para obtener el ID
        return id;
    }

    public String getTitulo() {// Getter para obtener el titulo
        return titulo;
    }

    public void setTitulo(String titulo) {// Setter para modificar el titulo
        this.titulo = titulo;
    }

    public int getDuracionEnMinutos() {// Getter para obtener la duración
        return duracionEnMinutos;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {// Setter para modificar la duración
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public String getGenero() {// Getter para obtener el genero
        return genero;
    }

    public void setGenero(String genero) {// Setter para modificar el genero
        this.genero = genero;
    }

    
    protected String obtenerDatosBasicos() {//metodo común para obtener la informacion general del contenido
        return "ID: " + getId() + "\n"
                + "Título: " + getTitulo() + "\n"
                + "Duración en minutos: " + getDuracionEnMinutos() + "\n"
                + "Género: " + getGenero() + "\n";
    }

 
    public abstract String obtenerDetalles(); // metodo abstracto que cada subclase debe implementar
}