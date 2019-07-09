package com.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.BusinessLogic.InsertCategoryController;
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

        final String category = etCategory.getText().toString();
        final InsertCategoryController cat = new InsertCategoryController(getApplicationContext());

        btnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cat.InsertCategory(category)){
                    Toast.makeText(getApplicationContext(), "Categoria registrada", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openMenuAdminActivity(View view){
        Intent openMenuAdminActivity = new Intent(CategoryActivity.this, MenuAdminActivity.class);
        startActivity(openMenuAdminActivity);
        finishActivity(0);
    }
}
