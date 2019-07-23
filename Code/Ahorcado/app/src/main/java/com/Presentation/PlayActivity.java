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

     Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        bundle = getIntent().getExtras();
        new PlayController(PlayActivity.this).categoryList();

    }

    /**
     * Esta funcion recibe la lista de categorias para ser selecionadas por medio en un Spinner.
     * @param inputArray
     * @param context
     */
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

    /**
     * Esta funcion recibe una palabra aleatoria y su descripcion correspondiente, generada desde PlayController
     * y asi poder iniciar el juego en la actividad game.
     * @param word
     * @param description
     * @param context
     */

    public void nuevoIntent1(String word, String description, Context context){
        System.out.println("*** word  " + word);
        System.out.println("*** context  " + context);
        final String word_f=word;
        System.out.println("pal: "+word_f);
        if(word_f.equals("false")){
            Toast.makeText(context, "No exite palabras en esta categoria", Toast.LENGTH_SHORT).show();
        }
        else{
            final Spinner spinnerDif = (Spinner) findViewById(R.id.spinnerDif);
            Intent intent = new Intent(PlayActivity.this, GameActivity.class);
            intent.putExtra("word", word_f);
            intent.putExtra("description", description);
            intent.putExtra("email",bundle.getString("email"));
            switch (spinnerDif.getItemAtPosition(spinnerDif.getSelectedItemPosition()).toString()){
                case "FACIL":
                    intent.putExtra("score",5);
                    break;
                case "MEDIO":
                    intent.putExtra("score",10);
                    break;
                case "DIFICIL":
                    intent.putExtra("score",15);
                    break;
            }
            System.out.println("WORD + " + word + " DESCRIPTION " + description);
            startActivity(intent);
            PlayActivity.this.finish(); 
        }
    }

}
