package com.example.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.PathInterpolator;

import java.nio.file.Path;

public class MainActivity extends Activity {
    private CustomView mCustomView1;
    private CustomView mCustomView2;
    private CustomView mCustomView3;
    private CustomView mCustomView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.dispatchTouchEvent()/*activity*/
        ViewGroup viewGroup = new ViewGroup() {
            @Override
            protected void onLayout(boolean changed, int l, int t, int r, int b) {

            }
        }
        viewGroup.dispatchTouchEvent();

        mCustomView1 = findViewById(R.id.CustomView1);
        mCustomView2 = findViewById(R.id.CustomView2);
        mCustomView3 = findViewById(R.id.CustomView3);
        mCustomView4 = findViewById(R.id.CustomView4);

//        mCustomView.animate().rotation(90).setDuration(500);

        //方法四:anim文件
        //改变view位置却不改变参数位置
//        mCustomView.setAnimation(AnimationUtils.loadAnimation(this,R.anim.translate));
        //  属性动画
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mCustomView1, "translationX", 0,800);
        animator1.setDuration(2000);
        animator1.setInterpolator(new AnticipateOvershootInterpolator());

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mCustomView2, "translationX", 0, 800);
        animator2.setDuration(2000);
        animator2.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mCustomView3, "translationX", 0, 800);
        animator3.setDuration(2000);
        animator3.setInterpolator(new BounceInterpolator());

//不懂path的使用
//        Path path = new android.graphics.Path();
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(mCustomView4, "translationX", 0, 800);
        animator4.setDuration(2000);
        animator4.setInterpolator(new LinearInterpolator());

        AnimatorSet set = new AnimatorSet();
        set.play(animator1).with(animator2).with(animator3).after(animator4);
//        set.start();


//        //方法六:scroller
//        mCustomView1.smoothScrollTo(-400,0);


    }
}