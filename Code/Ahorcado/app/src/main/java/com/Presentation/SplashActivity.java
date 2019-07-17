package com.Presentation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.ahorcado.R;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    protected boolean _active = true;
    protected int _splashTime = 1500; // Tiempo máximo de duración de splash (espera normal) en milisegundos.
    protected int _controlTime = 100;  // Tiempo de control de toque de pantalla en milisegundos.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash);

        Thread splashTread = new Thread() {
            @Override
            public void run() {

                try {
                    int waited = 0;
                    while(_active && (waited < _splashTime)) {
                        if(_active) {

                            sleep( _controlTime );
                            waited += _controlTime;
                        }
                    }
                } catch(InterruptedException e) {
                    // Capturamos la excepción de interrupción y continuamos por finally.
                } finally {

                    startActivity( new Intent(SplashActivity.this, MainActivity.class) );

                    finish();
                }
            }
        };
        splashTread.start();
    }

    /* Detectamos si el usuario toca la pantalla e Interrumpimos la espera normal */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            _active = false;
        }
        return true;
    }
}
