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

    public void onClick(View view){
        Intent intent = null;

        switch (view.getId()){
            case R.id.mu_jugar:
                intent = new Intent(this,PlayActivity.class);
                break;
            case R.id.mu_puntaje:
                intent = new Intent(this, ScoreActivity.class);
                System.out.println(email_user);
                intent.putExtra("email_user", email_user);
                break;
        }
        if(intent!=null){

            startActivity(intent);
        }
    }
}
