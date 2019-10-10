package hbinh.com.quanlysach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import java.util.ArrayList;

import hbinh.com.quanlysach.DAO.AccountDAO;
import hbinh.com.quanlysach.Model.Account;

public class MainLoginActivity extends AppCompatActivity {




    EditText username;
    EditText password;
    CheckBox chkpassword;
    ImageView imgfacebook,imggoogle, imgtwitter;
    Button btnlogin;
    public static String strUsername, strPassword;
    AccountDAO accountDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        chkpassword = findViewById(R.id.chkpass);
        imgfacebook = findViewById(R.id.imgfacebook);
        imggoogle = findViewById(R.id.imggoogle);
        imgtwitter = findViewById(R.id.imgtwitter);
        btnlogin = findViewById(R.id.btnlogin);

        accountDAO = new AccountDAO(MainLoginActivity.this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkLogin();

            }
        });

        imgfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainLoginActivity.this,LoginFacebookActivity.class);
                startActivity(intent);
            }
        });

    }

    public void checkLogin(){

        strUsername = username.getText().toString();
        strPassword = password.getText().toString();


        if (strUsername.isEmpty() || strPassword.isEmpty()){
            Toast.makeText(this, "Ten dang nhap va mat khau khong duoc de trong!", Toast.LENGTH_SHORT).show();
        }
        else {
            if (accountDAO.checkLoginn(strUsername,strPassword)){
                Toast.makeText(this, "Successful!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainLoginActivity.this,MainMenuActivity.class);
                startActivity(intent);
                finish();
            }
            else {
                Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
