package com.Presentation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.BusinessLogic.ScoreViewController;
import com.example.ahorcado.R;

public class ScoreActivity extends AppCompatActivity {

    TextView score;
    EditText email;
    Button btnScore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        score = (TextView)findViewById(R.id.s_score);
        email = (EditText) findViewById(R.id.s_email);
        btnScore = (Button)findViewById(R.id.s_update);

        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ScoreViewController(ScoreActivity.this).viewScore(email.getText().toString());
            }
        });
    }

    public void openMainActivity(View view){
        Intent openMainActivity = new Intent(ScoreActivity.this, MainActivity.class);
        startActivity(openMainActivity);
        finish();
    }
}
