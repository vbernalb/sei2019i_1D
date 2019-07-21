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

    public void openMenuAdminActivity(View view){
        Intent openMenuAdminActivity = new Intent(CategoryActivity.this, MenuAdminActivity.class);
        startActivity(openMenuAdminActivity);
        finishActivity(0);
    }
    public void nuevoIntent(boolean confirm, Context context){
        System.out.println("*** context  "+ context);
        System.out.println("*** confirm  "+ confirm);
        if(confirm){
            Toast.makeText(context, "Categoria registrada", Toast.LENGTH_SHORT).show();
            new InsertCategoryController(CategoryActivity.this).InsertDiffCat(etCategory.getText().toString());
        }else{
            Toast.makeText(context, "Categoria ya registrada", Toast.LENGTH_SHORT).show();
        }

    }

    public void nuevoIntent1(boolean confirm, Context context){
        etCategory = (EditText)findViewById(R.id.ca_category);
        if(confirm){
            Toast.makeText(context, "Palabra agregada", Toast.LENGTH_SHORT).show();
        }

    }
}
