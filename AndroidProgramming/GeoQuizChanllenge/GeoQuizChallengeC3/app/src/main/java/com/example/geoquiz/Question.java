package com.example.geoquiz;

public class Question
{
    private int mTextResId;
    private boolean mRightAnswer;
    private boolean mAnswered = false;

//    Text getter and setter
    public int getTextResId()
    { return mTextResId; }
    public void setTextResId(int textResId)
    { mTextResId = textResId; }

//    Answer getter and setter
    public boolean isRightAnswer()
    { return mRightAnswer; }
    public void setRightAnswer(boolean rightAnswer)
    { mRightAnswer = rightAnswer; }

//    this question have been answered
    public boolean isAnswered()
    { return mAnswered; }
    public void setAnswered(boolean answered)
    { mAnswered = answered; }

    public Question(int textResId, boolean rightAnswer)
    {
        mTextResId  = textResId;
        mRightAnswer = rightAnswer;
    }
}
