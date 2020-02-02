package com.example.basics_of_web_and_mobile_application_development_project___android_part;

import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FetchData extends AsyncTask<Void,Void,Void> {

    String tv1 = "";
    String ParsedData = "";
    List<Article> data = new ArrayList<>();
    int articleCount = 2;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://newsapi.org/v2/top-headlines?country=us&pageSize=" + articleCount + "&apiKey=0f2a5abc1ac1464fafb1ba014d50e0ea");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line!=null) {
                line = bufferedReader.readLine();
                tv1 = tv1 + line;
            }

            JSONObject JO = new JSONObject(tv1);
            JSONArray JA = JO.getJSONArray("articles");

            for ( int i = 0; i < JA.length(); i++)
            {
                JSONObject tempJO = JA.getJSONObject(i);

                Article tempArticle = new Article("","","","","","");
                //problems with getting null - have to fix that
                tempArticle.setAuthor((String) tempJO.get("author"));
                tempArticle.setTitle((String) tempJO.get("title"));
                tempArticle.setDescription((String) tempJO.get("description"));
                tempArticle.setUrl((String) tempJO.get("url"));
                tempArticle.setUrlToImage((String) tempJO.get("urlToImage"));
                tempArticle.setPublishedAt((String) tempJO.get("publishedAt"));


                data.add(tempArticle);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);



        MainActivity.rva.addData(data);
        //MainActivity.tv1.setText(this.ParsedData);
    }
}
