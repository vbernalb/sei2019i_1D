package com.Presentation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.BusinessLogic.ScoreViewController;
import com.example.ahorcado.R;

public class ScoreActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        final Bundle bundle = getIntent().getExtras();
        new ScoreViewController(ScoreActivity.this).viewScore(bundle.getString("email_user"));

    }

    /**
     * Esta funcion muestra el puntaje que tiene el usuario
     * @param score puntaje en integer del usuari<o
     * @param context   contexto de la actividad
     */
    public void nuevoIntent(int score, Context context) {
        System.out.println("*** context  " + context);
        TextView textView = findViewById(R.id.textView11);
        textView.setText(Integer.toString(score));
        //Toast.makeText(context, Integer.toString(score), Toast.LENGTH_SHORT).show();
    }

    /**
     * Intent para abrir la actividad
     * @param view
     */
    public void openMainActivity(View view){
        Intent openMainActivity = new Intent(ScoreActivity.this, MainActivity.class);
        startActivity(openMainActivity);
    }
}