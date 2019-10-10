package hbinh.com.quanlysach.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import hbinh.com.quanlysach.Database.DatabaseHelper;
import hbinh.com.quanlysach.Model.Account;

public class AccountDAO {

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    public static final String TABLE_NAME="account";
    public static final String SQL_ACCOUNT = "CREATE TABLE account"+"("+"username text PRIMARY KEY,"+
            "password text,"+"sodienthoai text,"+"email text"+")";


    public AccountDAO(Context context){
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int insertAccount(Account account){
        ContentValues values = new ContentValues();
        values.put("username",account.getUsername());
        values.put("password",account.getPassword());
        values.put("sodienthoai",account.getSodienthoai());
        values.put("email",account.getEmail());


        try {
            if (db.insert(TABLE_NAME,null,values)==-1);
            return 1;
        }
        catch (Exception e){
        }
        return -1;
    }

    public ArrayList<Account> getAllAcount(){
        ArrayList<Account> dsAccount = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToFirst();

        while (cursor.isAfterLast()==false){
            Account account = new Account();
            account.setUsername(cursor.getString(0));
            account.setPassword(cursor.getString(1));
            account.setSodienthoai(cursor.getString(2));
            account.setEmail(cursor.getString(3));

            dsAccount.add(account);
            cursor.moveToNext();
        }
        cursor.close();
        return dsAccount;
    }

    public boolean checkLoginn(String username, String password){
        String sql1 = "SELECT * FROM account WHERE username=? and password=?";
        Cursor cs = db.rawQuery(sql1,new String[]{username,password});
        if (cs.getCount()<=0){
            return false;
        }
        return true;
    }

    public int updatePassword(String username, String password){
        ContentValues values = new ContentValues();
        values.put("password",password); //muon update cai gi truyen cai do vo
        return db.update(TABLE_NAME,values,"username=?",new String[]{username+""});
    }

    public boolean deleteAccount(String username){
        return db.delete(TABLE_NAME,"username=?",new String[]{username+""})>0;
    }


}
