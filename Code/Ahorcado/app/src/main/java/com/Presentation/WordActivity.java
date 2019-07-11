package com.Presentation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahorcado.R;

import java.util.ArrayList;

public class WordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
    }

/*        System.out.println("*** confirm  " + confirm);
        if (confirm) {
            Intent intent = new Intent(context, CategoryActivity.class);
            startActivity(intent);
            finishActivity(0);
            Toast.makeText(context, "Categoria registrada", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Categoria ya registrada", Toast.LENGTH_SHORT).show();
        }
        */

    public void nuevoIntent(ArrayList<String> inputArrayList, Context context) {
        System.out.println("*** context  " + inputArrayList.toString());
        //TextView textView = findViewById(R.id.textView11);
        //textView.setText(Integer.toString(score));
        //Toast.makeText(context, Integer.toString(score), Toast.LENGTH_SHORT).show();
    }

    public void openMenuAdminActivity(View view){
        Intent openMenuAdminActivity = new Intent(WordActivity.this, MenuAdminActivity.class);
        startActivity(openMenuAdminActivity);
        finishActivity(1);
    }
}
