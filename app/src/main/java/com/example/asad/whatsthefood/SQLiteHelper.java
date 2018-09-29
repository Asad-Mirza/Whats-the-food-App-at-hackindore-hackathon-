package com.example.asad.whatsthefood;

/**
 * Created by Asad Mirza on 22-02-2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "menu";
    public static final String CONTACTS_TABLE_NAME = "menutable";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_NAME = "msg";
    Context context;
    private HashMap hp;

    public SQLiteHelper(Context context) {


        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table menutable " +
                        "(id integer primary key, msg text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS menutable");
        onCreate(db);
    }

    public boolean insertContact(String msg) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("msg", msg);


        long l = db.insert("menutable", null, contentValues);
        if (l == -1) return false;
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from         long l = db.insert(\"menutable\", null, contentValues);\n where id=" + id + "", null);
        return res;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
        return numRows;
    }

    public boolean updateContact(Integer id, String msg) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("msg", msg);


        db.update("menutable", contentValues, "id = ? ", new String[]{Integer.toString(id)});
        return true;
    }

    public ArrayList<String> getALLdATA() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from menutable", null);
        ArrayList<String> data = new ArrayList<String>();
        if (res.moveToFirst()) {
            do {


                String ret;
                ret = res.getString(res.getColumnIndex("msg"));

                data.add(ret);
                //   Toast.makeText(context, pojo.getName(), Toast.LENGTH_SHORT).show();

            } while (res.moveToNext());
        }


        return data;


    }

}

