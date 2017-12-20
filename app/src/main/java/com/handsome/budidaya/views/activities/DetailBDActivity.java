package com.handsome.budidaya.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.handsome.budidaya.R;
import com.handsome.budidaya.helpers.SQLiteHelper;
import com.handsome.budidaya.models.Budidaya;

/**
 * Created by handsome on 11/12/17.
 */

public class DetailBDActivity extends AppCompatActivity {
    private TextView txtIsi;
    private TextView txtKategori;
    private Budidaya budidaya;
    private ImageView gambar;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_bd);
        gambar = (ImageView)findViewById(R.id.gambar);
        txtIsi = (TextView)findViewById(R.id.txtIsi);
        txtKategori = (TextView)findViewById(R.id.txtKategori);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setupData();
        setupToolbar();
    }

    private void setupToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(budidaya.getJudul());
    }

    private void setupData(){
        int id = getIntent().getIntExtra("id_rs", 0);
        id += 1;
        budidaya = SQLiteHelper.getInstance(this).getBudidaya(id);
        txtIsi.setText(budidaya.getIsi());
        txtKategori.setText(budidaya.getKategori());
        gambar.setImageResource(getResources().getIdentifier(budidaya.getGambar(),"drawable",getPackageName()));
    }



}
