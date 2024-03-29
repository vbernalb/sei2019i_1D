package com.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ahorcado.R;

public class FinishActivity extends AppCompatActivity {
    String email_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        Bundle bundle = getIntent().getExtras();
        email_user = bundle.getString("email_user");
    }

    /**
     * Esta funcion permite controlar el evento Onclick para volver a las actividades de selecion de categorias,
     * ver puntuacion y volver al menu principal, ya no se necesita referenciar los botones.
     * @param view
     */

    public void onClick(View view){
        Intent intent = null;

        switch (view.getId()){
            case R.id.category_btn:
                intent = new Intent(this,PlayActivity.class);
                intent.putExtra("email",email_user);
                break;

            case R.id.points_btn:
                intent = new Intent(this, ScoreActivity.class);
                intent.putExtra("email_user",email_user);
                break;

            case R.id.try_btn:
                intent = new Intent(this, MenuUserActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("email_user",email_user);
                break;


        }
        if(intent!=null){

            startActivity(intent);
            finish();
        }
    }
}
