package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class RecuperarContrasenaActivity extends AppCompatActivity {

    ImageView atras;
    Button recuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contrasena);

        atras=findViewById(R.id.atrasFlecha);
        recuperar=findViewById(R.id.buttonRestCont);

        Intent flechaAtras=new Intent(getApplicationContext(),MainActivity.class);
        Intent newUser=new Intent(getApplicationContext(), VerificarContraActivity.class);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(flechaAtras);
            }
        });
        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(newUser);
            }
        });
    }
}