package hernandez.perez.uca.com.taximetrodos.entity;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by LENOVO on 8/5/2018.
 */

public class ConductorCreate {
    @ColumnInfo(name = "nombre")
    private String nombre;
    @ColumnInfo (name = "estado")
    private String estado;
    @ColumnInfo (name = "apellidos")
    private String apellidos;
    @SerializedName("experien_lab")
    @ColumnInfo (name = "experien_lab")
    private String experienLab;
    @ColumnInfo (name = "causa")
    private String causa;
    @ColumnInfo (name = "telefono")
    private String telefono;
    @ColumnInfo (name = "correo")
    private String correo;
    @SerializedName("estado_civil")
    @ColumnInfo (name = "estado_civil")
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
