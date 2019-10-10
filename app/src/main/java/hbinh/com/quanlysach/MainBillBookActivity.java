package hbinh.com.quanlysach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import hbinh.com.quanlysach.DAO.AddBookDAO;
import hbinh.com.quanlysach.DAO.BillDAO;
import hbinh.com.quanlysach.DAO.BillDetailsDAO;
import hbinh.com.quanlysach.Model.AddBook;
import hbinh.com.quanlysach.Model.Bill;
import hbinh.com.quanlysach.Model.BillDetails;

import static hbinh.com.quanlysach.MainInputBillActivity.strCodebill;
import static hbinh.com.quanlysach.MainInputBillActivity.strDatebill;

public class MainBillBookActivity extends AppCompatActivity {

    Button btnlistbill, btnaddbuybook;
    Spinner spncodebook;
    TextView txtpricesbook, txtcodebill, txtdatebill;
    EditText edtamount;
    ArrayList<String> dsAddbook;
    ArrayList<AddBook> dsBook;
    AddBookDAO addBookDAO;
    BillDetails billDetails;
    BillDetailsDAO billDetailsDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bill_book);

        btnlistbill = findViewById(R.id.btnlistbill);
        btnaddbuybook = findViewById(R.id.btnaddbuybook);
        spncodebook = findViewById(R.id.spncodebook);
        txtcodebill = findViewById(R.id.txtcodebill);
        txtdatebill = findViewById(R.id.txtdatebill);
        txtpricesbook = findViewById(R.id.txtpricesbook);
        edtamount = findViewById(R.id.edtamount);

        txtcodebill.setText(strCodebill);
        txtdatebill.setText(strDatebill);

        //spinner
        addBookDAO = new AddBookDAO(this);
        dsAddbook = new ArrayList<>();
        dsBook = new ArrayList<>();
        for (int i = 0; i < addBookDAO.getAllAddBook().size(); i++) {
            dsAddbook.add(addBookDAO.getAllAddBook().get(i).getMasach());
        }
        ArrayAdapter<String> adapterspn = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dsAddbook);
        spncodebook.setAdapter(adapterspn);

        //setPrices len textview

        for (int i = 0; i < addBookDAO.getAllAddBook().size(); i++) {
            AddBook addBook = new AddBook(addBookDAO.getAllAddBook().get(i).getMasach(), addBookDAO.getAllAddBook().get(i).getGiabia());
            dsBook.add(addBook);
        }
//        for (int i = 0; i < addBookDAO.getAllAddBook().size(); i++) {
//            if (spncodebook.getSelectedItem().toString().equals(dsBook.get(i).getMasach())) {
//                txtpricesbook.setText(dsBook.get(i).getGiabia() + "");
//            }
//        }

        spncodebook.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txtpricesbook.setText(dsBook.get(position).getGiabia()+"");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Add Bill

        btnaddbuybook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBillDetails();
            }
        });

        //List Bill
        btnlistbill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainBillBookActivity.this,MainBillDetailsActivity.class);
                startActivity(intent);

            }
        });
    }

    public void addBillDetails(){
         billDetailsDAO = new BillDetailsDAO(this);
         billDetails = new BillDetails(txtcodebill.getText().toString(),spncodebook.getSelectedItem().toString(),edtamount.getText().toString(),txtpricesbook.getText().toString());

         try {
             if (billDetailsDAO.insertBillDetails(billDetails)<0){
                 Toast.makeText(this, "Thanh cong!", Toast.LENGTH_SHORT).show();
                 edtamount.setText("");
             }
             else {
                 Toast.makeText(this, "Khong thanh cong!", Toast.LENGTH_SHORT).show();
             }
         }
         catch (Exception e){

         }
    }
}
