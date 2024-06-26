package com.example.project_of_tantai;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Database_Manager {
    public static final String SQL_create_table = "create table comic(id integer primary key autoincrement, namesong varchar(255), image nvarchar(200), nameartist varchar(200), content nvarchar(255))";
    public static void insert(Comic comic) {
        SQLiteDatabase s = DBHelper.createDB(null).getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put("image", comic.getImagecomic());
        v.put("namesong", comic.getNamecomic());
        v.put("nameartist", comic.getArtistcomic());
        v.put("content", comic.getContentcomic());
        s.insert("comic", null, v);
        Log.d(Database_Manager.class.getName(), "Successfully inserted");
    }

    public static void delete(int id) {
        SQLiteDatabase s = DBHelper.createDB(null).getWritableDatabase();
        s.delete("comic", "id = ?", new String[]{String.valueOf(id)});
    }

    public static void update(Comic comic) {
        SQLiteDatabase s = DBHelper.createDB(null).getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put("image", comic.getImagecomic());
        v.put("namesong", comic.getNamecomic());
        v.put("nameartist", comic.getArtistcomic());
        v.put("content", comic.getContentcomic());
        s.update("comic", v, "id = ?", new String[]{String.valueOf(comic.getId())});
    }

    public static List<Comic> getALL() {
        List<Comic> data = new ArrayList<>();
        SQLiteDatabase s = DBHelper.createDB(null).getWritableDatabase();
        String query = "select * from comic";
        Cursor cursor = s.rawQuery(query, null);
        while (cursor.moveToNext()) {
            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
            @SuppressLint("Range") String nameSong = cursor.getString(cursor.getColumnIndex("namesong"));
            @SuppressLint("Range") String imageSong = cursor.getString(cursor.getColumnIndex("image"));
            @SuppressLint("Range") String nameartistSong = cursor.getString(cursor.getColumnIndex("nameartist"));
            @SuppressLint("Range") String contentSong = cursor.getString(cursor.getColumnIndex("content"));
            Comic comic = new Comic(id, nameSong, imageSong, nameartistSong, contentSong);
            data.add(comic);
        }
        return data;
    }
}
