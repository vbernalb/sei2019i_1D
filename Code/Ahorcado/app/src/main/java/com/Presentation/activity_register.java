package com.Presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.BusinessLogic.SignInUserController;
import com.example.ahorcado.R;

public class activity_register extends AppCompatActivity {
    EditText email, password, password2;
    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email=(EditText)findViewById(R.id.Email);
        password=(EditText)findViewById(R.id.Password);
        password2=(EditText)findViewById(R.id.Password2);
        signIn= (Button)findViewById(R.id.SingIn);
        final SignInUserController suc= new SignInUserController(getApplicationContext());

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (suc.singin(email.getText().toString(), password.getText().toString(), password2.getText().toString()))
                    Toast.makeText(getApplicationContext(), "REGISTRO EXITOSO", Toast.LENGTH_SHORT).show();
                else Toast.makeText(getApplicationContext(), "REGISTRO INCORECTO", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
