package com.example.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    public static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";
    public static final int REQUEST_CODE_CHEAT = 0;

    private Button mTureButton;
    private Button mFalseButton;
    private Button mCheatButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
    private int mCurrentIndex = 0;
    private boolean mIsCheater;

    private Question[] mQuestionBank = new Question[]
    {
        new Question(R.string.question_mideast,false),
        new Question(R.string.question_australia,true),
        new Question(R.string.question_oceans,true),
        new Question(R.string.question_americas,true),
        new Question(R.string.question_asia,true),
        new Question(R.string.question_africa,false),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate(Bundle) called");
        setContentView(R.layout.activity_quiz);

        if(savedInstanceState != null)
        {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        mTureButton = (Button) findViewById(R.id.ture_button);
        mTureButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                checkAnswer(true);
            }
        });
        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                checkAnswer(false);
            }
        });
        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mCurrentIndex = (mCurrentIndex + 1 ) % mQuestionBank.length;
                mIsCheater = false;
                updateQuestion();
            }
        });
        mCheatButton = (Button)findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
//                start CheatActivity
                //Intent intent = new Intent(QuizActivity.this, CheatActivity.class);
                boolean RightAnswer = mQuestionBank[mCurrentIndex].isRightAnswer();
                Intent intent = CheatActivity.newIntent(QuizActivity.this, RightAnswer);
//                startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE_CHEAT);
            }
        });

        updateQuestion();
    }


    protected void onAcitivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode != Activity.RESULT_OK)   return;
        if(requestCode == REQUEST_CODE_CHEAT)
        {
            if (data == null)   return;
            mIsCheater = CheatActivity.wasAnswerShown(data);
        }
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX,mCurrentIndex);
    }
    private void updateQuestion()
    {
//        Log.d(TAG,"Updating question text",new Exception());
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }
    private void checkAnswer(boolean userPressed)
    {
        boolean RightAnswer = mQuestionBank[mCurrentIndex].isRightAnswer();

        int messageResId = 0;

        if (mIsCheater)
        {
            messageResId = R.string.judgement_toast;
        } else {
            if (userPressed == RightAnswer)
                messageResId = R.string.correct_toast;
            else
                messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }
}






























