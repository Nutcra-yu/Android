package com.example.geoquiz;

public class Question
{
    private int mTextResId;
    private boolean mRightAnswer;

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

    public Question(int textResId, boolean rightAnswer)
    {
        mTextResId  = textResId;
        mRightAnswer = rightAnswer;
    }
}
