package com.example.trending;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.internal.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView RLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RLV  = findViewById(R.id.RLV);
        MyAdapter myadapter = new MyAdapter();
        RLV.setAdapter(myadapter);

        Button btn ;
        A a = new A();
        View.OnClickListener onClickListener = a;

        btn.setOnClickListener(onClickListener);

//        View.OnClickListener onClickListener = new A();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }


}

//将实现某一接口的类创建的对象的引用
//        赋值给该接口声明的接口变量
//        那么该接口变量就可以使用被类实现的接口方法
class A implements View.OnClickListener{

    @Override
    public void onClick(View v) {

    }
}