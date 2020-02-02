package com.example.basics_of_web_and_mobile_application_development_project___android_part;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleViewHolder extends RecyclerView.ViewHolder {

    private TextView tvauthor;
    private TextView tvtitle;
    private TextView tvdescription;
    private TextView tvurl;
    private TextView tvurlToImage;
    private TextView tvpublishedAt;

    public ArticleViewHolder(@NonNull View itemView) {
        super(itemView);
        tvauthor =      itemView.findViewById(R.id.tvauthor);
        tvtitle =       itemView.findViewById(R.id.tvtitle);
        tvdescription = itemView.findViewById(R.id.tvdescription);
        tvurl =         itemView.findViewById(R.id.tvurl);
        tvurlToImage =  itemView.findViewById(R.id.tvurlToImage);
        tvpublishedAt = itemView.findViewById(R.id.tvpublishedAt);

    }

    public void setArticle(Article article)
    {
        tvauthor.setText(article.getAuthor());
        tvtitle.setText(article.getTitle());
        tvdescription.setText(article.getDescription());
        tvurl.setText(article.getUrl());
        tvurlToImage.setText(article.getUrlToImage());
        tvpublishedAt.setText(article.getPublishedAt());
    }

}
