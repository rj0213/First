package com.example.reueljohn.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.reueljohn.first.Model.Example;
import com.example.reueljohn.first.Old.Users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private List<Example> users = new ArrayList<>();
    private RecyclerView recyclerView;
    private UserListAdapter adapter;
    private UsersListAPI mUsersListAPI;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.userList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        mUsersListAPI = UsersClient.getClient().create(UsersListAPI.class);

        Call <List<Example>> call = mUsersListAPI.getUsers();
        call.enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
                adapter = new UserListAdapter(MainActivity.this,response.body());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {

            }
        });
        //new FetchData().execute();

    }
}
