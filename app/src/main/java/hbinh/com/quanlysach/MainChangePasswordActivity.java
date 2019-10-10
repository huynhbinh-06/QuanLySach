package hbinh.com.quanlysach;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import hbinh.com.quanlysach.DAO.AccountDAO;

import static hbinh.com.quanlysach.MainLoginActivity.strPassword;
import static hbinh.com.quanlysach.MainLoginActivity.strUsername;

public class MainChangePasswordActivity extends AppCompatActivity {

    EditText edtold, edtnew, edtnhaplai;
    Button btnchange;
    AccountDAO accountDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_change_password);

        edtold = findViewById(R.id.edtold);
        edtnew = findViewById(R.id.edtnew);
        edtnhaplai = findViewById(R.id.edtnhaplai);
        btnchange = findViewById(R.id.btnchange);

        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUpdate();
            }
        });

    }

    public void checkUpdate() {
        accountDAO = new AccountDAO(this);
        if (edtold.getText().toString().equals(strPassword) == true) {
            if (edtnhaplai.getText().toString().equals(edtnew.getText().toString()) == true) {
                accountDAO.updatePassword(strUsername + "", edtnew.getText().toString() + "");
                if ((accountDAO.updatePassword(strUsername + "", edtnew.getText().toString() + "")) > 0) {
                    Toast.makeText(this, "Change password!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Nhap lai password chua dung!", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Password da duoc thay doi!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Password cu khong dung! ", Toast.LENGTH_SHORT).show();
        }
    }
}
