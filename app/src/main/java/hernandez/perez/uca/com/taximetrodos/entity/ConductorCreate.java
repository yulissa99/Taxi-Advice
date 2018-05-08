package hernandez.perez.uca.com.taximetrodos.entity;

/**
 * Created by LENOVO on 8/5/2018.
 */

public class ConductorCreate {
    private String nombre;
    private String apellidos;
    private String estado;
    private String experienLab;
    private String causa;
    private String telefono;
    private String correo;
    private String estadoCivil;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getExperienLab() {
        return experienLab;
    }

    public void setExperienLab(String experienLab) {
        this.experienLab = experienLab;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
