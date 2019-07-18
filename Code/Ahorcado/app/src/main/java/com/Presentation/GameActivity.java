package com.Presentation;


import android.app.ActionBar;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
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

public class GameActivity extends AppCompatActivity {
    ImageView img;
    Button btn;
    LinearLayout ly;
    private TextView tv;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        btn= (Button)findViewById(R.id.img_btn);
        img= (ImageView) findViewById(R.id.image_ahorc);
        ly= (LinearLayout) findViewById(R.id.layout_word);
        int WrapWidth = LinearLayout.LayoutParams.WRAP_CONTENT;
        int WrapHeight = LinearLayout.LayoutParams.WRAP_CONTENT;
        //prueba cambiar imagen
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==1){
                    img.setImageResource(R.drawable.a);
                }
                if(count==2){
                    img.setImageResource(R.drawable.b);
                }
                if(count==3){
                    img.setImageResource(R.drawable.c);
                }
                if(count==4){
                    img.setImageResource(R.drawable.d);
                }
                if(count==5){
                    img.setImageResource(R.drawable.e);
                }
                if(count==6){
                    img.setImageResource(R.drawable.f);
                }
                count++;
            }


        });
        // prueba tamaño palabra
        //cambiar número probar text view
       for (int i = 0; i <= 10 ; i++)
        {
            TextView myText = new TextView(this);
            myText.setHeight(100);
            myText.setWidth(100);
            myText.setBackground(getDrawable(R.drawable.edittext_form));
            myText.setText("L"+ i);
            ly.addView(myText);
        }

        /*final int c = 12;
            final TextView[] mtext = new TextView[c];
            for (int i = 0; i < c; i++) {
            TextView rowtxt = new TextView(this);
            rowtxt.setText("Hello" + i);
            myLinearLayout.addView(rowtxt);
            myTextViews[i] = rowtxt;
            myTextViews[i].setOnClickListener(onclicklistener);*/

    }


    // metodo para verificar, desactivar botones y cambiar color

    public void Verificar(View v) {
        Button btn = (Button) v;
        String str = btn.getText().toString();
        btn.setEnabled(false);
        btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#F31C0A")));
        Toast.makeText(this, "Boton desactivado", Toast.LENGTH_SHORT).show();
    }

    //cerrar sesion
    public void exit(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


}