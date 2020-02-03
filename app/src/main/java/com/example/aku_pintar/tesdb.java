package com.example.aku_pintar;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class tesdb extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_univ";
    private static final String TABLE_UNIV = "tb_univ";

    private static final String KEY_ID = "kd_univ";
    private static final String KEY_NAMA = "nm_univ";
    private static final String KEY_AKREDITAS = "akreditas";
    private static final String KEY_STATUS = "status";
    private static final String KEY_LOGO = "logo";

    private static final String TABLE_ALAMAT = "alamat";
    private static final String KEY_IDA = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_IMAGE = "image";

    public tesdb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        tes(db);
        alamat(db);

    }

    public void tes (SQLiteDatabase db){
        String query = "CREATE TABLE " + TABLE_UNIV + " (" +
                KEY_ID + " INTEGER PRIMARY KEY, " +
                KEY_NAMA + " TEXT, " +
                KEY_AKREDITAS + " TEXT, " +
                KEY_STATUS + " TEXT" +")";
        Log.d("Data", "onCreate: " + query);
        db.execSQL(query);

        query = "insert into tb_univ values(1,'Institut Teknologi Bandung','Akreditas A','PTN_BH')";
        db.execSQL(query);
        query = "insert into tb_univ values(2,'Universitas Indonesia','Akreditas A','PTN_BH')";
        db.execSQL(query);
        query = "insert into tb_univ values(3,'Institut Teknologi Sepuluh November','Akreditas A','PTN_BH')";
        db.execSQL(query);
        query = "insert into tb_univ values(4,'Universitas Gadjah Mada','Akreditas A','PTN_BH')";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion >= newVersion)
            return;
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_UNIV);

        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ALAMAT);

        onCreate(db);
    }


    public List<tesmodel> getUniv() {
        List<tesmodel> univList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_UNIV;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                int kd = cursor.getInt(0);
                String nama = cursor.getString(1);
                String akreditas = cursor.getString(2);
                String status = cursor.getString(3);

                tesmodel TESModel = new tesmodel(kd, nama, akreditas, status);

                univList.add(TESModel);
            } while (cursor.moveToNext());
        }

        return univList;
    }




    public void alamat (SQLiteDatabase db){
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_ALAMAT + "("
                + KEY_IDA + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_IMAGE + " BLOB" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

}
