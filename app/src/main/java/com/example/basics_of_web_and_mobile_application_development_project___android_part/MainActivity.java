package com.example.basics_of_web_and_mobile_application_development_project___android_part;

import android.os.Bundle;

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

        /*
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FetchData process = new FetchData();
                process.execute();
            }
        });
        */


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
