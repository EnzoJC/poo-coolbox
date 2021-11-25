package coolbox.model;

public class Operacion {
    private int id;
    private String nombre;

    public Operacion(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Operacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
