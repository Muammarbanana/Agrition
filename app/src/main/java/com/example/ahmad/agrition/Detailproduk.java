package com.example.ahmad.agrition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class Detailproduk extends AppCompatActivity {

    TextView tv,tv2;
    ImageButton btnback;
    Button tombol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Intent intent = getIntent();
        String hasil = intent.getStringExtra("Namaproduk");
        setContentView(R.layout.activity_detailproduk);
        tv = findViewById(R.id.namaproduk2);
        tv2 = findViewById(R.id.namaprodukbesar);
        btnback = findViewById(R.id.btnback);
        tombol = findViewById(R.id.tombolbeli);
        if(intent!=null){
            tv.setText(hasil);
            tv2.setText(hasil);
            NumberFormat formatter = new DecimalFormat("###,###");
            String temp = intent.getStringExtra("Hargaproduk");
            String temp2 = formatter.format(Double.parseDouble(temp));
            tombol.setText("Beli | Rp. " + temp2);
        }
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent2;
                intent2 = new Intent(Detailproduk.this,Pembelian.class);
                intent2.putExtra("Harga",intent.getStringExtra("Hargaproduk"));
                startActivity(intent2);
            }
        });
    }
}
