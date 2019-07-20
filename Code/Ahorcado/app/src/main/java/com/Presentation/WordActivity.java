package com.Presentation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

        final Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, inputArray);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);
        final EditText editText = (EditText)findViewById(R.id.ca_word);
        final Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);

        Button button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new InsertWordController(WordActivity.this).InsertWord(editText.getText().toString(), "",
                        spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString(), spinner2.getItemAtPosition(spinner2.getSelectedItemPosition()).toString());
            }
        });
    }

    public void nuevoIntent1(boolean confirm, Context context){
        System.out.println("*** context  "+ context);
        System.out.println("*** confirm  "+ confirm);
        final Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
        final EditText editText = (EditText)findViewById(R.id.ca_word);
        final Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
        if(confirm){
            //new InsertWordController(WordActivity.this).diff_cat_create(editText.getText().toString(),
                   // spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString(), spinner2.getItemAtPosition(spinner2.getSelectedItemPosition()).toString());
            Toast.makeText(context, "Palabra agregada", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Palabra ya existente", Toast.LENGTH_SHORT).show();
        }

    }
   /*public void nuevoIntent2(boolean confirm, Context context){
        System.out.println("*** context  "+ context);
        System.out.println("*** confirm  "+ confirm);
        if(confirm){
            Intent intent = new Intent(context, WordActivity.class);
            startActivity(intent);
            finishActivity(0);
            Toast.makeText(context, "Palabra agregada", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Palabra no agregada a diff_cat", Toast.LENGTH_SHORT).show();
        }
    }*/

    public void openMenuAdminActivity(View view){
        Intent openMenuAdminActivity = new Intent(WordActivity.this, MenuAdminActivity.class);
        startActivity(openMenuAdminActivity);
        finishActivity(1);
    }
}
