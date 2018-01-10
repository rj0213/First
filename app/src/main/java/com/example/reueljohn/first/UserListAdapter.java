package com.example.reueljohn.first;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.reueljohn.first.Model.Example;
import com.example.reueljohn.first.Old.Users;

import java.util.Collections;
import java.util.List;

import retrofit2.Callback;

/**
 * Created by reueljohn on 22/12/2017.
 */

public class UserListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;
    private List<Example> users;
    private LayoutInflater mInflater;


    public UserListAdapter(Context context, List<Example> users){
        mInflater = LayoutInflater.from(context);
        this.users = users;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.user_list, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Example current = users.get(position);
        ViewHolder myHolder = (ViewHolder) holder;
        myHolder.nameText.setText(current.getName());
        myHolder.usernameText.setText(current.getUsername());
        myHolder.addressText.setText(current.getAddress().getCity());
        myHolder.companyText.setText(current.getCompany().getName());


    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameText, usernameText, addressText,companyText;

        public ViewHolder(View view){
            super(view);
            nameText = (TextView) view.findViewById(R.id.name);
            usernameText = (TextView) view.findViewById(R.id.username);
            addressText = (TextView) view.findViewById(R.id.address);
            companyText = (TextView) view.findViewById(R.id.company);
        }
    }
}
