package com.example.androidpractice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SecondFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private Adapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.fragment_second, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView1);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        updateUI();

        ItemLab itemLab = new ItemLab(getActivity());
        List<Item> items = itemLab.getItems();

        mAdapter = new Adapter(items);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    private void updateUI()
    {
//        ItemLab itemLab = ItemLab.get(getActivity());
        ItemLab itemLab = new ItemLab(getActivity());
        List<Item> items = itemLab.getItems();

        mAdapter = new Adapter(items);
        mRecyclerView.setAdapter(mAdapter);

    }

    private class myViewHolder extends RecyclerView.ViewHolder
    {

        private TextView mTextView1;

        public myViewHolder(LayoutInflater inflater, ViewGroup parent)
        {
            super(inflater.inflate(R.layout.item, parent, false));

            mTextView1 = (TextView) itemView.findViewById(R.id.textView);
        }

    }

    private class Adapter extends RecyclerView.Adapter<myViewHolder>
    {
        private List<Item> mItems;

        public Adapter(List<Item> items) {
            mItems = items;
        }

        @NonNull
        @Override
        public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new myViewHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull myViewHolder holder, int position)
        {
//            Item item = mItems.get(position);
            holder.mTextView1.setText("  ???");
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }
    }
}
