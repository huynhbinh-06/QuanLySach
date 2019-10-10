package hbinh.com.quanlysach.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import hbinh.com.quanlysach.Database.DatabaseHelper;
import hbinh.com.quanlysach.Model.Bill;

public class BillDAO {

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    public static final String TABLE_NAME="bill";
    public static final String SQL_BILL="CREATE TABLE bill" + "(" + "mabill text PRIMARY KEY," + "ngaybill text" + ")";

    public BillDAO(Context context){
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int insertBill(Bill listBill){
        ContentValues values = new ContentValues();
        values.put("mabill",listBill.getMahoadon());
        values.put("ngaybill",listBill.getNgaymua());

        try {
            if (db.insert(TABLE_NAME,null,values)==-1){
                return 1;
            }
        }
        catch (Exception e){

        }
        return -1;
    }

    public ArrayList<Bill> getAllBill(){
        ArrayList<Bill> dsBill = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToFirst();

        while (cursor.isAfterLast()==false){
            Bill listBill = new Bill();
            listBill.setMahoadon(cursor.getString(0));
            listBill.setNgaymua(cursor.getString(1));

            dsBill.add(listBill);
            cursor.moveToNext();
        }
        cursor.close();
        return dsBill;
    }
}
