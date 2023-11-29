package com.example.ecorecicla;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ecorecicla.models.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class RegistroUsuarioActivity extends AppCompatActivity {

    Button register;
    EditText name, email, phone, password1,password2;
    ImageView atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        atras=findViewById(R.id.atrasFlecha);
        register=findViewById(R.id.buttonRegUsuario);
        name=findViewById(R.id.name_user);
        email=findViewById(R.id.email_user);
        phone=findViewById(R.id.phone_user);
        password1=findViewById(R.id.password1_user);
        password2=findViewById(R.id.password2_user);

        Intent flechaAtras=new Intent(getApplicationContext(),MainActivity.class);
        Intent home=new Intent(getApplicationContext(), HomeActivity.class);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(flechaAtras);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateUser()){
                    User user=createUser();
                    storageUser(user);
                    Toast.makeText(getApplicationContext(),"Registro Exitoso"
                            ,Toast.LENGTH_LONG).show();
                    try {
                        sleep(500);
                        startActivity(home);
                        finish();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }else{
                    Toast.makeText(getApplicationContext(),
                            "Asegurarse de que la información esta correcta",Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public String idGenerator(String name){
        String id="";
        for (int i=0; i<2;i++){
            int random1= (int)(Math.random()*name.length());
            int random2= (int)(Math.random()*10000);
            id+=name.charAt(random1);
            id+=random2;
        }
        return id;
    }
    public boolean validateUser(){
        boolean state= true;

        if (name.getText().toString().isEmpty()){
            name.setBackgroundColor(Color.RED);
            state=false;
        }
        if (email.getText().toString().isEmpty()){
            email.setBackgroundColor(Color.RED);
            state=false;
        }
        if (phone.getText().toString().isEmpty()){
            phone.setBackgroundColor(Color.RED);
            state=false;
        }
        if (password1.getText().toString().isEmpty()){
            password1.setBackgroundColor(Color.RED);
            state=false;
        }
        if (password2.getText().toString().isEmpty()){
            password2.setBackgroundColor(Color.RED);
            state=false;
        }
        if (!password1.getText().toString().equals(
                password2.getText().toString())){
            password1.setBackgroundColor(Color.RED);
            password2.setBackgroundColor(Color.RED);
            state=false;
        }

        return state;
    }

    public User createUser(){
        String name_user=name.getText().toString();
        String id=idGenerator(name_user);
        String email_user=email.getText().toString();
        String phone_user=phone.getText().toString();
        String password= password1.getText().toString();

        User user= new User(id,name_user,email_user,phone_user,password);

        return user;
    }
    public void storageUser(User user){


        File fileUser= new File(getFilesDir(),"user.txt");

        try {
            FileWriter writer= new FileWriter(fileUser,true);

                 BufferedWriter bufferedWriter=new BufferedWriter(writer);
            bufferedWriter.write( user.getIdUser()+","+
                    user.getName()+","+
                    user.getEmail()+","+
                    user.getPhone()+","+
                    user.getPassword()
            );
            bufferedWriter.newLine();
            bufferedWriter.close();
        }catch (Exception error){
            error.printStackTrace();
        }

    }
}