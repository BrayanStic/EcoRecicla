package com.example.ecorecicla;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecorecicla.models.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button login;
    TextView recuperarCont;
    TextView register;

    EditText user, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login=findViewById(R.id.buttonIngresar);
        recuperarCont=findViewById(R.id.textViewOlvCont);
        register=findViewById(R.id.textViewNuevoRegist);
        user=findViewById(R.id.editTextUsuario);
        password=findViewById(R.id.editTextContraseña);

        File fileReader = new File(getFilesDir(),"user.txt");

        ArrayList<User> usersList= listUsers(fileReader);

        Intent olvidarCont=new Intent (getApplicationContext(), RecuperarContrasenaActivity.class);
        Intent registerUser=new Intent (getApplicationContext(), RegistroUsuarioActivity.class);
        Intent home= new Intent(getApplicationContext(), HomeActivity.class);


        recuperarCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(olvidarCont);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean state= false;
                if (user.getText().toString().isEmpty() ||
                        password.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Ambos campos deben estar completos",
                            Toast.LENGTH_LONG).show();
                }else{
                    for(User i:usersList){
                        if (i.getName().equals(user.getText().toString())||
                                i.getEmail().equals(user.getText().toString())||
                                i.getPhone().equals(user.getText().toString())){
                            state=true;
                            if(i.getPassword().equals(password.getText().toString())){

                                home.putExtra("idUser",i.getIdUser());

                                Toast.makeText(getApplicationContext(),
                                        "Los datos son correcto",Toast.LENGTH_LONG).show();
                                try {
                                    sleep(500);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startActivity(home);
                                break;
                            }else {
                                Toast.makeText(getApplicationContext(),
                                        "La contraseña es incorrecta",Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                    if (!state){
                        Toast.makeText(getApplicationContext(),
                                "Este usuario no esta registrado",Toast.LENGTH_LONG).show();
                    }

                }

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(registerUser);
            }
        });
    }

    public ArrayList<User> listUsers(File fileUser){
        ArrayList<User> list= new ArrayList<>();
        try {
            FileReader fileReader= new FileReader(fileUser);
            BufferedReader reader= new BufferedReader(fileReader);
            String user;

            while ((user=reader.readLine())!=null){
                String[] userArray = user.split(",");
                String id= userArray[0];
                String name= userArray[1];
                String email= userArray[2];
                String phone= userArray[3];
                String password= userArray[4];

                User userObj= new User(id,name,email,phone,password);
                list.add(userObj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;

    }
}