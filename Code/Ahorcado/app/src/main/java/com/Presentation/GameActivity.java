package com.Presentation;


import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.BusinessLogic.PlayController;
import com.BusinessLogic.ScoreViewController;
import com.example.ahorcado.R;

import org.w3c.dom.Text;

import java.sql.SQLOutput;

public class GameActivity extends AppCompatActivity {
    ImageView img;
    LinearLayout ly;
    private TextView tv;
    int count = 1;
    public int numOfTrials = 6;
    public static int time = 2500;

    char[] fromDB;
    char[] outputWord;

    boolean isMatch;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        img = (ImageView) findViewById(R.id.image_ahorc);
        ly = (LinearLayout) findViewById(R.id.layout_word);
        int WrapWidth = LinearLayout.LayoutParams.WRAP_CONTENT;
        int WrapHeight = LinearLayout.LayoutParams.WRAP_CONTENT;
        bundle = getIntent().getExtras();
        System.out.println("WORD IS ......... " + bundle.getString("word"));
        System.out.println("DESCRIPTION IS ......... " + bundle.getString("description"));
        String description = "Pista: " + bundle.getString("description");
        fromDB = bundle.getString("word").toLowerCase().toCharArray();
        outputWord = getInitWordAndSetHint(new String(fromDB), description).toCharArray();
    }

    /**
     * nos da la palabra
     * @param touchString
     * @return
     */
    public String getTempWord(String touchString) {
        isMatch = false;
        char touchChar = touchString.toLowerCase().charAt(0);
        for (int k = 0; k < fromDB.length; k++)
            if (fromDB[k] == touchChar) {
                outputWord[k] = touchChar;
                isMatch = true;
            }
        return new String(outputWord);
    }

    /**
     * devolvemos la palabra con la pista
     * @param wordFromDB
     * @param hintString
     * @return
     */
    public String getInitWordAndSetHint(String wordFromDB, String hintString){
        TextView guessWord = findViewById(R.id.textView30);
        TextView hintWord = findViewById(R.id.textView35);
        String initWord = "";
        for (char c : wordFromDB.toCharArray())
            initWord += "-";
        guessWord.setText(initWord);
        hintWord.setText(hintString);
        return initWord;
    }

    /**
     * Función que desactiva los botones cuando el juego termina y los cambia de color
     * además se cambian las respectivas imagenes de ahorcado y hace el cambio de actividad
     * automaticamente
     */
    public void setState() {
        TextView numOfTrials = findViewById(R.id.textView40);
        String message = "";

        if (isMatch) {
            message = "Quedan " + GameActivity.this.numOfTrials + " intentos";
            if (hasWon()) {
                new PlayController(GameActivity.this).subirScore(bundle.getString("email"),bundle.getInt("score"));
                message = "¡GANASTE!";
                deactivateAllButtons();
                img.setImageResource(R.drawable.g);
                cambiarActivity(time);
            }
        } else if (GameActivity.this.numOfTrials > 1 && !isMatch) {
            GameActivity.this.numOfTrials--;
            message = "Quedan " + GameActivity.this.numOfTrials + " intentos";

            if (count == 1) {
                img.setImageResource(R.drawable.a);
            }
            if (count == 2) {
                img.setImageResource(R.drawable.b);
            }
            if (count == 3) {
                img.setImageResource(R.drawable.c);
            }
            if (count == 4) {
                img.setImageResource(R.drawable.d);
            }
            if (count == 5) {
                img.setImageResource(R.drawable.e);
            }
            count++;

        } else {
            message = "Perdiste";
            img.setImageResource(R.drawable.f);
            deactivateAllButtons();
            TextView gameOverWord = findViewById(R.id.textView30);
            gameOverWord.setText(new String(fromDB));
            cambiarActivity(time);
        }
        numOfTrials.setText(message);
    }

    /**
     * funcion que desactiva los botones de un layout
     * @param inputLinearLayout layout en el que se encuentran los botones
     */
    public void deactivateButtons(LinearLayout inputLinearLayout) {
        for (int i = 0; i < 9; i++) {
            Button btn = (Button) inputLinearLayout.getChildAt(i);
            btn.setEnabled(false);
            btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00BFFF")));
        }
    }

    /**
     * desactiva los botones de todos los layouts
     */
    public void deactivateAllButtons() {
        LinearLayout linearLayout = findViewById(R.id.linearLayout10);
        deactivateButtons(linearLayout);
        LinearLayout linearLayout2 = findViewById(R.id.linearLayout20);
        deactivateButtons(linearLayout2);
        LinearLayout linearLayout3 = findViewById(R.id.linearLayout30);
        deactivateButtons(linearLayout3);
    }

    /**
     * verifica que el boton seleccionado (la letra) se encuentre o no en la palabra y lo cambia de color y desactiva
     * @param v View del botón
     */
    public void Verificar(View v) {
        Button btn = (Button) v;
        String colorButton;
        String str = btn.getText().toString();
        btn.setEnabled(false);
        TextView guessWord = findViewById(R.id.textView30);
        guessWord.setText(getTempWord(str));
        btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#F31C0A")));

        if (isMatch)
            colorButton = "#00F700";
        else
            colorButton = "#F31C0A";
        btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(colorButton)));
        setState();

        //Toast.makeText(this, "Boton desactivado", Toast.LENGTH_SHORT).show();
    }

    /**
     * detecta cuando gana o pierde el juego
     * @return
     */
    public boolean hasWon() {
        String fromDBString = new String(fromDB);
        TextView guessWord = findViewById(R.id.textView30);

        if (fromDBString.equals(guessWord.getText().toString()))
            return true;

        return false;
    }

    /**
     * cierra la sesión
     * @param view
     */
    //cerrar sesion
    public void exit(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    /**
     * funcion para cambiar la actividad automaticamente
     * @param milisegundos tiempo en el que se cambia la actividad
     */
    public void cambiarActivity(int milisegundos) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                final Intent i = new Intent(GameActivity.this, FinishActivity.class);
                i.putExtra("email_user",bundle.getString("email"));
                GameActivity.this.startActivity(i);
                GameActivity.this.finish();
            }
        }, milisegundos);
    }

}