package hernandez.perez.uca.com.taximetrodos.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tumblr.remember.Remember;

import hernandez.perez.uca.com.taximetrodos.R;
import hernandez.perez.uca.com.taximetrodos.api.Api;
import hernandez.perez.uca.com.taximetrodos.entity.Conductor;
import hernandez.perez.uca.com.taximetrodos.entity.ConductorCreate;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResumeActivity extends AppCompatActivity {


    private EditText nombre;
    private EditText apellidos;
    private EditText estado;
    private EditText telefono;
    private EditText experien_lab;
    private EditText causa;
    private EditText correo;
    private EditText estado_civil;
    private Button create_resume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        initViews();
    }

    /**
     * Initialize the views
     */

    private void initViews() {
        nombre = (EditText) findViewById(R.id.nombre);
        apellidos = (EditText) findViewById(R.id.apellidos);
        estado = (EditText) findViewById(R.id.estado);
        telefono = (EditText) findViewById(R.id.telefono);
        experien_lab = (EditText) findViewById(R.id.experien_lab);
        causa = (EditText) findViewById(R.id.causa);
        correo = (EditText) findViewById(R.id.correo);
        estado_civil = (EditText) findViewById(R.id.estado_civil);
        create_resume = (Button) findViewById(R.id.create_resume);

        create_resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                create_resume();
            }
        });

    }

    /**
     * Verify that the fields are not empty and create a new user.
     */

    private void create_resume() {
        if (nombre.getText().toString().isEmpty() || apellidos.getText().toString().isEmpty() ||  estado.getText().toString().isEmpty() || telefono.getText().toString().isEmpty() || experien_lab.getText().toString().isEmpty() ||  causa.getText().toString().isEmpty() || correo.getText().toString().isEmpty() ||  estado_civil.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(),getString(R.string.activity_sing_up_empty_fields_message), Toast.LENGTH_LONG).show();
        }
        else
        {
            // instance a user
            ConductorCreate conductor = new ConductorCreate();
            conductor.setNombre(nombre.getText().toString());
            conductor.setApellidos(apellidos.getText().toString());
            conductor.setEstado(estado.getText().toString());
            conductor.setTelefono(telefono.getText().toString());
            conductor.setExperienLab(experien_lab.getText().toString());
            conductor.setCausa(causa.getText().toString());
            conductor.setCorreo(correo.getText().toString());
            conductor.setEstadoCivil(estado_civil.getText().toString());

            // create call
            Call<Conductor> call = Api.instance().postConductor(conductor);
            call.enqueue(new Callback<Conductor>() {
                @Override
                public void onResponse(Call<Conductor> call, Response<Conductor> response) {
                    if (response.body() != null) {
                        Log.i("HPTA RESPONDE",response.body().getNombre());
                        Log.i("HPTA RESPONDE", String.valueOf(response.body().getId()));
                    }
                }

                @Override
                public void onFailure(Call<Conductor> call, Throwable t) {
                    Log.e("ERROR POST DRIVER",t.getMessage());
                }
            });
        }
    }
}
