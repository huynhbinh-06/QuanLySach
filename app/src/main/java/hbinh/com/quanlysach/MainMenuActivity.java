package hbinh.com.quanlysach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static hbinh.com.quanlysach.MainLoginActivity.strUsername;

public class MainMenuActivity extends AppCompatActivity {

    LinearLayout sachbanchay,theloai,sachmenu,hoadonmenu,thongkemenu,exitmenu;
    TextView usermenu;
    ImageView imguser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        sachbanchay = findViewById(R.id.sachbanchay);
        theloai = findViewById(R.id.theloai);
        sachmenu = findViewById(R.id.sachmenu);
        hoadonmenu = findViewById(R.id.hoadonmenu);
        thongkemenu = findViewById(R.id.thongkemenu);
        exitmenu = findViewById(R.id.exitmenu);
        usermenu = findViewById(R.id.usermenu);
        imguser = findViewById(R.id.imguser);


        usermenu.setText(strUsername);
        Toast.makeText(this, "Welcome "+strUsername, Toast.LENGTH_SHORT).show();

        sachbanchay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this,MainTopBookActivity.class);
                startActivity(intent);
            }
        });
        theloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainMenuActivity.this,MainAddTypeBookActivity.class);
                startActivity(intent1);
            }
        });
        sachmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainMenuActivity.this,MainAddBookActivity.class);
                startActivity(intent2);
            }
        });
        hoadonmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainMenuActivity.this,MainInputBillActivity.class);
                startActivity(intent3);
            }
        });
        thongkemenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(MainMenuActivity.this,MainStatisticalActivity.class);
                startActivity(intent4);
            }
        });
        exitmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(MainMenuActivity.this,MainDrawerActivity.class);
                startActivity(intent5);

            }
        });
        imguser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this,MainInformationActivity.class);
                startActivity(intent);
            }
        });

    }
}
