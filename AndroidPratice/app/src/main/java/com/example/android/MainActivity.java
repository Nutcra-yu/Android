package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

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
    private TextView checked_TView;
    private String checked_Text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                    /*控件练习*/
        //TextView
        //EditText
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
        //button
        btn_one = (Button) findViewById(R.id.btn1);
        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_one.setText("按钮1已被点击");
            }
        });
        //checkbox
        CheckBox CBox_one = (CheckBox) findViewById(R.id.CBox1);
        CheckBox CBox_two = (CheckBox) findViewById(R.id.CBox2);
        CheckBox CBox_three = (CheckBox) findViewById(R.id.CBox3);
        CBox_one.setOnCheckedChangeListener(this);
        CBox_two.setOnCheckedChangeListener(this);
        CBox_three.setOnCheckedChangeListener(this);
        checked_TView = (TextView) findViewById(R.id.CBox_TView);
        checked_Text = new String();

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
    {
        String gender = buttonView.getText().toString();
        if (isChecked)
        {
            if (!checked_Text.contains(gender))
            {
                checked_Text = checked_Text + gender + " ";
                checked_TView.setText(checked_Text);
            }
        }
        else
        {
            if(checked_Text.contains(gender))
            {
                checked_Text = checked_Text.replace(gender+" ","");
                checked_TView.setText(checked_Text);
            }
        }
    }

}