package com.example.login_php;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class registrar extends AppCompatActivity {
    EditText txtcedula,txtnombre,txtapellido,txttelefono;
    Button btn_insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        txtcedula     = findViewById(R.id.edCedula);
        txtnombre    = findViewById(R.id.edNombre);
        txtapellido = findViewById(R.id.edApellido);
        txttelefono = findViewById(R.id.edTelefono);
        btn_insert = findViewById(R.id.btn_register);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertData();
            }
        });
    }

    private void insertData() {

        final String cedula = txtcedula.getText().toString().trim();
        final String nombre = txtnombre.getText().toString().trim();
        final String apellido = txtapellido.getText().toString().trim();
        final String telefono = txttelefono.getText().toString().trim();


        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("cargando...");

        if(cedula.isEmpty()){


            txtcedula.setError("complete los campos");
            return;
        }
        else if(nombre.isEmpty()){

            txtnombre.setError("complete los campos");
            return;
        }
        else if(apellido.isEmpty()){

            txtapellido.setError("complete los campos");
            return;
        }


        else{
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.0.102:8080/ServiciosAD/MovilC/guardar1.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if(response.equalsIgnoreCase("Datos insertados")){

                                Toast.makeText(registrar.this, "Datos insertados", Toast.LENGTH_SHORT).show();

                                progressDialog.dismiss();

                                Intent intent=new Intent(registrar.this, MainActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(registrar.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                Toast.makeText(registrar.this, "No se puede insertar", Toast.LENGTH_SHORT).show();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(registrar.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();

                    params.put("cli_cedula",cedula);
                    params.put("cli_nombre",nombre);
                    params.put("cli_apellido",apellido);
                    params.put("cli_telefono",telefono);




                    return params;
                }
            };


            RequestQueue requestQueue = Volley.newRequestQueue(registrar.this);
            requestQueue.add(request);



        }




    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }






    public  void  login(View v){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }


}