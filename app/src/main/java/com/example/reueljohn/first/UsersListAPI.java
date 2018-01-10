package com.example.reueljohn.first;

import com.example.reueljohn.first.Model.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsersListAPI{

    @GET("users")
    Call <List<Example>> getUsers();
}
