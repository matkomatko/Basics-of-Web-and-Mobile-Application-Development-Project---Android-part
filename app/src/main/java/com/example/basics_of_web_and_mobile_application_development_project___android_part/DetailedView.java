package com.example.basics_of_web_and_mobile_application_development_project___android_part;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class DetailedView extends AppCompatActivity {

    TextView tvauthorDV;
    TextView tvpublishedAtDV;
    TextView tvtitleDV;
    ImageView ivDV;
    TextView tvdescriptionDV;
    TextView tvurlDV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_view);

        Intent intent = getIntent();

        tvauthorDV = findViewById(R.id.tvauthorDV);
        tvpublishedAtDV = findViewById(R.id.tvpublishedAtDV);
        tvtitleDV = findViewById(R.id.tvtitleDV);
        ivDV = findViewById(R.id.ivDV);
        tvdescriptionDV = findViewById(R.id.tvdescriptionDV);
        tvurlDV = findViewById(R.id.tvurlDV);

        tvauthorDV.setText(intent.getStringExtra("tvauthorDV"));
        tvpublishedAtDV.setText(intent.getStringExtra("tvpublishedAtDV"));
        tvtitleDV.setText(intent.getStringExtra("tvtitleDV"));
        Picasso.get().load(intent.getStringExtra("tvurlToImageDV")).into(ivDV);
        tvdescriptionDV.setText(intent.getStringExtra("tvdescriptionDV"));
        tvurlDV.setText(intent.getStringExtra("tvurlDV"));

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent i = new Intent(this, MainActivity.class);
        startActivityForResult(i, 0);
        return true;
    }

}
