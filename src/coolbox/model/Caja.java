package coolbox.model;

public class Caja {
    private int id;
    private float monto;

    public Caja(int id, float monto) {
        this.id = id;
        this.monto = monto;
    }

    public Caja() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
    
}
