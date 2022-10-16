package com.example.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CustomView extends View {

    private int lastX;
    private int lastY;
    private Scroller mScroller;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    //方法六:平滑移动
    @Override
    public void computeScroll() {
        super.computeScroll();
        if(mScroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            invalidate();
        }
    }
    public void smoothScrollTo(int destX,int destY){
        int scrollX = getScrollX();
        int delta = destX-scrollX;
        mScroller.startScroll(scrollX,0,delta,0,5000);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //x,y是相对当前控件的 既以控件的左上角为（0，0）
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()){
            //ACTION_DOWN:点击控件
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            //ACTION_MOVE:手势移动
            case MotionEvent.ACTION_MOVE:
                //偏移量offsetX = 实时x - 点击时的x
                int offsetX = x - lastX;
                int offsetY = y - lastY;

                //方法一:layout
                layout(getLeft()+offsetX,getTop()+offsetY,getRight()+offsetX,getBottom()+offsetY);
//
//                //方法二:offset
//                offsetLeftAndRight(offsetX);
//                offsetTopAndBottom(offsetY);
//                break;
//
//                //方法三:LayoutParam
//                //？？？失效？？
//                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
//                layoutParams.leftMargin = getLeft() + offsetX;
//                layoutParams.topMargin = getTop() + offsetY;
//                setLayoutParams(layoutParams);
//
//                //方法四：动画Animation
//                //（见MainActivity）
//
//                //方法五；（对画布使用）scrollTo scrollBy
//                ((View)getParent()).scrollBy(-offsetX,-offsetY);
//
//                //方法六:CustomView使用Scroller


            //ACTION_UP:手指松开
            case MotionEvent.ACTION_UP:
                layout(getLeft(),getTop(),getLeft()+getWidth(),getTop()+getHeight());
                break;
        }

        return true;
    }
}
