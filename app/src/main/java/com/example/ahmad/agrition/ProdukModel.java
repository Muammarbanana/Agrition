package com.example.ahmad.agrition;

/**
 * Created by ASUS on 25/07/2018.
 */

public class ProdukModel {
    private int gambar;
    private String namaBarang;
    private int hargaBarang;

    public ProdukModel(int gambar, String namaBarang, int hargaBarang) {
        this.gambar = gambar;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(int hargaBarang) {
        this.hargaBarang = hargaBarang;
    }
}
