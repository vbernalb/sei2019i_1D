package com.Presentation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.BusinessLogic.InsertWordController;
import com.example.ahorcado.R;

import java.util.ArrayList;

public class WordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        new InsertWordController(WordActivity.this).showCategory();
    }


    public void nuevoIntent(String[] inputArray, Context context) {
        System.out.println("*** context  " + inputArray.toString());

        Spinner spinner = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, inputArray);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }

    public void openMenuAdminActivity(View view){
        Intent openMenuAdminActivity = new Intent(WordActivity.this, MenuAdminActivity.class);
        startActivity(openMenuAdminActivity);
        finishActivity(1);
    }
}
