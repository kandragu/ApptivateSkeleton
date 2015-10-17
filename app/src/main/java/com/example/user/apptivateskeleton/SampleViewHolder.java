package com.example.user.apptivateskeleton;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 10/10/2015.
 */
public class SampleViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView titleText;

    public SampleViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView)itemView.findViewById(R.id.thumbnail);
        titleText = (TextView)itemView.findViewById(R.id.titleText);
    }

}
