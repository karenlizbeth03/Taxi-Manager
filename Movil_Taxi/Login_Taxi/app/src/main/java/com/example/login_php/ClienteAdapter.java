package com.example.login_php;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ViewHolder> {

    private ArrayList<Cliente> clientes;
    private Activity activity;
    private Button btnCancelar;
    private static int posicionSeleccionada = 0;

    public ClienteAdapter(ArrayList<Cliente> clienteFromJson, Activity principalActivity) {
        this.clientes=clienteFromJson;
        this.activity=principalActivity;
        this.btnCancelar = this.activity.findViewById(R.id.btnCancelar);
    }

    @NonNull
    @Override
    public ClienteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_clientes,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ClienteAdapter.ViewHolder holder, int position) {
        holder.llenarDatos(this.clientes.get(position));
        holder.itemView.findViewById(R.id.cardclientes)
                .setBackgroundColor(this.posicionSeleccionada == position ? Color.parseColor("#34495E") : Color.parseColor("#85929E"));

        holder.setBackgroundItem();
        holder.eliminarClienteAccion(this.clientes.get(this.posicionSeleccionada));

    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtCalle1E,txtCalle2E,txtReferenciaE,txtBarrioE,txtInfoE,txtCliCedE;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCalle1E= itemView.findViewById(R.id.txtCalle1E);
            txtCalle2E= itemView.findViewById(R.id.txtCalle2E);
            txtReferenciaE= itemView.findViewById(R.id.txtReferenciaE);
            txtBarrioE= itemView.findViewById(R.id.txtBarrioE);
            txtInfoE= itemView.findViewById(R.id.txtInfoE);
            txtCliCedE= itemView.findViewById(R.id.txtCliCedE);

        }
        public void llenarDatos(Cliente cliente){
            txtCalle1E.setText(cliente.getCalle1());
            txtCalle2E.setText(cliente.getCalle2());
            txtReferenciaE.setText(cliente.getReferencia());
            txtBarrioE.setText(cliente.getBarrio());
            txtInfoE.setText(cliente.getInfo());
            txtCliCedE.setText(cliente.getCliente());
        }

        public void eliminarClienteAccion(Cliente cliente) {
            btnCancelar.setOnClickListener(view -> {
                eliminarCliente(cliente);
            });
        }
        public void eliminarCliente(Cliente cliente) {
            String url = "http://192.168.0.102:8080/ServiciosAD/MovilC/eliminar.php";
            RequestQueue requestQueue = Volley.newRequestQueue(activity);
            StringRequest stringRequest = new StringRequest(Request.Method.POST,
                    url, response -> {
                clientes.remove(cliente);
                posicionSeleccionada = 0;
                Lugares.cargarClientes(activity,"");
                Toast.makeText(activity, "¡Cancelación Exitosa!",
                        Toast.LENGTH_LONG).show();
            }, error -> {
                Toast.makeText(activity, "¡Cancelación Fallida!",
                        Toast.LENGTH_LONG).show();
            }) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();
                    params.put("calle1", cliente.getCalle1());
                    return params;
                }
            };
            requestQueue.add(stringRequest);
        }

        public void setBackgroundItem() {
            itemView.setOnClickListener(View -> {
                if (getAdapterPosition() == RecyclerView.NO_POSITION) return;
                notifyItemChanged(posicionSeleccionada);
                posicionSeleccionada = getAdapterPosition();
                notifyItemChanged(posicionSeleccionada);
            });
        }
    }



}