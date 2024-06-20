package com.example.login_php;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PrincipalActivity extends AppCompatActivity {

Button btnLugar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btnLugar=findViewById(R.id.btnLugar);
        /*btnsolicitar=(Button)findViewById(R.id.btnsolicitar);
        btnsolicitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(PrincipalActivity.this,Lugares.class);
                startActivity(i);
            }
        });*/


    }
   public void cargarGuardarFormulario(View view){
        ClienteForm clienteForm = new ClienteForm(this, ClienteForm.confirmar.Solicitar.toString());
        clienteForm.show();

    }

    public void Siguiente(View v){
    Intent siguienteC= new Intent(this,Lugares.class);

    startActivity(siguienteC) ;

    }


}