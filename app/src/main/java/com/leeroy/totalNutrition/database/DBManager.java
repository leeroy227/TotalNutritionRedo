package com.leeroy.totalNutrition.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private DatabaseHelper dbhelper;
    private Context context;
    private SQLiteDatabase database;
    public DBManager(Context c){
        context=c;
    }

    public DBManager open() throws SQLException{
        dbhelper = new DatabaseHelper(context);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void insert (String name){
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.NAME,name);

        //add other stuff here for nutrient facts and what not

        database.insert(DatabaseHelper.TABLE_NAME,null, contentValue);
    }

    public Cursor fetch(){
        String[] columns = new String[] {DatabaseHelper._ID, DatabaseHelper.NAME};
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null,null,null,null,null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update (long _id, String name){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.NAME,name);
        int i = database.update(DatabaseHelper.TABLE_NAME,contentValues,DatabaseHelper._ID + " = " +_id, null);
        return i;
    }

    public void delete (long _id){
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" +_id, null);
    }
}
