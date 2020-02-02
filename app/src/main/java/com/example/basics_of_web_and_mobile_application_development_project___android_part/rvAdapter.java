package com.example.basics_of_web_and_mobile_application_development_project___android_part;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class rvAdapter extends RecyclerView.Adapter<ArticleViewHolder>{

    private List<Article> dataList = new ArrayList<>();

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cellView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell,parent,false);
        return new ArticleViewHolder(cellView);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.setArticle(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addData(List<Article> data){
        this.dataList.clear();
        this.dataList.addAll(data);
        notifyDataSetChanged();
    }
}
