package com.example.ahmad.agrition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Hasilsearch extends AppCompatActivity implements Hasilsearchadapter.ItemClickListener{

    Hasilsearchadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasilsearch);

        String[] data = new String[50];
        double[] harga = new double[50];

        // data untuk recyclerview
        for (int i = 0; i < 50; i++) {
            data[i] = "Pupuk Padi Unggulan Cap Kuda";
            harga[i] = 120000;
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvNumbers);
        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new Hasilsearchadapter (this, data, harga);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked number " + adapter.getItem(position) + ", which is at cell position " + position);
        final Intent intent;
        final String trf = adapter.getItem(position);
        intent = new Intent(Hasilsearch.this, Detailproduk.class);
        intent.putExtra("Namaproduk",trf);
        intent.putExtra("Hargaproduk", String.valueOf(adapter.getHarga(position)));
        startActivity(intent);
    }
}
