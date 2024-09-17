package utp.crud.crudAlumno.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    //construir la clase usuario los campos son usuario y contraseña
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer idusuario;

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;

    @Column(name = "clave", nullable = false)
    private String clave;

    //constructor
    public Usuario(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
    }

    // Constructor sin argumentos
    public Usuario() {
    }

    //getters y setters


    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
