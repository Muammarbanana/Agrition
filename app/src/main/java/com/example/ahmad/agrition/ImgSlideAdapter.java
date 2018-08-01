package com.example.ahmad.agrition;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by ASUS on 23/07/2018.
 */

public class ImgSlideAdapter extends RecyclerView.Adapter<ImgSlideAdapter.ViewHolder> {

    private Context context;
    private List<Integer> list;

    public ImgSlideAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<Integer> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slide,parent,false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int image = list.get(position);
        Glide.with(context).load(image).into(holder.imView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imView;

        public ViewHolder(View itemView) {
            super(itemView);
            imView = itemView.findViewById(R.id.imView);
        }
    }
}
