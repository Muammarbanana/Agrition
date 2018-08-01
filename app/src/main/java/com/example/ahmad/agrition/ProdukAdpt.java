package com.example.ahmad.agrition;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 25/07/2018. 610101000326503
 */

public class ProdukAdpt extends RecyclerView.Adapter<ProdukAdpt.ViewHolder>{

    private Context context;
    private List<ProdukModel> list;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onClick(ProdukModel produkModel);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public ProdukAdpt(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void setList(List<ProdukModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.produk_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ProdukModel prdModel = list.get(position);
        holder.txView.setText(prdModel.getNamaBarang());
        holder.txView2.setText(String.valueOf(prdModel.getHargaBarang()));
        Glide.with(context).load(prdModel.getGambar()).into(holder.imgView);
        holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClick(prdModel);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cvItem;
        ImageView imgView;
        TextView txView,txView2;
        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            imgView = itemView.findViewById(R.id.gbrProduk);
            txView = itemView.findViewById(R.id.nmProduk);
            txView2 = itemView.findViewById(R.id.hargaPrd);
        }
    }
}
