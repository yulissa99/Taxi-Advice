package hernandez.perez.uca.com.taximetrodos.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import hernandez.perez.uca.com.taximetrodos.entity.Lugar;

/**
 * Created by LENOVO on 12/4/2018.
 */

@Dao
public interface LugarDao {

    @Query("SELECT * FROM lugar")
    List<Lugar> getAll();

    @Query("SELECT * FROM lugar WHERE id IN (:idlugar)")
    List<Lugar> loadAllByIds(int idlugar);

    @Insert
    void insertAll(Lugar lugar);

    @Delete
    void delete(Lugar lugar);

}
