package com.example.reueljohn.first;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

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

public class MainActivity extends AppCompatActivity {


    private List<Users> users = new ArrayList<>();
    private RecyclerView recyclerView;
    private UserListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new FetchData().execute();

    }

    private class FetchData extends AsyncTask<String,String ,String>{

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONArray usersArray = new JSONArray(s);
                for (int i = 0; i < usersArray.length(); i++) {
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

                recyclerView = (RecyclerView) findViewById(R.id.userList);
                adapter = new UserListAdapter(MainActivity.this, users);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(String... strings) {
            return NetworkConnect.getUsers();
        }
    }
}
