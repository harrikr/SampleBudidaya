package com.handsome.budidaya.views.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.handsome.budidaya.R;
import com.handsome.budidaya.helpers.SQLiteHelper;
import com.handsome.budidaya.helpers.SessionHelper;
import com.handsome.budidaya.models.Budidaya;

/**
 * Created by handsome on 11/12/17.
 */

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if(SessionHelper.getInstance(this).getAppFirstTime()){
            Log.d("MainApp","First session");
            queryBudidaya();
            SessionHelper.getInstance(this).setAppFirstTime(false);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, MenuActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }

    private void queryBudidaya(){
        SQLiteHelper.getInstance(this).addBudidaya(new Budidaya("", "", "",""));
        SQLiteHelper.getInstance(this).addBudidaya(new Budidaya("Sistem Penanaman di Bedengan", "Terbuka", "Kendala yang masih sering dihadapi petani stroberi pada penanaman di lahan terbuka adalah pada saat musim hujan. Bila musim hujan berkepanjangan, buah yang siap panen menjadi busuk karena terendam air. Untuk mengatasi masalah tersebut, telah dikembangkan penanaman stroberi di lahan dengan menggunakan mulsa. Bedengan tempat stroberi tumbuh ditutupi dengan mulsa plastik. Keuntungan sistem ini adalah menghambat pertumbuhan rumput (gulma) yang cepat, menjaga agar buah tetap bersih dan tidak langsung terkena tanah karena buah mudah busuk bila mengenai tanah, mempercepat pematangan buah yaitu 3-4 hari lebih cepat, mengurangi populasi hama karena ada pemantulan cahaya pada mulsa, serta menjaga suhu tetap tinggi, terutama di negara-negara tropis. Agar penanaman di lahan terbuka dengan sistem bedengan ini tetap menghasilkan produksi yang tinggi dan kualitas yang baik maka penyiraman dilakukan sekaligus dengan pemberian nutrisi.","ic_berita"));
        SQLiteHelper.getInstance(this).addBudidaya(new Budidaya("Sistem Vertikal dengan Karung", "Terbuka", "Sistem penanaman vertikal sangat cocok untuk lokasi yang tidak memiliki lahan yang cukup luas atau tanahnya tidak cocok untuk pertanaman stroberi. Penanaman dengan karung juga dapat mencegah pembusukan atau kerusakan buah akibat terendam banjir atau terserang hama penyakit yang banyak terdapat di permukaan tanah. Karung yang digunakan berupa karung beras plastik bekas. ","ic_berita"));
        SQLiteHelper.getInstance(this).addBudidaya(new Budidaya("Sistem Vertikal Rak Bertingkat", "Terbuka", "Sistem penanaman vertikal sangat cocok untuk lokasi yang tidak memiliki lahan yang cukup luas atau tanahnya tidak cocok untuk pertanaman stroberi. Penanaman dengan karung juga dapat mencegah pembusukan atau kerusakan buah akibat terendam banjir atau terserang hama penyakit yang banyak terdapat di permukaan tanah. Karung yang digunakan berupa karung beras plastik bekas. ","ic_berita"));

    }
}
