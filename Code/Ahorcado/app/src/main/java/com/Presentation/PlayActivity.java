package com.Presentation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.BusinessLogic.InsertWordController;
import com.BusinessLogic.SelectGameController;
import com.example.ahorcado.R;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
 //       new SelectGameController(PlayActivity.this).showCategory1();

    }
    public void nuevoIntentP(String[] inputArray, Context context) {
        System.out.println("*** context  " + inputArray.toString());

        final Spinner spinnerCat = (Spinner) findViewById(R.id.spinnerCat);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, inputArray);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCat.setAdapter(arrayAdapter);
        final Spinner spinnerDif = (Spinner) findViewById(R.id.spinnerDif);
        Button buttonPlay = (Button) findViewById(R.id.buttonPlay);
    }


  /*  public void nuevoIntent1(boolean confirm, Context context){
        System.out.println("*** context  "+ context);
        System.out.println("*** confirm  "+ confirm);
        final Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
        final Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
        if(confirm){
           // new InsertWordController(PlayActivity.this).diff_cat_create(editText.getText().toString(),
            //        spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString(), spinner2.getItemAtPosition(spinner2.getSelectedItemPosition()).toString());
           // Toast.makeText(context, "Palabra agregada", Toast.LENGTH_SHORT).show();
        }else{
           // Toast.makeText(context, "Palabra ya existente", Toast.LENGTH_SHORT).show();
        }

    }*/

}
