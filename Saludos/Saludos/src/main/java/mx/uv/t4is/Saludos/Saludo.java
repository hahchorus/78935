package mx.uv.t4is.Saludos;

public class Saludo {

    private String nombre;
    private int id;

    public Saludo(){
    }

    public Saludo(int id, String nombre){
        this.id=id;
        this.nombre=nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'"+
            ", nombre='" + getNombre() + "'"+
            "}";
    }
    
}
