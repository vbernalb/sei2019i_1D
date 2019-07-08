package com.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ahorcado.R;
public class WordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
    }

    public void openMenuAdminActivity(View view){
        Intent openMenuAdminActivity = new Intent(WordActivity.this, MenuAdminActivity.class);
        startActivity(openMenuAdminActivity);
    }
}
