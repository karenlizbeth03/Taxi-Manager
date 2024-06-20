package com.example.login_php;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class Lugares extends AppCompatActivity {
    private static RecyclerView rvClientes;
    private static RequestQueue requestQueue;
    private TextView txtBuscar;
    private Button btnBuscar;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtBuscar = findViewById(R.id.txtBuscar);
        btnBuscar = findViewById((R.id.btnBuscar));
        rvClientes = findViewById(R.id.rvClientes);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvClientes.setLayoutManager(manager);

        requestQueue = Volley.newRequestQueue(this);
        cargarClientes(this,"");



    }

    public void buscarRegistros(View view){
        cargarClientes(this, txtBuscar.getText().toString());
    }

    public static void cargarClientes(Activity principalActivity,String cedula) {
        String url = "http://192.168.0.102:8080/ServiciosAD/MovilC/select.php";
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST, url, response -> {
            try {
                Toast.makeText(principalActivity, response, Toast.LENGTH_SHORT).show();
                rvClientes.setAdapter(
                        new ClienteAdapter(
                                Cliente.getClienteFromJson(
                                        new JSONArray(response), principalActivity), principalActivity));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, error -> Toast.makeText(principalActivity,
                error.toString(), Toast.LENGTH_SHORT).show()){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("cli_cedula",cedula );
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }


}