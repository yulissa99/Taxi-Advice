package hernandez.perez.uca.com.taximetrodos.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by LENOVO on 8/5/2018.
 */
@Entity
public class Comentario {
    @ColumnInfo (name = "titulo")
    private String titulo;
    @ColumnInfo (name = "descripcion")
    private String descripcion;
    @PrimaryKey(autoGenerate = true)
    private int id;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
