package hbinh.com.quanlysach.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import hbinh.com.quanlysach.Database.DatabaseHelper;
import hbinh.com.quanlysach.Model.BillDetails;

public class BillDetailsDAO {

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    public static final String TABLE_NAME="billdetails";
    public static final String SQL_BILLDETAILS = "CREATE TABLE billdetails "+"("+"mahoadonchitiet INTEGER PRIMARY KEY AUTOINCREMENT,"+" mahoadon text," +
            "masach text," +
            "soluong text,"+" prices text "+")";

    public BillDetailsDAO(Context context){
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int insertBillDetails(BillDetails billDetails){
        ContentValues values = new ContentValues();
        values.put("mahoadonchitiet",billDetails.getMahoadonchitiet());
        values.put("mahoadon",billDetails.getMahoadon());
        values.put("masach",billDetails.getMasach());
        values.put("soluong",billDetails.getSoluong());
        values.put("prices",billDetails.getPrices());

        try {
            if (db.insert(TABLE_NAME,null,values)==-1)
                return 1;
        }
        catch (Exception e){

        }
        return -1;
    }
    public ArrayList<BillDetails> getAllBillDetails(){
        ArrayList<BillDetails> dsBillDetails = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null,null);
        cursor.moveToFirst();

        while (cursor.isAfterLast()==false){
            BillDetails billDetails = new BillDetails();
            billDetails.setMahoadonchitiet(cursor.getString(0));
            billDetails.setMahoadon(cursor.getString(1));
            billDetails.setMasach(cursor.getString(2));
            billDetails.setSoluong(cursor.getString(3));
            billDetails.setPrices(cursor.getString(4));

            dsBillDetails.add(billDetails);
            cursor.moveToNext();
        }
        cursor.close();
        return dsBillDetails;
    }

}
