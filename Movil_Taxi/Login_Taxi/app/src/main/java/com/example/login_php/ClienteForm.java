package com.example.login_php;

import static androidx.core.app.ActivityCompat.finishAffinity;
import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.VolleyError;
import com.android.volley.Response;

import java.util.HashMap;
import java.util.Map;

public class ClienteForm extends Dialog implements View.OnClickListener {

     Activity activity;
    private TextView edCalle1, edCalle2, edReferencia, edBarrio,edInfo,edCliente;
    private String tipoConfiguracion;
    private Button btnSolicitarF;
    private RequestQueue requestQueue;
    private Cliente cliente;
    private com.example.login_php.ClienteAdapter.ViewHolder holder;

    public ClienteForm(Activity activity, String confirmar) {
        super(activity);
        this.activity = activity;
        this.tipoConfiguracion = confirmar;
        this.requestQueue = Volley.newRequestQueue(activity);

    }

    public ClienteForm(Activity activity, String confirmar, Cliente cliente, com.example.login_php.ClienteAdapter.ViewHolder holder) {
        super(activity);
        this.activity = activity;
        this.tipoConfiguracion = confirmar;
        this.requestQueue = Volley.newRequestQueue(activity);
        this.cliente = cliente;
        this.holder = holder;
    }

    enum confirmar {
        Solicitar
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.form_lugar);
        initComponents();
        definirTipo();

        this.btnSolicitarF.setOnClickListener(this);
    }

    private void definirTipo() {
    }

    private void initComponents() {
        this.edCalle1 = findViewById(R.id.edCalle1);
        this.edCalle2 = findViewById(R.id.edCalle2);
        this.edReferencia = findViewById(R.id.edReferencia);
        this.edBarrio = findViewById(R.id.edBarrio);
        this.edInfo = findViewById(R.id.edInfo);
        this.edCliente = findViewById(R.id.edCliente);
        this.btnSolicitarF = findViewById(R.id.btnSolicitarF);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSolicitarF:
                switch (this.tipoConfiguracion) {
                    case "Solicitar":
                        guardarSolicitud();
                        break;
                }

        }
        dismiss();

    }

    private void guardarSolicitud() {
        String url = "http://192.168.0.102:8080/ServiciosAD/MovilC/guardar.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, response -> {
            Toast.makeText(activity, ("Se guardo"), Toast.LENGTH_LONG).show();
            Lugares.cargarClientes(activity,"");
        }, error -> Toast.makeText(activity, ("No se guardo"), Toast.LENGTH_LONG).show()) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                //Toast.makeText(activity,txtCedulaF.getText().toString(), Toast.LENGTH_SHORT).show();
                params.put("calle1", edCalle1.getText().toString());
                params.put("calle2", edCalle2.getText().toString());
                params.put("referencia", edReferencia.getText().toString());
                params.put("barrio", edBarrio.getText().toString());
                params.put("info", edInfo.getText().toString());
                params.put("cli_cedula", edCliente.getText().toString());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }






}