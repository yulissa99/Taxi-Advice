package hernandez.perez.uca.com.taximetrodos.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import hernandez.perez.uca.com.taximetrodos.R;
import hernandez.perez.uca.com.taximetrodos.api.Api;
import hernandez.perez.uca.com.taximetrodos.entity.Comentario;
import hernandez.perez.uca.com.taximetrodos.entity.ComentarioCreate;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SuggestionActivity extends AppCompatActivity {

    private EditText titulo;
    private EditText descr;
    private Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
        initViews();
    }

    /**
     * Initialize the views
     */

    private void initViews() {
        titulo = (EditText) findViewById(R.id.titulo);
        descr = (EditText) findViewById(R.id.descr);
        create = (Button) findViewById(R.id.create);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                create_comment();
            }
        });

    }

    /**
     * Verify that the fields are not empty and create a new user.
     */

    private void create_comment() {
        if (titulo.getText().toString().isEmpty() || descr.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(),getString(R.string.activity_sing_up_empty_fields_message), Toast.LENGTH_LONG).show();
        }
        else
        {
            // instance a user
            ComentarioCreate comentario = new ComentarioCreate();
            comentario.setTitulo(titulo.getText().toString());
            comentario.setDescripcion(descr.getText().toString());

            // create call
            Call<Comentario> call = Api.instance().postComentario(comentario);
            call.enqueue(new Callback<Comentario>() {
                @Override
                public void onResponse(Call<Comentario> call, Response<Comentario> response) {
                    if (response.body() != null) {
                        Log.i("HPTA RESPONDE",response.body().getTitulo());
                        Log.i("HPTA RESPONDE", String.valueOf(response.body().getId()));
                    }
                }

                @Override
                public void onFailure(Call<Comentario> call, Throwable t) {
                    Log.e("ERROR POST DRIVER",t.getMessage());
                }
            });
        }
    }
}
