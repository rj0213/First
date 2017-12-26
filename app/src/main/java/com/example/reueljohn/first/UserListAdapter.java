package com.example.reueljohn.first;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by reueljohn on 22/12/2017.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {


    private Context context;
    private List<Users> users = new ArrayList<>();
    private LayoutInflater mInflater;

    public UserListAdapter(Context context, List<Users> users){
        this.context = context;
        mInflater = LayoutInflater.from(context);
        this.users = users;

    }

    @Override
    public UserListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.user_list, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserListAdapter.ViewHolder holder, int position) {

        Users current = users.get(position);
        ViewHolder myHolder = (ViewHolder) holder;
        myHolder.nameText.setText(current.getName());
        myHolder.usernameText.setText(current.getUsername());
        myHolder.addressText.setText(current.getStreet() + " " + current.getCity());
        myHolder.companyText.setText(current.getCompany());


    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

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
