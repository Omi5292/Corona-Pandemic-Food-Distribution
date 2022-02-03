package com.example.coronapandemic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class FDdatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "FDdata.db";
    public static final String TABLE_NAME = "people";

    //=====create people table
    public static final String COL1 = "FULL_NAME";
    public static final String COL2 = "OCCUPATION";
    public static final String COL3 = "AADHAR_NO";
    public static final String COL4 = "PLACE";
    public static final String COL5 = "PIN_CODE";
    public static final String COL6 = "NO_OF_PEOPLE";

    public FDdatabase(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+COL1+" TEXT, "+COL2+" TEXT, "+COL3+" VARCHAR, "+COL4+" TEXT, "+COL5+" VARCHAR, "+COL6+" VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    //===========insert values in people table
    public boolean addData(String item1,String item2,String item3,String item4,String item5,String item6) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL1,item1);
        cv.put(COL2,item2);
        cv.put(COL3,item3);
        cv.put(COL4,item4);
        cv.put(COL5,item5);
        cv.put(COL6,item6);
        long result = db.insert(TABLE_NAME,null,cv);

        if (result == -1){
            return false;
        }else {
            return true;
        }
    }

    //===========view values in people table
    public ArrayList<ViewModel> getalldata(){
        ArrayList<ViewModel> list = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(sql,null);
        if (c.moveToFirst()){
            do {
                ViewModel viewModel = new ViewModel();
                viewModel.setName(c.getString(0));
                viewModel.setOccupation(c.getString(1));
                viewModel.setAdharno(c.getString(2));
                viewModel.setPlace(c.getString(3));
                viewModel.setPin(c.getString(4));
                viewModel.setNo(c.getString(5));
                list.add(viewModel);
            }while (c.moveToNext());
        }
        return  list;
    }
}
