package hernandez.perez.uca.com.taximetrodos.entity;

import android.arch.persistence.room.ColumnInfo;

/**
 * Created by LENOVO on 8/5/2018.
 */

public class ComentarioCreate {
    @ColumnInfo(name = "titulo")
    private String titulo;
    @ColumnInfo (name = "descripcion")
    private String descripcion;

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
}
