package hbinh.com.quanlysach;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import hbinh.com.quanlysach.Adapter.BillDetailsAdapter;
import hbinh.com.quanlysach.DAO.BillDetailsDAO;
import hbinh.com.quanlysach.Model.BillDetails;

import static hbinh.com.quanlysach.MainInputBillActivity.strCodebill;

public class MainBillDetailsActivity extends AppCompatActivity {

    ListView lvbilldetails;
//    ArrayList<BillDetails> dsDetails = new ArrayList<>();
    BillDetailsAdapter detailsAdapter;
    BillDetailsDAO billDetailsDAO;
    TextView txtbilldetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bill_details);

        lvbilldetails = findViewById(R.id.lvbilldetails);
        txtbilldetails = findViewById(R.id.txtbilldetails);

        txtbilldetails.setText(strCodebill);


        billDetailsDAO = new BillDetailsDAO(this);
        detailsAdapter = new BillDetailsAdapter(this,billDetailsDAO.getAllBillDetails());
        lvbilldetails.setAdapter(detailsAdapter);
    }
}
