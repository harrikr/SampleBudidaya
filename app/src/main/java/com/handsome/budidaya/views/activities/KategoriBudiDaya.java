package com.handsome.budidaya.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.handsome.budidaya.R;

/**
 * Created by handsome on 11/12/17.
 */

public class KategoriBudiDaya extends AppCompatActivity {
    private Button btnTertutup,btnTerbuka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_budi_daya);
        btnTerbuka = (Button)findViewById(R.id.btnTerbuka);
        btnTertutup = (Button)findViewById(R.id.btnTertutup);

        btnTerbuka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(KategoriBudiDaya.this, MainDataActivity.class);
                i.putExtra("tipe","budidaya");
                i.putExtra("kategori","terbuka");
                startActivity(i);
            }
        });

        btnTertutup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(KategoriBudiDaya.this, MainDataActivity.class);
                i.putExtra("tipe","budidaya");
                i.putExtra("kategori","tertutup");
                startActivity(i);
            }
        });
    }
}
