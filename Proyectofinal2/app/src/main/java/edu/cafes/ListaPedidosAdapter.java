package edu.cafes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class ListaPedidosAdapter extends RecyclerView.Adapter<ListaPedidosAdapter.ViewHolder> {
    private ArrayList<Pedido> pedidos;

    public ListaPedidosAdapter(ArrayList<Pedido> pedidos) {
        this.pedidos = new ArrayList<>();
        this.pedidos.addAll(pedidos);
    }

    @NonNull
    @Override
    public ListaPedidosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pedido, parent, false);
        return new ListaPedidosAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaPedidosAdapter.ViewHolder holder, int position) {
        Pedido pedido = pedidos.get(position);
        holder.pedidoCafeNombre.setText(pedido.getCafeNombre());
        holder.pedidoDireccion.setText(pedido.getDireccion());
        holder.pedidoPrecio.setText(
                String.format(Locale.getDefault(), "%.2f €", pedido.getPrecio())
        );
    }

    @Override
    public int getItemCount() {
        return pedidos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView pedidoCafeNombre;
        TextView pedidoDireccion;
        TextView pedidoPrecio;

        ViewHolder(View itemView) {
            super(itemView);
            pedidoCafeNombre = itemView.findViewById(R.id.item_pedido_cafe_nombre);
            pedidoDireccion= itemView.findViewById(R.id.item_pedido_direccion);
            pedidoPrecio = itemView.findViewById(R.id.item_pedido_precio);
        }
    }
}
