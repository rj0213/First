package com.example.reueljohn.first;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by reueljohn on 21/12/2017.
 */

public class GetUserInfo extends AsyncTask<String, String, String> {

    //private TextView nameText, usernameText, addressText, companyText;

    private List<Users> users = new ArrayList<>();
    private Context context;


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONArray usersArray = new JSONArray(s);
            for (int i = 0; i < usersArray.length(); i++){
                JSONObject user = usersArray.getJSONObject(i);
                JSONObject jAddress = user.getJSONObject("address");
                JSONObject jCompany = user.getJSONObject("company");
                Users newUser = new Users();

                newUser.name = user.getString("name");
                newUser.username = user.getString("username");
                newUser.street = jAddress.getString("street");
                newUser.city = jAddress.getString("city");
                newUser.company = jCompany.getString("name");

                users.add(newUser);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        /* try {
            JSONArray usersArray = new JSONArray(s);
            for(int i = 0; i < usersArray.length(); i++) {
                JSONObject user = usersArray.getJSONObject(i);
                *//*JSONObject jAddress = user.getJSONObject("address");
                JSONObject jCompany = user.getJSONObject("company");*//*
                Users newUser = new Users();
                newUser.name = user.getString("name");
                newUser.username = user.getString("username");
               *//* newUser.street = jAddress.getString("street");
                newUser.city = jAddress.getString("city");
                newUser.company = jCompany.getString("name");*//*
                users.add(newUser);
                return;
            }
        } catch (Exception e){
            e.printStackTrace();
            Log.d("b", "NOT WORKING");
        }*/
    }


    @Override
    protected String doInBackground(String... strings) {
        return NetworkConnect.getUsers();
    }
}
