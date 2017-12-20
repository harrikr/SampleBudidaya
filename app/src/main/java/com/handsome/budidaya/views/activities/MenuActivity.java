package com.handsome.budidaya.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;

import com.handsome.budidaya.R;

/**
 * Created by handsome on 11/12/17.
 */

public class MenuActivity extends AppCompatActivity {
    private LinearLayout btnBudidaya;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnBudidaya = (LinearLayout)findViewById(R.id.btnBudidaya);
            setupToolbar();
        setupView();
    }

    private void setupToolbar(){
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Menu Utama");
    }

    private void setupView(){
          btnBudidaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, KategoriBudiDaya.class);
                startActivity(i);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        toolbar.inflateMenu(R.menu.main);
        toolbar.getMenu().findItem(R.id.menu_bantuan).setIcon(R.drawable.ic_help_white);
        return super.onCreateOptionsMenu(menu);
    }


}
