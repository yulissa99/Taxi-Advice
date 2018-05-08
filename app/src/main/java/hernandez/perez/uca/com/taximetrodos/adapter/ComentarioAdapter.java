package hernandez.perez.uca.com.taximetrodos.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import hernandez.perez.uca.com.taximetrodos.R;
import hernandez.perez.uca.com.taximetrodos.entity.Comentario;

/**
 * Created by LENOVO on 8/5/2018.
 */

public class ComentarioAdapter extends RecyclerView.Adapter<ComentarioAdapter.ViewHolder> {
    private List<Comentario> comentarios;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView titulo;
        public TextView descripcion;


        public ViewHolder(View view) {
            super(view);
            titulo = view.findViewById(R.id.titulo);
            descripcion = view.findViewById(R.id.descr);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ComentarioAdapter(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ComentarioAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_suggestions, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Comentario comentario = comentarios.get(position);

        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.titulo.setText(comentario.getTitulo());
        holder.descripcion.setText(comentario.getDescripcion());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return comentarios.size();
    }
}
