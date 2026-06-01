package uni1a;


public class Investigador {//clase que representa a un investigador relacionado con un documental o podcast

    private String nombre; //nombre del investigador
    private String especialidad; //area de conocimiento del investigador
    private String institucion; //institucion a la que pertenece

 
    public Investigador(String nombre, String especialidad, String institucion) {//constructor de la clase Investigador
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.institucion = institucion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    
    public String obtenerInformacion() {//devuelve la informacion del investigador como texto
        return "Investigador: " + nombre + "\n"
                + "Especialidad: " + especialidad + "\n"
                + "Institución: " + institucion + "\n";
    }
}