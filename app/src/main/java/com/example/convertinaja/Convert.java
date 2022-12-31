package com.example.convertinaja;

import com.google.gson.annotations.SerializedName;

public class Convert {
    @SerializedName("id")
    private int id;
    @SerializedName("nama")
    private String nama;
    @SerializedName("noPengirim")
    private int noPengirim;
    @SerializedName("jumlah")
    private int jumlah;
    @SerializedName("noTujuan")
    private int noTujuan;
    @SerializedName("eWallet")
    private String eWallet;

    public Convert(String nama, int noPengirim, int jumlah, int noTujuan, String eWallet) {
        this.nama = nama;
        this.noPengirim = noPengirim;
        this.jumlah = jumlah;
        this.noTujuan = noTujuan;
        this.eWallet = eWallet;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getNoPengirim() {
        return noPengirim;
    }

    public void setNoPengirim(int noPengirim) {
        this.noPengirim = noPengirim;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getNoTujuan() {
        return noTujuan;
    }

    public void setNoTujuan(int noTujuan) {
        this.noTujuan = noTujuan;
    }

    public String geteWallet() {
        return eWallet;
    }

    public void seteWallet(String eWallet) {
        this.eWallet = eWallet;
    }
}
