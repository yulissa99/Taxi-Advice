package hernandez.perez.uca.com.taximetrodos.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by LENOVO on 12/4/2018.
 */

@Entity
public class Lugar {

    @PrimaryKey (autoGenerate = true)
    private int id;
    @ColumnInfo (name = "name")
    private String nombre;
    @ColumnInfo (name = "descripcion")
    private String descripcion;
    @ColumnInfo (name = "coordX")
    private double coordX;
    @ColumnInfo (name = "coordY")
    private double coordY;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCoordX() {
        return coordX;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }
}
