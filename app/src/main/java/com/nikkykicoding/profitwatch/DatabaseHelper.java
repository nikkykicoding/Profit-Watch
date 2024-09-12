package com.nikkykicoding.profitwatch;import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "StockMarket.db";
    public static final String TABLE_NAME = "stocks";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "STOCK_NAME";
    public static final String COL_3 = "BUY_PRICE";
    public static final String COL_4 = "SELL_PRICE";
    public static final String COL_5 = "QUANTITY";
    public static final String COL_6 = "DATE";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, STOCK_NAME TEXT, BUY_PRICE REAL, SELL_PRICE REAL, QUANTITY INTEGER, DATE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String stockName, double buyPrice, double sellPrice, int quantity, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, stockName);
        contentValues.put(COL_3, buyPrice);
        contentValues.put(COL_4, sellPrice);
        contentValues.put(COL_5, quantity);
        contentValues.put(COL_6, date);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[]{id});
    }

}
