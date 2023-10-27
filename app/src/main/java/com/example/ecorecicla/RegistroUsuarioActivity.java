package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class RegistroUsuarioActivity extends AppCompatActivity {

    Button newUsuario;
    ImageView atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        atras=findViewById(R.id.atrasFlecha);
        newUsuario=findViewById(R.id.buttonRegUsuario);

        Intent flechaAtras=new Intent(getApplicationContext(),MainActivity.class);
        Intent newUser=new Intent(getApplicationContext(), HomeActivity.class);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(flechaAtras);
            }
        });
        newUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(newUser);
            }
        });
    }
}