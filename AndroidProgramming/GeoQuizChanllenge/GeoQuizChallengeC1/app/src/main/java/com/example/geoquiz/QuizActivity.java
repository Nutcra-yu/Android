package com.example.geoquiz;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private Button mTureButton;
    private Button mFalseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mTureButton = (Button) findViewById(R.id.ture_button);
        mTureButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast t1 = Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_SHORT);
                t1.setGravity(Gravity.CENTER,0,0);
                t1.show();
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast t2 = Toast.makeText(QuizActivity.this, R.string.incorrect_toast,Toast.LENGTH_SHORT);
                t2.setGravity(Gravity.TOP|Gravity.CENTER,0,0);
                t2.show();
            }
        });

    }




}