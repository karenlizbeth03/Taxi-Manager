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

public class MainActivity extends AppCompatActivity {
    EditText cedula,telefono;
    Button btnLogin;
    String str_cedula,str_telefono;
    String url = "http://192.168.0.102:8080/ServiciosAD/MovilC/ValidarUsuario.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cedula= findViewById(R.id.edtCedula);
        telefono=findViewById(R.id.edtTelefono);

    }
    public void Login(View view) {

        if(cedula.getText().toString().equals("")){
            Toast.makeText(this, "Ingresar Cedula", Toast.LENGTH_SHORT).show();
        }
        else if(telefono.getText().toString().equals("")){
            Toast.makeText(this, "Ingresar telefono", Toast.LENGTH_SHORT).show();
        }
        else{


            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Por favor espera...");

            progressDialog.show();

            str_cedula = cedula.getText().toString().trim();
            str_telefono = telefono.getText().toString().trim();


            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();

                    if(response.equalsIgnoreCase("ingreso correctamente")){

                        cedula.setText("");
                        telefono.setText("");
                        startActivity(new Intent(getApplicationContext(),PrincipalActivity.class));
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                    }

                }
            },new Response.ErrorListener(){

                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();
                    params.put("cli_cedula",str_cedula);
                    params.put("cli_telefono",str_telefono);
                    return params;

                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
            requestQueue.add(request);




        }
    }
    public void moveToRegistration(View view) {
        startActivity(new Intent(getApplicationContext(), registrar.class));
        finish();
    }


}