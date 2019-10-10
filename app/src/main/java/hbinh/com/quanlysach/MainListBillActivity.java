package hbinh.com.quanlysach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import hbinh.com.quanlysach.Adapter.BillAdapter;
import hbinh.com.quanlysach.DAO.BillDAO;
import hbinh.com.quanlysach.Model.Bill;

public class MainListBillActivity extends AppCompatActivity {

    ImageView imgfindbill;
    ListView listviewbill;
    ArrayList<Bill> dsBill = new ArrayList<>();
    BillAdapter billAdapter;
    BillDAO billDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_bill);

        imgfindbill = findViewById(R.id.imgfindbill);
        listviewbill = findViewById(R.id.listviewbill);

        billDAO = new BillDAO(this);
        billAdapter = new BillAdapter(this,billDAO.getAllBill());
        listviewbill.setAdapter(billAdapter);

        imgfindbill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainListBillActivity.this,MainBillDetailsActivity.class);
                startActivity(intent);
            }
        });
    }
}
