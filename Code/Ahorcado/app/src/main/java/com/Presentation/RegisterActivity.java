package com.Presentation;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.BusinessLogic.InsertCategoryController;
import com.BusinessLogic.SignInUserController;
import com.example.ahorcado.R;

public class RegisterActivity extends AppCompatActivity {
    EditText email, password, password2;
    Button signIn;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email=(EditText)findViewById(R.id.Email);
        password=(EditText)findViewById(R.id.Password);
        password2=(EditText)findViewById(R.id.Password2);
        signIn= (Button)findViewById(R.id.SingIn);
        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this, "EL correo debe ser un correo válido (con @)" + "\n"+
                        "Las contraseñas deben coincidir" + "\n"+
                        "Las contraseñas deben contener entre 6 y 18 caracteres", Toast.LENGTH_SHORT).show();
            }
        });
        final SignInUserController suc= new SignInUserController(RegisterActivity.this);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suc.singin(email.getText().toString(),password.getText().toString(), password2.getText().toString());
            }
        });
    }

    public void nuevoIntent(boolean confirm, Context context){
        System.out.println("*** context  "+ context);
        System.out.println("*** confirm  "+ confirm);
        if(confirm){
           
            Toast.makeText(context, "Usuario registrado", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Usuario ya registrado", Toast.LENGTH_SHORT).show();
        }
    }

}
