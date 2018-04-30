package hernandez.perez.uca.com.taximetrodos.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import hernandez.perez.uca.com.taximetrodos.entity.Conductor;

/**
 * Created by LENOVO on 12/4/2018.
 */

@Dao
public interface ConductorDao {

    @Query("SELECT * FROM conductor")
    List<Conductor> getAll();

    @Query("SELECT * FROM conductor WHERE id IN (:idConductor)")
    List<Conductor> loadAllByIds(int idConductor);

    @Insert
    void insertAll(Conductor conductor);

    @Delete
    void delete(Conductor conductor);

}
