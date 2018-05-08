package hernandez.perez.uca.com.taximetrodos.fragments;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hernandez.perez.uca.com.taximetrodos.R;
import hernandez.perez.uca.com.taximetrodos.adapter.ConductorAdapter;
import hernandez.perez.uca.com.taximetrodos.api.Api;
import hernandez.perez.uca.com.taximetrodos.db.AppDatabase;
import hernandez.perez.uca.com.taximetrodos.entity.Conductor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConductorFragment extends Fragment {
    AppDatabase db;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conductor, container, false);

        db = Room.databaseBuilder(this.getContext(),
                AppDatabase.class, "chanchito").allowMainThreadQueries()
                .build();

        init(view);
        return view;
    }


    private void init(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Call<List<Conductor>> call = Api.instance().getConductores();
        call.enqueue(new Callback<List<Conductor>>() {
            @Override
            public void onResponse(Call<List<Conductor>> call, Response<List<Conductor>> response) {
                if (response.body() != null && !response.body().isEmpty()) {

                    Log.i("MESSAGE: ",response.body().get(0).getNombre());
                    ConductorAdapter conductorAdapter = new ConductorAdapter(response.body());
                    recyclerView.setAdapter(conductorAdapter);

                    guardarDB(response.body());
                }else{
                    Log.i("MESSAGE: ",response.code()+"");
                }
            }

            @Override
            public void onFailure(Call<List<Conductor>> call, Throwable t) {
                ConductorAdapter conductorAdapter = new ConductorAdapter(cargarDB());
                recyclerView.setAdapter(conductorAdapter);
            }
        });

    }

    public List<Conductor> cargarDB(){
        List<Conductor> conductores = db.conductorDao().getAll();

        return conductores;
    }

    public boolean validarExistencia(Conductor conductor){

        boolean encontrado = true;

        List<Conductor> conductores = cargarDB();
        for(int i = 0; i < conductores.size(); i++){
            if(conductor.getId()== conductores.get(i).getId()){
                encontrado = false;
                break;
            }
        }
        return encontrado;
    }

    public void guardarDB(List<Conductor> conductores){
        for (int i=0;i<conductores.size();i++){
            if(!validarExistencia(conductores.get(i))){
                db.conductorDao().insertAll(conductores.get(i));
            }
        }
    }
}
