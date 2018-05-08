package hernandez.perez.uca.com.taximetrodos.entity;

import java.io.Serializable;

/**
 * Created by LENOVO on 7/5/2018.
 */

public class Resume implements Serializable {
    private String nombre;
    private String estado;
    private String apellidos;
    private String experien_lab;
    private String causa;
    private int telefono;
    private String correo;
    private String estado_civil;
    private int id;
    private  int id_carro;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getExperien_lab() {
        return experien_lab;
    }

    public void setExperien_lab(String experien_lab) {
        this.experien_lab = experien_lab;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_carro() {
        return id_carro;
    }

    public void setId_carro(int id_carro) {
        this.id_carro = id_carro;
    }
}
