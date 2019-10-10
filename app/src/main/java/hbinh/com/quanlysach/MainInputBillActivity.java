package hbinh.com.quanlysach;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import hbinh.com.quanlysach.DAO.BillDAO;
import hbinh.com.quanlysach.Model.Bill;

public class MainInputBillActivity extends AppCompatActivity {

    Button btncreatebill,btnpickdate;
    EditText edtbillnumber,edtdatebill;
    CalendarView calendarView;
    public static String strCodebill,strDatebill;
    Bill bill;
    BillDAO billDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_input_bill);

        btncreatebill = findViewById(R.id.btncreatebill);
        btnpickdate = findViewById(R.id.btnpickdate);
        calendarView = findViewById(R.id.calendarView);
        edtbillnumber = findViewById(R.id.edtbillnumber);
        edtdatebill = findViewById(R.id.edtdatebill);



        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                String date = dayOfMonth + "/" + (month+1) + "/" + year;
                Log.d("Calendar","date: " + date);
                edtdatebill.setText(date);

            }
        });

        btnpickdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainInputBillActivity.this,MainListBillActivity.class);
                startActivity(intent);
            }
        });


        btncreatebill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strCodebill = edtbillnumber.getText().toString();
                strDatebill = edtdatebill.getText().toString();

                addBill();

                Intent intent = new Intent(MainInputBillActivity.this,MainBillBookActivity.class);
                startActivity(intent);

            }
        });
    }

    public void addBill(){
        billDAO = new BillDAO(this);
        bill = new Bill(edtbillnumber.getText().toString(),edtdatebill.getText().toString());

        try {
            if (billDAO.insertBill(bill)<0){
                Toast.makeText(this, "Thanh cong!", Toast.LENGTH_SHORT).show();
                edtbillnumber.setText("");
                edtdatebill.setText("");
            }
            else {
                Toast.makeText(this, "That bai!", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e){

        }
    }
}
