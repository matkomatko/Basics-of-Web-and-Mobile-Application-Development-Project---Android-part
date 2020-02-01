package com.example.basics_of_web_and_mobile_application_development_project___android_part;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static TextView tv1;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.tv1);
        btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FetchData process = new FetchData();
                process.execute();
            }
        });

    }




        //String url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=0f2a5abc1ac1464fafb1ba014d50e0ea";



}
