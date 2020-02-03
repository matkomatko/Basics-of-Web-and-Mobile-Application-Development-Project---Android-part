package com.example.basics_of_web_and_mobile_application_development_project___android_part;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    static rvAdapter rva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecycler();
        //setupRecyclerData();

        FetchData process = new FetchData();
        process.execute();

    }

    public void customOnClick(View view){


        Intent i = new Intent(MainActivity.this, DetailedView.class);
        i.putExtra("tvauthorDV", ((Article)view.getTag()).getAuthor() );
        i.putExtra("tvtitleDV", ((Article)view.getTag()).getTitle() );
        i.putExtra("tvdescriptionDV", ((Article)view.getTag()).getDescription() );
        i.putExtra("tvurlDV", ((Article)view.getTag()).getUrl() );
        i.putExtra("tvurlToImageDV", ((Article)view.getTag()).getUrlToImage() );
        i.putExtra("tvpublishedAtDV", ((Article)view.getTag()).getPublishedAt() );

        startActivity(i);
    }

    private void setupRecycler()
    {
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rva = new rvAdapter();
        rv.setAdapter(rva);
    }

    private void setupRecyclerData()
    {

        List<Article> data = new ArrayList<>();
        Article article = new Article("","","","","","");
        data.add(article);


        rva.addData(data);
    }
}
