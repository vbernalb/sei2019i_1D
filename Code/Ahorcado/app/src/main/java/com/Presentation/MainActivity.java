package com.Presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
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
        /**
         * Esta funcion revisa si la checkbox está o no activada con el fin
         * de iniciar sesión como ususario o como admin
         * Llama a LoginUserController o LoginAdminController respectivamente
         */
            check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (check.isChecked() == true){
                        final LoginAdminController suc= new LoginAdminController(MainActivity.this);
                        login.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                suc.loginAdmin(email.getText().toString(), password.getText().toString());
                                //llamar funciòn nuevoIntent
                               // finishActivity(0);
                            }
                        });
                    }
                    if(check.isChecked() == false) {
                        final LoginUserController suc= new LoginUserController(getApplicationContext());
                        login.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //suc.loginUser(email.getText().toString(), password.getText().toString())
                                suc.loginUser(email.getText().toString(), password.getText().toString());
                            }
                        });
                    }
                }
            });
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

    public void nuevoIntent(boolean confirm, Context context){
        System.out.println("*** context  "+ context);
        System.out.println("*** confirm  "+ confirm);
        if(confirm){
            Intent intent = new Intent(context, MenuAdminActivity.class);
            startActivity(intent);
            finishActivity(0);
        }else{
            Toast.makeText(context, "Datos del administrador incorrectos", Toast.LENGTH_SHORT).show();
        }

    }
    public void nuevoIntent2(boolean confirm, Context context){
        System.out.println("*** context  "+ context);
        System.out.println("*** confirm  "+ confirm);
        if(confirm){
            Intent intent = new Intent(context, MenuUserActivity.class);
            startActivity(intent);
            finishActivity(0);
        }else{
            Toast.makeText(context, "Datos del usuario incorrectos", Toast.LENGTH_SHORT).show();
        }

    }
}
