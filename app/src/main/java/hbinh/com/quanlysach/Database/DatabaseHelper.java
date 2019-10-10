package hbinh.com.quanlysach.Database;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import hbinh.com.quanlysach.DAO.AccountDAO;
import hbinh.com.quanlysach.DAO.AddBookDAO;
import hbinh.com.quanlysach.DAO.AddTypeBookDAO;
import hbinh.com.quanlysach.DAO.BillDAO;
import hbinh.com.quanlysach.DAO.BillDetailsDAO;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "bookstore";
    public static final int VERSION=1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(AccountDAO.SQL_ACCOUNT);
        db.execSQL("INSERT INTO account VALUES('admin','admin','0937467241','admin@gmail.com')");
        db.execSQL(AddBookDAO.SQL_ADDBOOK);
        db.execSQL(BillDetailsDAO.SQL_BILLDETAILS);
        db.execSQL(AddTypeBookDAO.SQL_TYPEBOOK);
        db.execSQL(BillDAO.SQL_BILL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("Drop table if exists " +AccountDAO.TABLE_NAME);
        db.execSQL("Drop table if exists " + AddBookDAO.TABLE_NAME);
        db.execSQL("Drop table if exists " + BillDetailsDAO.TABLE_NAME);
        db.execSQL("Drop table if exists " + AddTypeBookDAO.TABLE_NAME);
        db.execSQL("Drop table if exists " + BillDAO.TABLE_NAME);

    }
}
