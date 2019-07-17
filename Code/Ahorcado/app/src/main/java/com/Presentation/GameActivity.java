package com.Presentation;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import android.widget.ImageView;

import com.example.ahorcado.R;

public class GameActivity extends AppCompatActivity {
    ImageView img;
    Button btn;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        btn= (Button)findViewById(R.id.img_btn);
        img= (ImageView) findViewById(R.id.image_ahorc);
        //prueba
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
    }


}