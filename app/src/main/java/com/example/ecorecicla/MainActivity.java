package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button ingresar;
    TextView recuperarCont;
    TextView registrarUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ingresar=findViewById(R.id.buttonIngresar);
        recuperarCont=findViewById(R.id.textViewOlvCont);
        registrarUsuario=findViewById(R.id.textViewNuevoRegist);

        Intent ingresa=new Intent(getApplicationContext(),HomeActivity.class);
        Intent olvidarCont=new Intent (getApplicationContext(), RecuperarContrasenaActivity.class);
        Intent registrarUser=new Intent (getApplicationContext(), RegistroUsuarioActivity.class);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ingresa);
            }
        });

        recuperarCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(olvidarCont);
            }
        });

        registrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(registrarUser);
            }
        });
    }
}