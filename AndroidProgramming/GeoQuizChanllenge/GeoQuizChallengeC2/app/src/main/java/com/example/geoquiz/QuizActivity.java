package com.example.geoquiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private Button mTureButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPrevButton;
    private ImageButton mNEXTButton;
    private ImageButton mPREVButton;
    private TextView mQuestionTextView;
    private int mCurrentIndex;

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
        setContentView(R.layout.activity_quiz);

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

       /**
        //Button version
        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mCurrentIndex = (mCurrentIndex + 1 ) % mQuestionBank.length;
                updateQuestion();
            }
        });
        mPrevButton = (Button) findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                mCurrentIndex = (mCurrentIndex + mQuestionBank.length- 1 ) % mQuestionBank.length;
                updateQuestion();
            }
        });
        */

       //ImageButton version
        mNEXTButton = (ImageButton) findViewById(R.id.next_button);
        mNEXTButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
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

        mQuestionTextView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mCurrentIndex = (mCurrentIndex + 1 ) % mQuestionBank.length;
                updateQuestion();

            }
        });

        updateQuestion();
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
            messageResId = R.string.correct_toast;
        else
            messageResId = R.string.incorrect_toast;

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }
}






























