package edu.cafes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;
//Se coge el layout del item_cafe
//
public class ListaCafesAdapter extends RecyclerView.Adapter<ListaCafesAdapter.ViewHolder> {
    private ArrayList<Cafe> cafes;
    private ItemClickListener itemClickListener;

    public ListaCafesAdapter(ArrayList<Cafe> cafes) {
        this.cafes = new ArrayList<>();
        this.cafes.addAll(cafes);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cafe, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaCafesAdapter.ViewHolder holder, int position) {
        Cafe cafe = cafes.get(position);
        holder.cafeFoto.setImageResource(cafe.getFotoID());
        holder.cafeNombre.setText(cafe.getNombre());
        holder.cafePrecio.setText(
                String.format(Locale.getDefault(), "%.2f €", cafe.getPrecio())
        );
    }

    @Override
    public int getItemCount() {
        return cafes.size();
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public Cafe getCafe(int position) {
        return cafes.get(position);
    }

//interfaz
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        ImageView cafeFoto;
        TextView cafeNombre;
        TextView cafePrecio;

        ViewHolder(View itemView) {
            super(itemView);
            cafeFoto = itemView.findViewById(R.id.item_cafe_foto);
            cafeNombre = itemView.findViewById(R.id.item_cafe_nombre);
            cafePrecio = itemView.findViewById(R.id.item_cafe_precio);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }
}
