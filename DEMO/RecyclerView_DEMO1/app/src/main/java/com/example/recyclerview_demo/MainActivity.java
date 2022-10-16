package com.example.recyclerview_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private myAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //显示布局
        setContentView(R.layout.activity_main);

        //new 一个 RecyclerView
//        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView = findViewById(R.id.RLV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //需要数据
        itemLab itemLab = new itemLab();
        ArrayList<item> items = itemLab.getItemsLab();

        //设置控制器
        myAdapter = new myAdapter(items);
        recyclerView.setAdapter(myAdapter);

    }

    //ViewHolder
    private class myViewHolder extends RecyclerView.ViewHolder
    {
        private TextView textView;
        private ImageView imageView;
        private Button button;

        //为列表项显示布局（显示传入的itemView）
        public myViewHolder(@NonNull View itemView)
        {
            super(itemView);

            textView.findViewById(R.id.textView);
            imageView.findViewById(R.id.imageView);
            button.findViewById(R.id.Button);
        }
    }

    //Adapter
    private class myAdapter extends RecyclerView.Adapter<myViewHolder>
    {
        ArrayList<item> items;

        public myAdapter(ArrayList<item> items)
        {
            this.items = items;
        }

        @NonNull
        @Override
        public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            //布局加载器 将xml加载为VIew
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item,null,false);
            return new myViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull myViewHolder holder, int position)
        {
            itemLab itemLab = new itemLab();

            //绑定数据
            holder.textView.setText(itemLab.textID[position%3]);
            holder.imageView.setImageResource(itemLab.imageID[position%3]);
        }

        @Override
        public int getItemCount()
        {
            return items.size();
        }
    }

    private class itemLab
    {
        private ArrayList<item> items ;

        public itemLab()
        {
            items = new ArrayList<>();
            for (int i=0;i<100;i++)
            {
                item item = new item();
                items.add(item);
            }
        }

        public ArrayList<item> getItemsLab()
        {
            return items;
        }

        int[] textID = new int[] {R.string.text1, R.string.text2, R.string.text3};
        int[] imageID= new int[] {R.drawable.image1,R.drawable.image2,R.drawable.image3};

    }


}