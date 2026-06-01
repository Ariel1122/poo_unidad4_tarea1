package uni1a;

public class Actor {//clase que representa a un actor o presentador

    private String nombre; //nombre del actor
    private int edad; //edad del actor
    private String personajeInterpretado; //personaje o rol que interpreta

    //constructor de la clase Actor
    public Actor(String nombre, int edad, String personajeInterpretado) {
        this.nombre = nombre;
        this.edad = edad;
        this.personajeInterpretado = personajeInterpretado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPersonajeInterpretado() {
        return personajeInterpretado;
    }

    public void setPersonajeInterpretado(String personajeInterpretado) {
        this.personajeInterpretado = personajeInterpretado;
    }

  
    public String obtenerInformacion() {//devuelve la informacipn del actor como texto
        return "Actor: " + nombre + "\n"
                + "Edad: " + edad + "\n"
                + "Personaje interpretado: " + personajeInterpretado + "\n";
    }
}