package com.handsome.budidaya.views.activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.handsome.budidaya.R;
import com.handsome.budidaya.views.fragments.BudidayaFragment;

/**
 * Created by handsome on 11/12/17.
 */

public class MainDataActivity extends AppCompatActivity {
    private String tipe;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_data);
        setupToolbar();
        getBundle();
        setupView();
    }

    private void setupToolbar(){
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Menu Utama");
    }

    private void getBundle(){
        tipe = getIntent().getStringExtra("tipe");
    }

    private void setupView(){
        FragmentManager fm = getSupportFragmentManager();
       if(tipe.equalsIgnoreCase("budidaya")){
            getSupportActionBar().setTitle("Daftar Budidaya");
            if(fm.beginTransaction().isEmpty()){
                fm.beginTransaction().add(R.id.content, BudidayaFragment.newInstance(getIntent().getStringExtra("kategori")),"content_fragment").commitAllowingStateLoss();
            } else {
                fm.beginTransaction().replace(R.id.content, BudidayaFragment.newInstance(getIntent().getStringExtra("kategori")), "content_fragment").commitAllowingStateLoss();
            }
        }
    }
}
