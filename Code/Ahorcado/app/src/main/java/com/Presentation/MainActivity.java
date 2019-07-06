package com.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ahorcado.R;

public class MainActivity extends AppCompatActivity {
    EditText email, password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //*if (casilla sesion admin activa){
            email=(EditText)findViewById(R.id.emailJoin_txt);
            password=(EditText)findViewById(R.id.passJoin_txt);
            login= (Button)findViewById(R.id.log_btn);
    }

    // Metodo para cambiar a activity register
    public void openRegisterActivity(View view){
        Intent openRegisterActivity = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(openRegisterActivity);
    }
}
