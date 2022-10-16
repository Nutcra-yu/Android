package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context context;
    private

    List<GitHubRepo> Repos;

    public Adapter(Context context, List<GitHubRepo> repos) {
        this.context = context;
        Repos = repos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.RepoName.setText(Repos.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return Repos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView RepoName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            RepoName = itemView.findViewById(R.id.RepoName);
        }
    }
}
