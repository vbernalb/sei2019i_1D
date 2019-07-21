package com.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ahorcado.R;

public class FinishActivity extends AppCompatActivity {
    Button pointBtn,tryBtn, catBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        pointBtn= (Button)findViewById(R.id.points_btn);
        tryBtn = (Button)findViewById(R.id.try_btn);
        catBtn= (Button)findViewById(R.id.category_btn);

        pointBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent i = new Intent(FinishActivity.this, ScoreActivity.class);
                FinishActivity.this.startActivity(i);
                FinishActivity.this.finish();

            }
        });
        tryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        catBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent i = new Intent(FinishActivity.this, PlayActivity.class);
                FinishActivity.this.startActivity(i);
                FinishActivity.this.finish();
            }
        });
    }
}
