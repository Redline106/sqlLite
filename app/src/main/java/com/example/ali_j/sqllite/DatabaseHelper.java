package com.example.ali_j.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLDataException;

/**
 * Created by ali_j on 2017-12-05.
 */

public class DatabaseHelper    extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Student.db";
    public static final String TABLE_NAME="student_table";

    public static final String ID="ID";
    public static final String NAME="NAME";
    public static final String SURNAME="SURNAME";
    public static final String MARKS="MARKS";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARKS INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    public  boolean ajouter(String name,String surname ,String marks){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(NAME,name);
        values.put(SURNAME,surname);
        values.put(MARKS,marks);
        long result=db.insert(TABLE_NAME,null,values);
        if (result==-1){
            return false;
        }else return true;

    }

    public  String Affiche(){
        SQLiteDatabase db=this.getWritableDatabase();
        String bdString="";
        String query="SELECT * FROM "+TABLE_NAME+" WHERE 1";
        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            bdString +=c.getString(c.getColumnIndex("ID"));
            bdString +=" ";
            bdString +=c.getString(c.getColumnIndex("NAME"));
            bdString +=" ";
            bdString +=c.getString(c.getColumnIndex("SURNAME"));
            bdString +=" ";
            bdString +=c.getString(c.getColumnIndex("MARKS"));
            bdString +="\n";
            c.moveToNext();

        }c.close();
        db.close();
        return bdString;



    }





}
