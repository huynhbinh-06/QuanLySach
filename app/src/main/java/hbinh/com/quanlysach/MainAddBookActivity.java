package hbinh.com.quanlysach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import hbinh.com.quanlysach.DAO.AddBookDAO;
import hbinh.com.quanlysach.DAO.AddTypeBookDAO;
import hbinh.com.quanlysach.Model.AddBook;
import hbinh.com.quanlysach.Model.TypeOfBook;

public class MainAddBookActivity extends AppCompatActivity {

    Button btnshowadd,btnbookadd;
    Spinner spinneradd;
    EditText edtmasach,edttacgia,edtnxb,edtgiabia,edtsoluong;
    AddBook addBook;
    AddBookDAO bookDAO;
    public static String masach;
//    ArrayList<String> dsTypeBook;
    ArrayList<TypeOfBook> dsTypeBook;
    AddTypeBookDAO addTypeBookDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_add_book);

        btnbookadd = findViewById(R.id.btnbookadd);
        btnshowadd = findViewById(R.id.btnshowadd);
        spinneradd = findViewById(R.id.spinneradd);
        edtmasach = findViewById(R.id.edtmasach);
        edttacgia = findViewById(R.id.edttacgia);
        edtnxb = findViewById(R.id.edtnxb);
        edtgiabia = findViewById(R.id.edtgiabia);
        edtsoluong = findViewById(R.id.edtsoluong);

        addTypeBookDAO = new AddTypeBookDAO(this);
        dsTypeBook = new ArrayList<>();
        dsTypeBook = addTypeBookDAO.getAllTypeBook();

//        for (int i =0; i<addTypeBookDAO.getAllTypeBook().size(); i++){
//            dsTypeBook.add(" | " + addTypeBookDAO.getAllTypeBook().get(i).getMatheloai());
//        }
//        ArrayAdapter<String> adapterspn = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dsTypeBook);
        ArrayAdapter adapterspn = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,dsTypeBook);
        spinneradd.setAdapter(adapterspn);
        btnbookadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBook();
            }
        });

        btnshowadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainAddBookActivity.this,MainListAddBookActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addBook(){

        Toast.makeText(this, spinneradd.getSelectedItem().toString()+"", Toast.LENGTH_SHORT).show();
        bookDAO = new AddBookDAO(this);
        addBook = new AddBook(edtmasach.getText().toString(),spinneradd.getSelectedItem().toString(),
                edttacgia.getText().toString(),edtnxb.getText().toString(),
                Double.parseDouble(edtgiabia.getText().toString()),Integer.parseInt(edtsoluong.getText().toString()));

        try {
            if (bookDAO.insertAddBook(addBook)<0){
                Toast.makeText(this, "Successful!", Toast.LENGTH_SHORT).show();
                edtmasach.setText("");
                edttacgia.setText("");
                edtnxb.setText("");
                edtgiabia.setText("");
                edtsoluong.setText("");
            }
            else {
                Toast.makeText(this, "Error!rfcfv", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e){
            Toast.makeText(this, "Error"+e.toString(), Toast.LENGTH_SHORT).show();

        }

    }
}
