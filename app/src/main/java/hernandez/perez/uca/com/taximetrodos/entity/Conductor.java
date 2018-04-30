package hernandez.perez.uca.com.taximetrodos.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by LENOVO on 12/4/2018.
 */

@Entity
public class Conductor {

    @ColumnInfo (name = "nombre")
    private String nombre;
    @ColumnInfo (name = "estado")
    private String estado;
    @PrimaryKey (autoGenerate = true)
    private int id;
    @SerializedName("id_carro")
    @ColumnInfo (name = "id_carro")
    private int idCarro;

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
