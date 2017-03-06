package com.priya.nepalhm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import static com.priya.nepalhm.Secondlist.KEY_LIST_TYPE;



public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<String> list;
    private Context context;

    public RecyclerViewAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        return new MyViewHolder(LayoutInflater.from(
                        parent.getContext()).inflate(R.layout.item_card, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        final String name = list.get(position);
        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.title.setText(name);
        final View itemView = holder.itemView;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(itemView.getContext(),Secondlist.class);
                Bundle bundle = new  Bundle();
                bundle.putString(KEY_LIST_TYPE, name);
                intent.putExtras(bundle);
                itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, String data) {
        list.add(position,data);
        notifyItemInserted(position);
    }


    public void remove(String data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }

}