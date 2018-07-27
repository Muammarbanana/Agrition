package com.example.ahmad.agrition;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Hasilsearchadapter extends RecyclerView.Adapter<Hasilsearchadapter.ViewHolder> {

    private String[] mData = new String[0];
    private double[] mharga = new double[0];
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    Hasilsearchadapter(Context context, String[] data, double[] harga){
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mharga = harga;
    }

    @Override
    public Hasilsearchadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.hasilsearch_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.myTextView.setText(mData[position]);
        NumberFormat formatter = new DecimalFormat("###,###");
        String formattedharga = String.valueOf(formatter.format(mharga[position]));
        holder.mhargaku.setText(formattedharga);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView myTextView;
        public TextView mhargaku;

        public ViewHolder(View itemView) {
            super(itemView);
            myTextView = (TextView) itemView.findViewById(R.id.text);
            mhargaku = (TextView) itemView.findViewById(R.id.hargabarang);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public String getItem(int id) {
        return mData[id];
    }
    public double getHarga(int id) {return mharga[id];}

    // supaya bisa diklik
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
