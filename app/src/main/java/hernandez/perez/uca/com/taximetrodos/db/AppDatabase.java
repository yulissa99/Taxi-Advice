package hernandez.perez.uca.com.taximetrodos.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import hernandez.perez.uca.com.taximetrodos.dao.ConductorDao;
import hernandez.perez.uca.com.taximetrodos.dao.LugarDao;
import hernandez.perez.uca.com.taximetrodos.entity.Conductor;
import hernandez.perez.uca.com.taximetrodos.entity.Lugar;

/**
 * Created by LENOVO on 12/4/2018.
 */

@Database(entities = {Lugar.class, Conductor.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {
    public abstract LugarDao lugarDao();
    public abstract ConductorDao conductorDao();
}