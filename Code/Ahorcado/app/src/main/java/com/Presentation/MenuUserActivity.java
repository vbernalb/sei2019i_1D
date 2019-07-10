package com.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ahorcado.R;
public class MenuUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_user);
    }

    public void onClick(View view){
        Intent intent = null;

        switch (view.getId()){
            case R.id.mu_jugar:
                intent = new Intent(this,PlayActivity.class);
                break;
            case R.id.mu_puntaje:
                intent = new Intent(this, ScoreActivity.class);
                break;
        }
        if(intent!=null){
            startActivity(intent);
        }
    }
}
