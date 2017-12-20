package com.handsome.budidaya.models;

/**
 * Created by handsome on 11/12/17.
 */

public class Budidaya {
    private int id;
    private String judul;
    private String kategori;
    private String isi;
    private String gambar;

    public Budidaya(int id, String judul, String kategori, String isi, String gambar) {
        this.id = id;
        this.judul = judul;
        this.kategori = kategori;
        this.isi = isi;
        this.gambar = gambar;
    }

    public Budidaya(String judul, String kategori, String isi, String gambar) {
        this.judul = judul;
        this.kategori = kategori;
        this.isi = isi;
        this.gambar = gambar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.isi = gambar;
    }
}
