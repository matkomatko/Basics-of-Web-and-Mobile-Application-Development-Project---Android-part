package com.example.basics_of_web_and_mobile_application_development_project___android_part;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchData extends AsyncTask<Void,Void,Void> {

    String tv1 = "";
    String ParsedData = "";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://newsapi.org/v2/top-headlines?country=us&apiKey=0f2a5abc1ac1464fafb1ba014d50e0ea");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line!=null) {
                line = bufferedReader.readLine();
                tv1 = tv1 + line;
            }

            JSONObject JO = new JSONObject(tv1);
            ParsedData = "status: " + JO.get("status");


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

        MainActivity.tv1.setText(this.ParsedData);
    }
}
