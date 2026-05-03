package uni1a; //clase Actor pertenece al paquete uni1a

public class Actor { //definición de la clase Actor-clase puede ser usada desde otras clases del proyecto

    private String nombre;// atributo, guarda el actor

    
    private int edad;// Atributo que guarda la edad del actor

  
    private String personajeInterpretado; // Atributo que guarda el nombre del personaje que interpreta en la película-DATO TEXTO

    //PRIVATE: dato está protegido y no se puede modificar directamente desde otra clase
    public Actor(String nombre, int edad, String personajeInterpretado) { // constructor de la clase Actor-objeto actor con nombre, edad y personaje
        this.nombre = nombre; //guarda el nombre recibido en el atributo del objeto-el nombre de este actor será igual al nombre que me enviaron
        this.edad = edad; //guarda la edad recibida en el atributo edad
        this.personajeInterpretado = personajeInterpretado; //guarda el personaje recibido en el atributo personajeInterpretado
    }

   
    public String getNombre() { //getter para obtener la edad del actor
        return nombre;
    }

    public void setNombre(String nombre) { //set para modificar el nombre del actor
        this.nombre = nombre;
    }

   
    public int getEdad() {//get para obtener la edad del actor
        return edad;
    }

  
    public void setEdad(int edad) {//set para modificar la edad del actor
        this.edad = edad;
    }

    
    public String getPersonajeInterpretado() {// get para obtener el personaje interpretado por el actor
        return personajeInterpretado;
    }

    
    public void setPersonajeInterpretado(String personajeInterpretado) { //set para modificar el personaje interpretado por el actor
        this.personajeInterpretado = personajeInterpretado;
    }

    
    public void mostrarInformacion() { // metodo que muestra en consola la información del actor
        System.out.println("Actor: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Personaje interpretado: " + personajeInterpretado);
    }
}