package com.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.BusinessLogic.LoginAdminController;
import com.BusinessLogic.LoginUserController;
import com.example.ahorcado.R;

public class MainActivity extends AppCompatActivity {
    EditText email, password;
    Button login;
    private CheckBox check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            email=(EditText)findViewById(R.id.emailJoin_txt);
            password=(EditText)findViewById(R.id.passJoin_txt);
            login= (Button)findViewById(R.id.log_btn);
            check = (CheckBox) findViewById(R.id.admin_check);


        //*falta arreglar que el check funcione

       if (check.isChecked() == true){
           final LoginAdminController suc= new LoginAdminController(getApplicationContext());
           login.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if(suc.loginAdmin(email.getText().toString(), password.getText().toString())){
                       Toast.makeText(getApplicationContext(), "Login admin exitoso", Toast.LENGTH_SHORT).show();
                   }else{
                       Toast.makeText(getApplicationContext(), "Login admin no exitoso", Toast.LENGTH_SHORT).show();
                   }
               }
           });
       }
       if(check.isChecked() == false) {
            final LoginUserController suc= new LoginUserController(getApplicationContext());
            login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(suc.loginUser(email.getText().toString(), password.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Login user exitoso", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Login user no exitoso", Toast.LENGTH_SHORT).show();
                }
            }
        });
       }}




    public boolean CheckboxStatus(View v) {
        if(check.isChecked()){
            return true;
        }else{
            return false;
        }
    }
    // Metodo para cambiar a activity register
    public void openRegisterActivity(View view){
        Intent openRegisterActivity = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(openRegisterActivity);
    }
    public void openMenuAdminActivity(View view){
        Intent openMenuAdminActivity = new Intent(MainActivity.this, MenuAdminActivity.class);
    }
    public void openMenuUserActivity(View view){
        Intent openRegisterActivity = new Intent(MainActivity.this, MenuUserActivity.class);
    }

}
