package com.example.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class CheatActivity extends AppCompatActivity {

    private boolean mIsRightAnswer;

    private static final String EXTRA_ANSWER_IS_TURE =
            " com.example.geoquiz.answer_is_ture";

    public static Intent newIntent(Context packageContext, boolean answerIsTure)
    {
        Intent intent = new Intent(packageContext, CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TURE, answerIsTure);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mIsRightAnswer = getIntent().getBooleanArrayExtra(EXTRA_ANSWER_IS_TURE, false);
    }
}