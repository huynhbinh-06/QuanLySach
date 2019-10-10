package hbinh.com.quanlysach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import hbinh.com.quanlysach.DAO.AccountDAO;

import static hbinh.com.quanlysach.MainLoginActivity.strUsername;

public class MainInformationActivity extends AppCompatActivity {

    ImageView nextchange,nextadduser,nextlistuser;
    TextView txtchangepass,txtadduser,txtlistuser,txtadmin,txtemailadmin,sdtadmin;
    public static AccountDAO accountDAO;
    public static String sodienthoai,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_information);

        nextchange = findViewById(R.id.nextchange);
        nextadduser = findViewById(R.id.nextadduser);
        nextlistuser = findViewById(R.id.nextlistuser);
        txtlistuser = findViewById(R.id.txtlistuser);
        txtadduser = findViewById(R.id.txtadduser);
        txtchangepass = findViewById(R.id.txtchangepass);
        txtadmin = findViewById(R.id.txtadmin);
        txtemailadmin = findViewById(R.id.txtemailadmin);
        sdtadmin =  findViewById(R.id.sdtadmin);

        txtadmin.setText(strUsername);
        getData();



        nextchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainInformationActivity.this,MainChangePasswordActivity.class);
                startActivity(intent);
            }
        });
        txtchangepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainInformationActivity.this,MainChangePasswordActivity.class);
                startActivity(intent);
            }
        });

        nextadduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainInformationActivity.this,AddUserActivity.class);
                startActivity(intent);
            }
        });
        txtadduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainInformationActivity.this,AddUserActivity.class);
                startActivity(intent);
            }
        });
        nextlistuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainInformationActivity.this,MainListAccountActivity.class);
                startActivity(intent);
            }
        });

        txtlistuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainInformationActivity.this,MainListAccountActivity.class);
                startActivity(intent);
            }
        });

    }
    public void getData(){
        accountDAO = new AccountDAO(this);
        for(int i=0;i<accountDAO.getAllAcount().size();i++){
            if(accountDAO.getAllAcount().get(i).getUsername().equals(strUsername)){
                sodienthoai= accountDAO.getAllAcount().get(i).getSodienthoai();
                email=accountDAO.getAllAcount().get(i).getEmail();
                sdtadmin.setText(sodienthoai);
                txtemailadmin.setText(email);
            }
            else{

            }
        }
    }
}
