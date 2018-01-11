package com.example.reueljohn.first;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by reueljohn on 22/12/2017.
 */

public class UserListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;
    private List<Photos> photos = Collections.emptyList();
    private LayoutInflater mInflater;

    public UserListAdapter(Context context, List<Photos> photos){
        this.context = context;
        mInflater = LayoutInflater.from(context);
        this.photos = photos;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.user_list, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Photos current = photos.get(position);
        ViewHolder myHolder = (ViewHolder) holder;
        myHolder.titleText.setText(current.title);
        myHolder.urlText.setText(current.url);



    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleText, urlText;

        public ViewHolder(View view){
            super(view);
            titleText = (TextView) view.findViewById(R.id.titleTxt);
            urlText = (TextView) view.findViewById(R.id.urlTxt);

        }
    }
}
