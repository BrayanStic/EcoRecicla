package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PlasticoRegistro extends AppCompatActivity {

    ImageView home,atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plastico_registro);

        Intent receive= getIntent();
        String idUser= receive.getStringExtra("idUser");

        home=findViewById(R.id.logoHome);
        atras=findViewById(R.id.atrasFlecha);

        Intent pantallaPrin=new Intent(getApplicationContext(), HomeActivity.class);
        Intent pantallaAtras=new Intent(getApplicationContext(), HomeActivity.class);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(pantallaPrin);
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(pantallaAtras);
            }
        });
    }
}