package com.Presentation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.BusinessLogic.ScoreViewController;
import com.example.ahorcado.R;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        final Bundle bundle = getIntent().getExtras();
        new ScoreViewController(ScoreActivity.this).viewScore(bundle.getString("email_user"));
    }

    public void nuevoIntent(int score, Context context) {
        System.out.println("*** context  " + context);
        Toast.makeText(context, score, Toast.LENGTH_SHORT).show();
    }
    
    public void openMainActivity(View view){
        Intent openMainActivity = new Intent(ScoreActivity.this, MainActivity.class);
        startActivity(openMainActivity);
    }
}
