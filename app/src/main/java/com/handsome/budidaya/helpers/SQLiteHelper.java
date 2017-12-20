package com.handsome.budidaya.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.handsome.budidaya.models.Budidaya;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by handsome on 11/12/17.
 */

public class SQLiteHelper extends SQLiteOpenHelper {
    static SQLiteHelper sqh;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_JUDUL = "databaseKu";

    //TABLE BUDIDAYA
    private static final String TABLE_BUDIDAYA = "budidayas";

    //KOLOM
    private static final String KEY_BUDIDAYA_ID = "budidaya_id";
    private static final String KEY_JUDUL = "judul";
    private static final String KEY_ISI = "alamat";
    private static final String KEY_KATEGORI = "kategori";
    private static final String KEY_GAMBAR = "gambar";

    public static SQLiteHelper getInstance(Context context){
        if(sqh == null){
            sqh = new SQLiteHelper(context);
        }

        return sqh;
    }

    public SQLiteHelper(Context context) {
        super(context, DATABASE_JUDUL, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BUDIDAYA_TBL = "CREATE TABLE " + TABLE_BUDIDAYA + "("
                + KEY_BUDIDAYA_ID + " INTEGER PRIMARY KEY,"
                + KEY_JUDUL + " TEXT,"
                + KEY_KATEGORI + " TEXT,"
                + KEY_GAMBAR + " TEXT,"
                + KEY_ISI + " TEXT"+ ")";
        db.execSQL(CREATE_BUDIDAYA_TBL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUDIDAYA);
        onCreate(db);
    }

    //CRUD BUDIDAYA
    public void addBudidaya(Budidaya budidaya){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_JUDUL, budidaya.getJudul());
        values.put(KEY_ISI, budidaya.getIsi());
        values.put(KEY_GAMBAR, budidaya.getGambar());
        values.put(KEY_KATEGORI, budidaya.getKategori());
        db.insert(TABLE_BUDIDAYA, null, values);
        db.close();
    }

    public Budidaya getBudidaya(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_BUDIDAYA, new String[] { KEY_BUDIDAYA_ID, KEY_KATEGORI, KEY_JUDUL, KEY_ISI, KEY_GAMBAR }, KEY_BUDIDAYA_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Budidaya budidaya = new Budidaya(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4)
        );

        return budidaya;
    }

    public List<Budidaya> getBudidayas(){
        List<Budidaya> budidayas = new ArrayList<Budidaya>();

        String selectQuery = "SELECT * FROM " + TABLE_BUDIDAYA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                Budidaya budidaya = new Budidaya(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                );
                budidayas.add(budidaya);
            } while (cursor.moveToNext());
        }

        return budidayas;
    }

    public List<Budidaya> getBudidayas(String kategori){
        List<Budidaya> budidayas = new ArrayList<Budidaya>();

        String selectQuery = "SELECT * FROM " + TABLE_BUDIDAYA + " WHERE " + KEY_KATEGORI + " LIKE '%" + kategori + "%'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                Budidaya budidaya = new Budidaya(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                );
                budidayas.add(budidaya);
            } while (cursor.moveToNext());
        }

        return budidayas;
    }

    public int updateBudidaya(Budidaya budidaya){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_JUDUL, budidaya.getJudul());
        values.put(KEY_ISI, budidaya.getIsi());
        return db.update(TABLE_BUDIDAYA, values, KEY_BUDIDAYA_ID + " = ?", new String[] { String.valueOf(budidaya.getId())});
    }

    public void deleteBudidaya(Budidaya budidaya){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BUDIDAYA, KEY_BUDIDAYA_ID + " = ?",
                new String[] { String.valueOf(budidaya.getId()) });
        db.close();
    }

}
