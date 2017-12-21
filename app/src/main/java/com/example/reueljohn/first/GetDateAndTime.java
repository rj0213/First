package com.example.reueljohn.first;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by reueljohn on 21/12/2017.
 */

public class GetDateAndTime extends AsyncTask<String,Void,String> {

    private TextView mDate, mTime;

    public GetDateAndTime(TextView mDate, TextView mTime){
        this.mDate = mDate;
        this.mTime = mTime;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        String dateString = null;
        String timeString = null;
        try {

            JSONObject jsonObject = new JSONObject(s);
            dateString = jsonObject.getString("date");
            timeString = jsonObject.getString("time");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        mTime.setText(timeString);
        mDate.setText(dateString);
        return;

    }

    @Override
    protected String doInBackground(String... strings) {
        return MainActivity.connectToUrl();
    }
}
