package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistroUsuarioActivity extends AppCompatActivity {

    Button newUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        newUsuario=findViewById(R.id.buttonRegUsuario);

        Intent newUser=new Intent(getApplicationContext(), HomeActivity.class);

        newUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(newUser);
            }
        });
    }
}