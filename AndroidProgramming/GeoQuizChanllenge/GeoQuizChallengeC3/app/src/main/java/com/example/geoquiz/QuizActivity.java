package com.example.geoquiz;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private static final String TAG = "QuizActivity";

    private static final String KEY_INDEX = "index";

    private Button mTureButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPrevButton;
    private Button mRedoButton;
    private ImageButton mNEXTButton;
    private ImageButton mPREVButton;
    private TextView mQuestionTextView;
    private int mCurrentIndex;
    private int mScore;
    private float mPoint;


    private Question[] mQuestionBank = new Question[]
    {
        new Question(R.string.question_oceans,true),
        new Question(R.string.question_americas,true),
        new Question(R.string.question_asia,true),
        new Question(R.string.question_australia,true),
        new Question(R.string.question_mideast,false),
        new Question(R.string.question_africa,false),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        setContentView(R.layout.activity_quiz);

        if(savedInstanceState != null)
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX);

//        textview
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mQuestionTextView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mCurrentIndex = (mCurrentIndex + 1 ) % mQuestionBank.length;
                updateQuestion();

            }
        });
//        judge button
        mTureButton = (Button) findViewById(R.id.ture_button);
        mTureButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(mQuestionBank[mCurrentIndex].isAnswered() == false)
                { checkAnswer(true); }
                else
                { haveBeenAnswered(); }

                mQuestionBank[mCurrentIndex].setAnswered(true);
            }
        });
        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(mQuestionBank[mCurrentIndex].isAnswered() == false)
                { checkAnswer(false); }
                else
                { haveBeenAnswered(); }

                mQuestionBank[mCurrentIndex].setAnswered(true);
            }
        });
//        next and prev ImageButton version
        mNEXTButton = (ImageButton) findViewById(R.id.next_button);
        mNEXTButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(mCurrentIndex+1 == mQuestionBank.length)
                {
                    Toast toast = Toast.makeText(QuizActivity.this,point(),Toast.LENGTH_SHORT);
                    toast.show();
                }
                mCurrentIndex = (mCurrentIndex + 1 ) % mQuestionBank.length;
                updateQuestion();
            }
        });
        mPREVButton = (ImageButton) findViewById(R.id.prev_button);
        mPREVButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mCurrentIndex = (mCurrentIndex + mQuestionBank.length- 1 ) % mQuestionBank.length;
                updateQuestion();
            }
        });
//        redo button
        mRedoButton = (Button) findViewById(R.id.redo_button);
        mRedoButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                redoAll();
            }
        });

        updateQuestion();
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        Log.e(TAG, "onStart");
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        Log.e(TAG, "onStop");
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        Log.e(TAG, "onResume");
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState)
    {
        super.onSaveInstanceState(saveInstanceState);
        Log.d(TAG,"onSaveInstanceState");
        saveInstanceState.putInt(KEY_INDEX,mCurrentIndex);
    }

    private void updateQuestion()
    {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressed)
    {
        boolean RightAnswer = mQuestionBank[mCurrentIndex].isRightAnswer();

        int messageResId = 0;

        if(userPressed == RightAnswer)
        {
            messageResId = R.string.correct_toast;
            mScore ++;
        }
        else
            messageResId = R.string.incorrect_toast;

        Toast.makeText(this, messageResId,200 ).show();
    }
    private void haveBeenAnswered()
    {
        Toast.makeText(this,R.string.BeenAnswered_toast,Toast.LENGTH_SHORT).show();
    }
    private void redoAll()
    {
        for(Question a :mQuestionBank)
        {
            a.setAnswered(false);
        }
    }
    private String point()
    {
        Float point ;
        point = Float.valueOf(mScore/(mQuestionBank.length));
        return point.toString()+"%";
    }

}






























