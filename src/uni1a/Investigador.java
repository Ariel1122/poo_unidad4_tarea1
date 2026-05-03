package uni1a;// clase Investigador

// representa a una persona experta que participa o aporta información en un documental
public class Investigador {

    private String nombre;// Atributo que guarda el nombre del investigador

    private String especialidad;// Atributo que guarda la especialidad del autor

    private String institucion;// Atributo que guarda la intitucion del investigador

    // Constructor de la clase Investigador.
    public Investigador(String nombre, String especialidad, String institucion) { //permite crear un investigador con nombre, especialidad e institucion
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.institucion = institucion;
    }

    public String getNombre() {  //getter para obtener el nombre del investigador
        return nombre;
    }

    public void setNombre(String nombre) { // Setter para modificar el nombre
        this.nombre = nombre;
    }

    public String getEspecialidad() {  //getter para obtener la especialidad del actor
        return especialidad;
    }

    public void setEspecialidad(String especialidad) { // Setter para modificar  la especialidad
        this.especialidad = especialidad;
    }

    public String getInstitucion() {  //getter para obtener la institucion del investigador
        return institucion;
    }

    public void setInstitucion(String institucion) { // Setter para modificar el instituto
        this.institucion = institucion;
    }


    public void mostrarInformacion() { // metodo que muestra la información del investigador en consola.
        System.out.println("Investigador: " + nombre);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Institución: " + institucion);
    }
}