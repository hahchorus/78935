package mx.uv.t4is.SaludosBd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//DTO
@Entity
public class Saludos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private String nombre;
    private int id;

    public Saludos(){
    }

    public Saludos(int id, String nombre){
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
