package com.example.reueljohn.first;

import com.example.reueljohn.first.Model.Example;
import com.google.gson.Gson;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by reueljohn on 10/01/2018.
 */

public class UsersClient {



    static Retrofit getClient() {

        String BASE_URL = "https://jsonplaceholder.typicode.com";

        //OkHttpClient httpClient = new OkHttpClient.Builder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return retrofit;
    }
}
