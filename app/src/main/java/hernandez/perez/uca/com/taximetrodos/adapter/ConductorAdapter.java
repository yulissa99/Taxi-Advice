package hernandez.perez.uca.com.taximetrodos.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import hernandez.perez.uca.com.taximetrodos.R;
import hernandez.perez.uca.com.taximetrodos.entity.Conductor;

public class ConductorAdapter extends RecyclerView.Adapter<ConductorAdapter.ViewHolder> {
    private List<Conductor> conductores;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView nombre;
        public TextView estado;


        public ViewHolder(View view) {
            super(view);
            nombre = view.findViewById(R.id.full_name);
            estado = view.findViewById(R.id.status);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ConductorAdapter(List<Conductor> conductores) {
        this.conductores = conductores;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ConductorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_conductor, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Conductor conductor = conductores.get(position);

        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.nombre.setText(conductor.getNombre());
        holder.estado.setText(conductor.getEstado());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return conductores.size();
    }
}
