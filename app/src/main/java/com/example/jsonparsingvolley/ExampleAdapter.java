package com.example.jsonparsingvolley;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    Context mContext;
    ArrayList<ExampleItem> mExampleList;

    public ExampleAdapter(Context context, ArrayList<ExampleItem>exampleList){
        mContext = context;
        mExampleList=exampleList;
    }

    @Override
    public ExampleAdapter.ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        ExampleItem currentItem=mExampleList.get(position);
        String imageurl=currentItem.getImageUrl();
        String creatorName=currentItem.getCreator();
        int likes=currentItem.getLikes();

        holder.creator.setText(creatorName);
        holder.likes.setText("Likes: "+likes);
        Picasso.get().load(imageurl).fit().centerInside().into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView creator;
        TextView likes;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.image);
            creator = (TextView)itemView.findViewById(R.id.text_view_creator);
            likes = (TextView)itemView.findViewById(R.id.text_view_likes);
        }
    }
}


