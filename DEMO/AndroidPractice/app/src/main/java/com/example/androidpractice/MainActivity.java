package com.example.androidpractice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    //RadioGroup
    private RadioGroup rGroup_one;
    private TextView rGroup_TView;
    //button
    private Button btn_one;
    //checkbox
    private TextView CBox_TView;
    private String CBox_text;
    //star
    private Button Star;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                                     /*控件练习*/
        //TextView
        //EditText 1
        //EditText 2
        //RadioGroup
        rGroup_one = (RadioGroup) findViewById(R.id.RGroup1);
        rGroup_one.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                     if( i == R.id.RBtn1)    rGroup_TView.setText("您的性别是：男");
                else if( i == R.id.RBtn2)    rGroup_TView.setText("您的性别是：女");
                else if( i == R.id.RBtn3)    rGroup_TView.setText("您的性别是：？？");
            }
        });
        rGroup_TView = (TextView) findViewById(R.id.RGroup_TView);
        //checkbox
        CheckBox CBox_one = (CheckBox) findViewById(R.id.CBox1);
        CheckBox CBox_two = (CheckBox) findViewById(R.id.CBox2);
        CheckBox CBox_three = (CheckBox) findViewById(R.id.CBox3);
        CBox_one.setOnCheckedChangeListener(this);
        CBox_two.setOnCheckedChangeListener(this);
        CBox_three.setOnCheckedChangeListener(this);
        CBox_TView = (TextView) findViewById(R.id.CBox_TView);
        CBox_text = new String();
        //button
        btn_one = (Button) findViewById(R.id.btn1);
        btn_one.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                btn_one.setText("按钮1已被点击");
            }
        });
        //star
        Star = findViewById(R.id.star);
        Star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i == 0){
                    i=1;
                }else{
                    i=0;
                }

                if (i == 1){
                    Star.setBackground(getDrawable(R.drawable.star_solid));
                }else{
                    Star.setBackground(getDrawable(R.drawable.stat_hollow));
                }
            }
        });

    }

    //CheckBox
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
    {
        String gender = buttonView.getText().toString();
        if (isChecked)
        {
            if (!CBox_text.contains(gender))
            {
                CBox_text = CBox_text + gender + " ";
                CBox_TView.setText(CBox_text);
            }
        }
        else
        {
            if(CBox_text.contains(gender))
            {
                CBox_text = CBox_text.replace(gender+" ","");
                CBox_TView.setText(CBox_text);
            }
        }
    }
    //AlertDialog
    @Override
    public void onBackPressed() {
        AlertDialog dialog_one;
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("军帐内")              //标题
                .setIcon(R.mipmap.ic_launcher)      //图标
                .setMessage("啊哈哈哈哈哈哈哈\n\t\t   鸡汤来喽")         //提示信息
                .setPositiveButton("我是大R本高级双料特工 穿山甲", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        //关闭对话框
//                        dialogInterface.dismiss();
                        //关闭MainActivity
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("喝，怎么不喝", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        dialog_one = builder.create();
        dialog_one.show();
    }
}