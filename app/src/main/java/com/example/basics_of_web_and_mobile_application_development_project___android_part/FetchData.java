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
    int articleCount = 20;

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

            for (int i = 0; i < JA.length(); i++)
            {
                JSONObject tempJO = JA.getJSONObject(i);

                Article tempArticle = new Article("","","","","","");

                if(tempJO.isNull("author")  || tempJO.get("author") == "")tempArticle.setAuthor("Author: Unknown");
                else tempArticle.setAuthor("Author: " + (String) tempJO.get("author"));

                if(tempJO.isNull("title")  || tempJO.get("title") == "")tempArticle.setTitle("Unknown");
                else tempArticle.setTitle((String) tempJO.get("title"));

                if(tempJO.isNull("description")  || tempJO.get("description") == "")tempArticle.setDescription("Unknown");
                else tempArticle.setDescription((String) tempJO.get("description"));

                if(tempJO.isNull("url")  || tempJO.get("url") == "")tempArticle.setUrl("You can read more here Unknown");
                else tempArticle.setUrl("You can read more here " + (String) tempJO.get("url"));

                if(tempJO.isNull("urlToImage")  || tempJO.get("urlToImage") == "")tempArticle.setUrlToImage("Unknown");
                else tempArticle.setUrlToImage((String) tempJO.get("urlToImage"));

                if(tempJO.isNull("publishedAt")  || tempJO.get("publishedAt") == "")tempArticle.setPublishedAt("Published at: Unknown");
                else tempArticle.setPublishedAt("Published at: " + ((String) tempJO.get("publishedAt")).replace('T',' ').replace('Z',' '));



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
