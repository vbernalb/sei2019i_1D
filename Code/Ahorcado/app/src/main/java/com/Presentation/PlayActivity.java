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
import android.widget.Toast;

import com.BusinessLogic.InsertWordController;
//import com.BusinessLogic.SelectGameController;
import com.BusinessLogic.PlayController;
import com.example.ahorcado.R;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        new PlayController(PlayActivity.this).categoryList();

    }
    public void nuevoIntentP(String[] inputArray, Context context) {
        System.out.println("*** context  " + inputArray.toString());

        final Spinner spinnerCat = (Spinner) findViewById(R.id.spinnerCat);
        final Spinner spinnerDif = (Spinner) findViewById(R.id.spinnerDif);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, inputArray);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCat.setAdapter(arrayAdapter);

        Button buttonPlay = (Button) findViewById(R.id.buttonPlay);

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               new PlayController(PlayActivity.this).play(spinnerCat.getItemAtPosition(spinnerCat.getSelectedItemPosition()).toString(),
                       spinnerDif.getItemAtPosition(spinnerDif.getSelectedItemPosition()).toString());
            }
        });
    }

    public void nuevoIntent1(String word, String description, Context context){
        System.out.println("*** word  " + word);
        System.out.println("*** context  " + context);
        final String word_f=word;
        
        if(word =="false"){
            Toast.makeText(context, "No exite palabras en esta categoria", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(PlayActivity.this, GameActivity.class);
            intent.putExtra("word", word_f);
            startActivity(intent);
            PlayActivity.this.finish(); 
        }
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
