package com.Presentation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.BusinessLogic.InsertCategoryController;
import com.DataAcces.Repositories.CategoryRepository;
import com.example.ahorcado.R;

public class CategoryActivity extends AppCompatActivity {

    EditText etCategory;
    Button btnCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        etCategory = (EditText)findViewById(R.id.ca_category);
        btnCategory = (Button)findViewById(R.id.ca_btn_category);

        btnCategory.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View v) {
                System.out.println("papas1");
                new InsertCategoryController(CategoryActivity.this).InsertCategory(etCategory.getText().toString());
            }
        });
    }

    /**
     * Esta funcion muestra si la categoria fue registrada en la base de datos en o si la categoria ya esta registrada.
     * Espera respuesta desde InsertCategotycontroller
     * @param confirm
     * @param context
     */

    public void nuevoIntent(boolean confirm, Context context){
        System.out.println("*** context  "+ context);
        System.out.println("*** confirm  "+ confirm);
        if(confirm){
            Intent intent = new Intent(context, CategoryActivity.class);
            startActivity(intent);
            CategoryActivity.this.finish();
            Toast.makeText(context, "Categoria registrada", Toast.LENGTH_SHORT).show();
            new InsertCategoryController(CategoryActivity.this).InsertDiffCat(etCategory.getText().toString());
        }else{
            Toast.makeText(context, "Categoria ya registrada", Toast.LENGTH_SHORT).show();
        }
    }
}
