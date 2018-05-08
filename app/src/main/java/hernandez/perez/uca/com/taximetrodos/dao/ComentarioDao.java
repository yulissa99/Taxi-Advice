package hernandez.perez.uca.com.taximetrodos.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import hernandez.perez.uca.com.taximetrodos.entity.Comentario;

/**
 * Created by LENOVO on 8/5/2018.
 */

@Dao
public interface ComentarioDao {
    @Query("SELECT * FROM comentario")
    List<Comentario> getAll();

    @Query("SELECT * FROM comentario WHERE id IN (:idComentario)")
    List<Comentario> loadAllByIds(int idComentario);

    @Insert
    void insertAll(Comentario comentario);

    @Delete
    void delete(Comentario comentario);
}
