package com.example.assignmen1.db;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.assignmen1.model.User;

import java.util.Queue;

public class mydb extends SQLiteOpenHelper {

    static int dbVersion = 1;
    static String DBNAME = "USER_DB";
    static String TABLE = "USER";
    static String COL_NAME = "USER_NAME";
    static String COL_EMAIL = "USER_EMAIL";
    static String COL_PASS = "USER_PASSWORD";
    static String COL_PHONE = "USER_PHONE_NUMBER";
    Context context;

    public mydb(@Nullable Context context) {
        super(context, DBNAME, null, dbVersion);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE + "(" + COL_NAME + " VARCHAR(30)," + COL_EMAIL + " VARCHAR(30)," + COL_PASS + " VARCHAR(30)," + COL_PHONE + " VARCHAR(30));");
    }

    public void insertUser(String name,String email,String password,String phone){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME,name);
        contentValues.put(COL_EMAIL,email);
        contentValues.put(COL_PASS,password);
        contentValues.put(COL_PHONE,phone);
        database.insert(TABLE,null,contentValues);
        Toast.makeText(context,"Signed Up successfully ..",Toast.LENGTH_SHORT).show();
        database.close();
    }

    public User getUser(){
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE;
        Cursor cursor = database.rawQuery(query,null);
        User user = new User();
        if(cursor.moveToFirst()){
            user.setFullName(cursor.getColumnName(cursor.getColumnIndexOrThrow(COL_NAME)));
            user.setEmail(cursor.getColumnName(cursor.getColumnIndexOrThrow(COL_EMAIL)));
            user.setPhoneNumber(cursor.getColumnName(cursor.getColumnIndexOrThrow(COL_PHONE)));
        }
        cursor.close();
        database.close();
        return user;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
