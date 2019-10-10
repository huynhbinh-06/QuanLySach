package hbinh.com.quanlysach;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import hbinh.com.quanlysach.Adapter.AccountAdapter;
import hbinh.com.quanlysach.DAO.AccountDAO;
import hbinh.com.quanlysach.Model.Account;

public class MainListAccountActivity extends AppCompatActivity {

    ListView lvaccount;
    AccountAdapter adapter;
    ArrayList<Account> dsAccount = new ArrayList<>();
    AccountDAO accountDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_account);

        lvaccount = findViewById(R.id.lvaccount);

        accountDAO = new AccountDAO(this);
        adapter = new AccountAdapter(this,accountDAO.getAllAcount());
        lvaccount.setAdapter(adapter);
    }
}
