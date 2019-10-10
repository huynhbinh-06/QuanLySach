package hbinh.com.quanlysach;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import hbinh.com.quanlysach.DAO.AddTypeBookDAO;
import hbinh.com.quanlysach.Model.TypeOfBook;

public class MainAddTypeBookActivity extends AppCompatActivity {

    Button btnshow,btnaddbook,btncancel;
    EditText edttypebook,edtbookname,edtbookposition,edtdescription;
    AddTypeBookDAO addTypeBookDAO;
    TypeOfBook typeOfBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_add_type_book);

        btnshow = findViewById(R.id.btnshow);
        btnaddbook = findViewById(R.id.btnaddbook);
        btncancel = findViewById(R.id.btncancel);
        edttypebook = findViewById(R.id.edttypebook);
        edtbookname = findViewById(R.id.edtbookname);
        edtbookposition = findViewById(R.id.edtbookposition);
        edtdescription = findViewById(R.id.edtdescription);

        btnaddbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBook();
            }
        });

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainAddTypeBookActivity.this,MainListTypeBookActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addBook(){
        addTypeBookDAO = new AddTypeBookDAO(MainAddTypeBookActivity.this);
        typeOfBook = new TypeOfBook(edttypebook.getText().toString(),edtbookname.getText().toString(),
                Integer.parseInt(edtbookposition.getText().toString()),edtdescription.getText().toString());

        try {
            if (addTypeBookDAO.insertAddTypeBook(typeOfBook)>0){
                Toast.makeText(this, "Successful !", Toast.LENGTH_SHORT).show();
                edttypebook.setText("");
                edtbookname.setText("");
                edtbookposition.setText("");
                edtdescription.setText("");
//                Intent intent = new Intent(MainAddTypeBookActivity.this,MainAddBookActivity.class);
//                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Failed !", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e){
        }
    }
}
