package com.Presentation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
<<<<<<< HEAD
import android.widget.Button;
import android.widget.EditText;
=======
>>>>>>> a8d80371a55307a9aee903905841bd37dedbf865
import android.widget.TextView;
import android.widget.Toast;

import com.BusinessLogic.ScoreViewController;
import com.example.ahorcado.R;

public class ScoreActivity extends AppCompatActivity {

<<<<<<< HEAD
    TextView score;
    EditText email;
    Button btnScore;


=======
    TextView textView;
>>>>>>> a8d80371a55307a9aee903905841bd37dedbf865

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
<<<<<<< HEAD

        score = (TextView)findViewById(R.id.s_score);
        email = (EditText) findViewById(R.id.s_email);
        btnScore = (Button)findViewById(R.id.s_update);

        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ScoreViewController(ScoreActivity.this).viewScore(email.getText().toString());
            }
        });
=======
        final Bundle bundle = getIntent().getExtras();
        new ScoreViewController(ScoreActivity.this).viewScore(bundle.getString("email_user"));

    }

    public void nuevoIntent(int score, Context context) {
        System.out.println("*** context  " + context);
        TextView textView = findViewById(R.id.textView11);
        textView.setText(Integer.toString(score));
        //Toast.makeText(context, Integer.toString(score), Toast.LENGTH_SHORT).show();
>>>>>>> a8d80371a55307a9aee903905841bd37dedbf865
    }

    public void openMainActivity(View view){
        Intent openMainActivity = new Intent(ScoreActivity.this, MainActivity.class);
        startActivity(openMainActivity);
        finish();
    }
}
