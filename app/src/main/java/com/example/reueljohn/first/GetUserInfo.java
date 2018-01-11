package com.example.reueljohn.first;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reueljohn on 21/12/2017.
 */

public class GetUserInfo extends AsyncTask<String, String, String> {

    //private TextView nameText, usernameText, addressText, companyText;

    private List<Photos> photos = new ArrayList<>();
    private Activity activity;
    private RecyclerView recyclerView;
    private UserListAdapter adapter;

    public GetUserInfo(Activity activity){
        this.activity = activity;
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONArray photosArray = new JSONArray(s);
            for (int i = 0; i < photosArray.length(); i++){
                JSONObject photoNum = photosArray.getJSONObject(i);
                //JSONObject photoURL = photoNum.getJSONObject("url");
                Photos newPhoto = new Photos();

                newPhoto.title = photoNum.getString("title");
                newPhoto.url = photoNum.getString("url");

                photos.add(newPhoto);

            }

            recyclerView = (RecyclerView) activity.findViewById(R.id.userList);
            adapter = new UserListAdapter(activity, photos);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(activity));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected String doInBackground(String... strings) {
        return NetworkConnect.getUsers();
    }
}
