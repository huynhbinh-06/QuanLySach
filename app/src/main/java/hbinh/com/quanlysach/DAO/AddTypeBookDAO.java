package hbinh.com.quanlysach.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import hbinh.com.quanlysach.Database.DatabaseHelper;
import hbinh.com.quanlysach.Model.TypeOfBook;

public class AddTypeBookDAO {

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    public static final String TABLE_NAME = "addtypebook";
    public static final String SQL_TYPEBOOK = "CREATE TABLE addtypebook"+"("+"matheloai text primary key, "+"tentheloai text, "+"vitriloaisach integer, "+"motaloaisach text"+")";

    public AddTypeBookDAO(Context context){
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int insertAddTypeBook(TypeOfBook typeOfBook){
        ContentValues values = new ContentValues();
        values.put("matheloai",typeOfBook.getMatheloai());
        values.put("tentheloai",typeOfBook.getTentheloai());
        values.put("vitriloaisach",typeOfBook.getVitriloaisach());
        values.put("motaloaisach",typeOfBook.getMotaloaisach());

        try {
            if (db.insert(TABLE_NAME,null,values)==-1);
                return 1;
        }
        catch (Exception e){
        }
        return -1;
    }

    public ArrayList<TypeOfBook> getAllTypeBook(){
        ArrayList<TypeOfBook> dsTypeBook = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToFirst();

        while (cursor.isAfterLast()==false){
            TypeOfBook typeOfBook = new TypeOfBook();
            typeOfBook.setMatheloai(cursor.getString(0));
            typeOfBook.setTentheloai(cursor.getString(1));
            typeOfBook.setVitriloaisach(cursor.getInt(2));
            typeOfBook.setMotaloaisach(cursor.getString(3));

            dsTypeBook.add(typeOfBook);
            cursor.moveToNext();
        }
        cursor.close();
        return dsTypeBook;
    }

    public boolean deleteTypeBook(String matheloai){
        return db.delete(TABLE_NAME,"matheloai=?",new String[]{matheloai})>0;
    }

}
