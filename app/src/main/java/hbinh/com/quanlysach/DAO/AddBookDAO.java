package hbinh.com.quanlysach.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import hbinh.com.quanlysach.Database.DatabaseHelper;
import hbinh.com.quanlysach.Model.AddBook;

public class AddBookDAO {

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    public static final String TABLE_NAME = "addbook";
    public static final String SQL_ADDBOOK = "CREATE TABLE addbook "+"("+"masach text primary key,"+" matheloai text references addtypebook(matheloai)," +
            "tacgia text,"+" nxb text,"+" giabia double,"+" soluong integer"+")";

    public AddBookDAO(Context context){
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int insertAddBook(AddBook addBook){
        ContentValues values = new ContentValues();
        values.put("masach",addBook.getMasach());
        values.put("matheloai",addBook.getMatheloai());
        values.put("tacgia",addBook.getTacgia());
        values.put("nxb",addBook.getNxb());
        values.put("giabia",addBook.getGiabia());
        values.put("soluong",addBook.getSoluong());

        try {
            if (db.insert(TABLE_NAME,null,values)==-1)
                return 1;
        }
        catch (Exception e){
        }
        return -1;
    }

    public ArrayList<AddBook> getAllAddBook(){
        ArrayList<AddBook> dsAddBook = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToFirst();

        while (cursor.isAfterLast()==false){
            AddBook addBook = new AddBook();
            addBook.setMasach(cursor.getString(0));
            addBook.setMatheloai(cursor.getString(1));
            addBook.setTacgia(cursor.getString(2));
            addBook.setNxb(cursor.getString(3));
            addBook.setGiabia(cursor.getDouble(4));
            addBook.setSoluong(cursor.getInt(5));

            dsAddBook.add(addBook);
            cursor.moveToNext();
        }
        cursor.close();
        return dsAddBook;
    }

    public boolean deleteAddbook(String masach){
        return db.delete(TABLE_NAME,"masach=?",new String[]{masach})>0;
    }
}
