package com.example.ahmad.agrition;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Toko extends Fragment {

    ProdukAdpt prdAdapter;
    RecyclerView rview;
    EditText et;

    public Toko() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        rview = v.findViewById(R.id.prdBaru);
        et = v.findViewById(R.id.etCari);
        prdAdapter = new ProdukAdpt(getContext());
        prdAdapter.setOnItemClickListener(new ProdukAdpt.OnItemClickListener() {
            @Override
            public void onClick(ProdukModel produkModel) {
                //Toast.makeText(getContext(), String.valueOf(produkModel.getHargaBarang()), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getActivity(),Detailproduk.class);
                i.putExtra("Hargaproduk",String.valueOf(produkModel.getHargaBarang()));
                i.putExtra("Namaproduk",produkModel.getNamaBarang());
                startActivity(i);
            }
        });
        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Hasilsearch.class);
                startActivity(i);
            }
        });
        rview.setHasFixedSize(true);
        rview.setLayoutManager(new GridLayoutManager(getContext(),2));
        rview.setAdapter(prdAdapter);
        setProduk();
        return v;

    }

    private void setProduk() {
        List<ProdukModel> list = new ArrayList<>();
        ProdukModel produk1 = new ProdukModel(R.drawable.sawah,"Padi",2000000);
        ProdukModel produk2 = new ProdukModel(R.drawable.sawah,"Padi",2000000);
        ProdukModel produk3 = new ProdukModel(R.drawable.sawah,"Padi",2000000);
        ProdukModel produk4 = new ProdukModel(R.drawable.sawah,"Padi",2000000);
        ProdukModel produk5 = new ProdukModel(R.drawable.sawah,"Padi",2000000);
        ProdukModel produk6 = new ProdukModel(R.drawable.sawah,"Padi",2000000);
        ProdukModel produk7 = new ProdukModel(R.drawable.sawah,"Padi",2000000);
        ProdukModel produk8 = new ProdukModel(R.drawable.sawah,"Padi",2000000);
        ProdukModel produk9 = new ProdukModel(R.drawable.sawah,"Padi",2000000);
        ProdukModel produk10 = new ProdukModel(R.drawable.sawah,"Padi",2000000);

        list.add(0,produk1);
        list.add(1,produk2);
        list.add(2,produk3);
        list.add(3,produk4);
        list.add(4,produk5);
        list.add(5,produk6);
        list.add(6,produk7);
        list.add(7,produk8);
        list.add(8,produk9);
        list.add(9,produk10);
        prdAdapter.setList(list);
    }

}
