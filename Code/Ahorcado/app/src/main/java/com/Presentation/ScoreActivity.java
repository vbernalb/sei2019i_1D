package com.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ahorcado.R;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
    }

    public void openMainActivity(View view){
        Intent openMainActivity = new Intent(ScoreActivity.this, MainActivity.class);
        startActivity(openMainActivity);
    }
}
