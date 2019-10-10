package hbinh.com.quanlysach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import hbinh.com.quanlysach.Adapter.TypeOfBookAdapter;
import hbinh.com.quanlysach.DAO.AddTypeBookDAO;
import hbinh.com.quanlysach.Model.TypeOfBook;

public class MainListTypeBookActivity extends AppCompatActivity {

    ImageView imgaddtype;
    ListView listtypebook;
    ArrayList<TypeOfBook> dsTypeBook = new ArrayList<>();
    TypeOfBookAdapter adapter;
    AddTypeBookDAO addTypeBookDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_type_book);

        imgaddtype = findViewById(R.id.imgaddtype);
        listtypebook = findViewById(R.id.listtypebook);

        addTypeBookDAO = new AddTypeBookDAO(this);
        adapter = new TypeOfBookAdapter(this,addTypeBookDAO.getAllTypeBook());
        listtypebook.setAdapter(adapter);

        imgaddtype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainListTypeBookActivity.this,MainAddTypeBookActivity.class);
                startActivity(intent);
            }
        });

    }
}
