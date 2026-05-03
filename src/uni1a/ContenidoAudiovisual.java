package uni1a;

public abstract class ContenidoAudiovisual {//Aquí se declara una clase
    private static int contar = 0; //static significa que pertenece a la clase en general, no a un objeto específico.
    private String titulo; //private significa que esos datos no se pueden modificar directamente desde otra clase.
    private int duracionEnMinutos;
    private String genero;
    private int id;

    public ContenidoAudiovisual(String titulo, int duracionEnMinutos, String genero) {
        this.id = contar++; //asigna un ID automático, significa que después de usar el valor actual, aumenta en 1.
        this.titulo = titulo; //this significa “este objeto
        this.duracionEnMinutos = duracionEnMinutos;
        this.genero = genero;
    }

    // Getter y Setter para el campo 'titulo'
    public String getTitulo() { //getter para obtener o leer un valor privado
        return titulo;
    }

    public void setTitulo(String titulo) { //setter para modificar un valor privado
        this.titulo = titulo;
    }

    // Getter y Setter para el campo 'duracionEnMinutos'
    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    // Getter y Setter para el campo 'genero'
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    // Getter para el campo 'id' (no se proporciona el Setter ya que 'id' se asigna en el constructor y parece ser inmutable)
    public int getId() {
        return id;
    }
    
    public abstract void mostrarDetalles();
}