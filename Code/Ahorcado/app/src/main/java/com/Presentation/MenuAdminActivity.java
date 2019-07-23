package com.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.DataAcces.Models.Word;
import com.example.ahorcado.R;
public class MenuAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);
    }

    /**
     * Esta funcion permite controlar el evento Onclick para ir a la actividades de ingreso de categoria,
     * ingreso de nuevas palabras y la opcion de cerrar sesion.
     * @param view
     */

    public void onClick(View view){
        Intent intent = null;

        switch (view.getId()){
            case R.id.ma_category:
                intent = new Intent(this,CategoryActivity.class);
                break;
            case R.id.ma_word:
                intent = new Intent(this, WordActivity.class);
                break;
            case R.id.ma_salir:
                intent = new Intent(this, MainActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                break;
        }
        if(intent!=null){
            startActivity(intent);
        }
    }
}