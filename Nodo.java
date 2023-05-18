
package pilas;

public class Nodo {
    
    //Atributos
    private long cedula;
    private String carrera, nombre, apellido;
    private Nodo Liga;
    Pila Materias;

    public Nodo() {
        this.cedula = cedula;
        this.carrera = carrera;
        this.nombre = nombre;
        this.apellido = apellido;
        this.Materias= new Pila(4);
        this.Liga = null;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Nodo getLiga() {
        return Liga;
    }

    public void setLiga(Nodo Liga) {
        this.Liga = Liga;
    }

    public Pila getMaterias() {
        return Materias;
    }

    public void setMaterias(Pila Materias) {
        this.Materias = Materias;
    }
  
    
    
}





