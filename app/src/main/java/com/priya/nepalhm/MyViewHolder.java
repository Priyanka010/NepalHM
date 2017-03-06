package com.priya.nepalhm;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by priyanka on 12/19/16.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    CardView cv;
    TextView title;


    MyViewHolder(View itemView) {
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cardView);
        title = (TextView) itemView.findViewById(R.id.title);

    }
}
