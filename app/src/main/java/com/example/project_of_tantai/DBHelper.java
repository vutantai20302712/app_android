package com.example.project_of_tantai;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_Name = "App_Comic";
    private static final int DB_Version = 1;
    private static DBHelper instance = null;
    public DBHelper(Context context) {
        super(context, DB_Name, null, DB_Version);
    }

    public synchronized static DBHelper createDB(Context context)
    {
        if(instance==null)
        {
            instance = new DBHelper(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Database_Manager.SQL_create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
