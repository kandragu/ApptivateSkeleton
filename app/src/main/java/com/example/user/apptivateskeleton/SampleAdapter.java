package com.example.user.apptivateskeleton;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.apptivateskeleton.model.Flickr;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by user on 10/10/2015.
 */
public class SampleAdapter extends RecyclerView.Adapter<SampleViewHolder> {

    private static final String TAG = SampleAdapter.class.getSimpleName();
   // public static String data[] = new String[] {"1 List","2 List","3 List","4 List","5 List","6 List",
   //                                           "7 List","8 List","9 List","10 List","11 List","12 List"};

    private List<Flickr.Item> mItems;
    private Context mContext;

    public SampleAdapter(Context context,Flickr flickr) {
        mItems = flickr.getItems();
        mContext = context;
    }

    @Override
    public SampleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.browse,null);
        SampleViewHolder sampleViewHolder = new SampleViewHolder(view);
        return  sampleViewHolder;
    }

    @Override
    public void onBindViewHolder(SampleViewHolder sampleViewHolder, int i) {
    // Data is bind with the itemView
//        Log.v(TAG, "Processing:" + data[i] + "-->" + Integer.toString(i));
        String title = mItems.get(i).getTitle();
        String url =  mItems.get(i).getMedia().getM();

        sampleViewHolder.titleText.setText(title);


        Picasso.with(mContext)
                .load(url)
                .resize(180, 160)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .into(sampleViewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return mItems.size()-1;
    }
}
