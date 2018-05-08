package hernandez.perez.uca.com.taximetrodos.fragments;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.net.Uri;
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
import hernandez.perez.uca.com.taximetrodos.adapter.ComentarioAdapter;
import hernandez.perez.uca.com.taximetrodos.api.Api;
import hernandez.perez.uca.com.taximetrodos.db.AppDatabase;
import hernandez.perez.uca.com.taximetrodos.entity.Comentario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SuggestionFragment extends Fragment {
    AppDatabase db;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_suggestion, container, false);

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

        Call<List<Comentario>> call = Api.instance().getComentarios();
        call.enqueue(new Callback<List<Comentario>>() {
            @Override
            public void onResponse(Call<List<Comentario>> call, Response<List<Comentario>> response) {
                if (response.body() != null && !response.body().isEmpty()) {

                    Log.i("MESSAGE: ",response.body().get(0).getTitulo());
                    ComentarioAdapter comentarioAdapter = new ComentarioAdapter(response.body());
                    recyclerView.setAdapter(comentarioAdapter);

                    guardarDB(response.body());
                }else{
                    Log.i("MESSAGE: ",response.code()+"");
                }
            }

            @Override
            public void onFailure(Call<List<Comentario>> call, Throwable t) {
                ComentarioAdapter comentarioAdapter = new ComentarioAdapter(cargarDB());
                recyclerView.setAdapter(comentarioAdapter);
            }
        });

    }

    public List<Comentario> cargarDB(){
        List<Comentario> comentarios = db.comentarioDao().getAll();

        return comentarios;
    }

    public boolean validarExistencia(Comentario comentario){

        boolean encontrado = true;

        List<Comentario> comentarios = cargarDB();
        for(int i = 0; i < comentarios.size(); i++){
            if(comentario.getId()== comentarios.get(i).getId()){
                encontrado = false;
                break;
            }
        }
        return encontrado;
    }

    public void guardarDB(List<Comentario> comentarios){
        for (int i=0;i<comentarios.size();i++){
            if(!validarExistencia(comentarios.get(i))){
                db.comentarioDao().insertAll(comentarios.get(i));
            }
        }
    }
}
