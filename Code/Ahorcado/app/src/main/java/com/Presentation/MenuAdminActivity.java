package com.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.DataAcces.Models.Word;
import com.example.ahorcado.R;
public class MenuAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);
    }

    public void onClick(View view){
        Intent intent = null;

        switch (view.getId()){
            case R.id.ma_category:
                intent = new Intent(this,CategoryActivity.class);
                break;
            case R.id.ma_word:
                intent = new Intent(this, WordActivity.class);
                break;
        }
        if(intent!=null){
            startActivity(intent);
        }
    }

    public void openMainActivity(View view){
        Intent openMainActivity = new Intent(MenuAdminActivity.this, MainActivity.class);
        startActivity(openMainActivity);
        finishActivity(0);
    }
}