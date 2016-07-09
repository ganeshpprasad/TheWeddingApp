package com.example.ganesh.brokerapp.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.ganesh.brokerapp.Data.Contract.Clients;
import com.example.ganesh.brokerapp.Data.Contract.Vendors;

/**
 * Created by Ganesh Prasad on 30-06-2016.
 */
public class LocalDbHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "events.db";
    private static final int DATABASE_VERSION = 1;

    public LocalDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create string for clients table

    final String SQL_CREATE_CLIENTS_TABLE = "CREATE TABLE " + Clients.TABLE_NAME + "( " +
            Clients.CLIENT_NAME_COL + " TEXT NOT NULL," +
            Clients.CLIENT_EMAIL_COL + " TEXT NOT NULL," +
            Clients.AUTH_TOKEN_COL + " TEXT NOT NULL," +
            Clients.PHONE_NO_COL + " INTEGER," +
            Clients.CITY_COL + " TEXT NOT NULL," +
            Clients._ID + " INTEGER PRIMARY KEY" +
            Clients.URI_DP_COL + " TEXT NOT NULL" +
            ")";

    final String SQL_CREATE_VENDROS_TABLE = "CREATE TABLE " + Vendors.TABLE_NAME + "( " +
            Vendors.VENDOR_NAME_COL + " TEXT NOT NULL," +
            Vendors.VENDOR_EMAIL_COL + " TEXT NOT NULL," +
            Vendors.AUTH_TOKEN_COL + " TEXT NOT NULL," +
            Vendors.PHONE_NO_COL + " INTEGER," +
            Vendors.CITY_COL + " TEXT NOT NULL," +
            Vendors.TYPE_COL + " TEXT," +
            Vendors.URI_DP_COL + " TEXT NOT NULL" +
            Vendors._ID + " INTEGER PRIMARY KEY" +
            ")";

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
