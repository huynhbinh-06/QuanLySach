package hbinh.com.quanlysach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import hbinh.com.quanlysach.Adapter.AccountAdapter;
import hbinh.com.quanlysach.DAO.AccountDAO;
import hbinh.com.quanlysach.Model.Account;

public class AddUserActivity extends AppCompatActivity {

    public static String username;
    EditText edtnameuser,edtpassuser,edtsdtuser,edtemailuser;
    Button btncreateuser;
    AccountDAO accountDAO;
    Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        edtnameuser = findViewById(R.id.edtnameuser);
        edtpassuser = findViewById(R.id.edtpassuser);
        edtsdtuser = findViewById(R.id.edtsdtuser);
        edtemailuser = findViewById(R.id.edtemailuser);
        btncreateuser = findViewById(R.id.btncreateuser);



        btncreateuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });

    }

    public void addUser(){
        accountDAO = new AccountDAO(AddUserActivity.this);
        account = new Account(edtnameuser.getText().toString(),edtpassuser.getText().toString(),
                edtsdtuser.getText().toString(),edtemailuser.getText().toString());
        username = edtnameuser.getText().toString();
        try {
            if (accountDAO.insertAccount(account)>0){
                Toast.makeText(this, "Successful!", Toast.LENGTH_SHORT).show();
                edtnameuser.setText("");
                edtpassuser.setText("");
                edtsdtuser.setText("");
                edtemailuser.setText("");

                Intent intent = new Intent(AddUserActivity.this,MainInformationActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e){

        }
    }
}
