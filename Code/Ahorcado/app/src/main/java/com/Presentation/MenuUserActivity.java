package com.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ahorcado.R;
public class MenuUserActivity extends AppCompatActivity {
    String email_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_user);
        final Bundle bundle = getIntent().getExtras();
        email_user= bundle.getString("email_user");
    }
    /**
     * Esta funcion permite controlar el evento Onclick para ir a la actividades de selecionar categorias,
     * y ver puntaje.
     * @param view
     */

    public void onClick(View view){
        Intent intent = null;

        switch (view.getId()){
            case R.id.mu_jugar:
                intent = new Intent(this,PlayActivity.class);
                intent.putExtra("email",email_user);
                break;
            case R.id.mu_puntaje:
                intent = new Intent(this, ScoreActivity.class);
                intent.putExtra("email_user", email_user);
                break;
        }
        if(intent!=null){

            startActivity(intent);
        }
    }
}
