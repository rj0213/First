package com.example.reueljohn.first;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

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

public class GetUserInfo extends AsyncTask<String, Void, String> {

    //private TextView nameText, usernameText, addressText, companyText;


    private RecyclerView recyclerView;
    private UserListAdapter adapter;
    private Context context;

    public GetUserInfo(Context context){
        this.context = context;
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        List<Users> users = new ArrayList<>();
        try {
            JSONArray usersArray = new JSONArray(s);
            for(int i = 0; i < usersArray.length(); i++){
                JSONObject user = usersArray.getJSONObject(i);
                JSONObject jAddress = user.getJSONObject("address");
                JSONObject jCompany = user.getJSONObject("company");
                try {
                    Users newUser = new Users();
                    newUser.setName(user.getString("name"));
                    newUser.setUsername(user.getString("username"));
                    newUser.setStreet(jAddress.getString("street"));
                    newUser.setCity(jAddress.getString("city"));
                    newUser.setCompany(jCompany.getString("name"));
                    users.add(newUser);
                }

                catch (Exception e){
                    e.printStackTrace();
                }
            }

            recyclerView = (RecyclerView) recyclerView.findViewById(R.id.recyclerview);
            adapter = new UserListAdapter(context, users);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected String doInBackground(String... strings) {
        return NetworkConnect.getUsers();
    }
}
