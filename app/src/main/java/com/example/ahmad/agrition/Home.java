package com.example.ahmad.agrition;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {

    RecyclerView rview,rview2;
    ImgSlideAdapter adapter;
    ProdukAdpt prdAdapter;
    EditText et;

    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        rview = v.findViewById(R.id.gbrGeser);
        et = v.findViewById(R.id.etCari);
        adapter = new ImgSlideAdapter(getContext());
        rview.setHasFixedSize(true);
        rview.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        rview.setAdapter(adapter);
        setImage();
        rview2 = v.findViewById(R.id.prdBaru);
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
        rview2.setHasFixedSize(true);
        rview2.setLayoutManager(new GridLayoutManager(getContext(),2));
        rview2.setAdapter(prdAdapter);
        setProduk();
        return v;
    }

    private void setImage() {
        List<Integer> list = new ArrayList<>();
        list.add(0,R.drawable.sawah);
        list.add(1,R.drawable.sawah);
        list.add(2,R.drawable.sawah);
        adapter.setList(list);
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
