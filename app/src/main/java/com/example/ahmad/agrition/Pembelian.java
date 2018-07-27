package com.example.ahmad.agrition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Pembelian extends AppCompatActivity {

    ImageButton tombolbalik,tombolkurang,tomboltambah;
    TextView htproduk,ongkir,total,jumlah;
    private int jml = 1;
    private double tot = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembelian);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        final NumberFormat formatter = new DecimalFormat("###,###");

        final Intent intent = getIntent();
        String temp = intent.getStringExtra("Harga");

        tombolbalik = findViewById(R.id.btnbackbeli);
        htproduk = findViewById(R.id.pembelian_nominalhargaproduk);
        ongkir = findViewById(R.id.pembelian_nominalogistik);
        total = findViewById(R.id.pembelian_nominalsemua);
        tombolkurang = findViewById(R.id.tombolkurang);
        tomboltambah = findViewById(R.id.tomboltambah);
        jumlah = findViewById(R.id.pembelian_jumlahbarang);

        final double beaongkir = 11000;
        final double angka = Double.parseDouble(temp);
        tot = angka;

        htproduk.setText("Rp. "+formatter.format(tot));
        ongkir.setText("Rp. "+formatter.format(beaongkir));
        total.setText("Rp. "+formatter.format(tot+beaongkir));
        tombolbalik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        tombolkurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jml==1){
                    jumlah.setText("1");
                }else{
                    jumlah.setText(String.valueOf(jml-1));
                    jml = jml-1;
                    tot = angka*jml;
                    htproduk.setText("Rp. "+formatter.format(tot));
                    total.setText("Rp. "+formatter.format(tot+beaongkir));
                }
            }
        });
        tomboltambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumlah.setText(String.valueOf(jml+1));
                jml = jml+1;
                tot = angka*jml;
                htproduk.setText("Rp. "+formatter.format(tot));
                total.setText("Rp. "+formatter.format(tot+beaongkir));
            }
        });
    }
}
