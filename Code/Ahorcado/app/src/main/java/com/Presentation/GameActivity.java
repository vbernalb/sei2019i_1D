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

import com.example.ahorcado.R;

import org.w3c.dom.Text;

public class GameActivity extends AppCompatActivity {
    ImageView img;
    LinearLayout ly;
    private TextView tv;
    int count = 1;
    public int numOfTrials = 6;
    public static int time = 6000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        img = (ImageView) findViewById(R.id.image_ahorc);
        ly = (LinearLayout) findViewById(R.id.layout_word);
        int WrapWidth = LinearLayout.LayoutParams.WRAP_CONTENT;
        int WrapHeight = LinearLayout.LayoutParams.WRAP_CONTENT;
        String inputString = "";
        setInitWord("--------");
    }

    char[] outputWord = {'-', '-', '-', '-', '-', '-', '-', '-'};
    String resultWord = "--------";
    char[] fromDB = "Ahorcado".toLowerCase().toCharArray();
    boolean isMatch;


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

    public boolean isMatch() {
        return isMatch;
    }

    public void setInitWord(String wordFromDB) {
        TextView guessWord = findViewById(R.id.textView30);
        String initWord = "";
        for (char c : wordFromDB.toCharArray())
            initWord += "-";
        guessWord.setText(initWord);
    }
    // metodo para verificar, desactivar botones y cambiar color

    public void setState() {
        TextView numOfTrials = findViewById(R.id.textView40);
        String message = "";

        if (isMatch) {
            message = "Quedan " + GameActivity.this.numOfTrials + " intentos";
            if (hasWon()) {
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

    public void deactivateButtons(LinearLayout inputLinearLayout) {
        for (int i = 0; i < 9; i++) {
            Button btn = (Button) inputLinearLayout.getChildAt(i);
            btn.setEnabled(false);
            btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00BFFF")));
        }
    }

    public void deactivateAllButtons() {
        LinearLayout linearLayout = findViewById(R.id.linearLayout10);
        deactivateButtons(linearLayout);
        LinearLayout linearLayout2 = findViewById(R.id.linearLayout20);
        deactivateButtons(linearLayout2);
        LinearLayout linearLayout3 = findViewById(R.id.linearLayout30);
        deactivateButtons(linearLayout3);
    }

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

    public boolean hasWon() {
        String fromDBString = new String(fromDB);
        TextView guessWord = findViewById(R.id.textView30);

        if (fromDBString.equals(guessWord.getText().toString()))
            return true;

        return false;
    }

    //cerrar sesion
    public void exit(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


    public void cambiarActivity(int milisegundos) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                final Intent i = new Intent(GameActivity.this, FinishActivity.class);
                GameActivity.this.startActivity(i);
                GameActivity.this.finish();
            }
        }, milisegundos);
    }

}