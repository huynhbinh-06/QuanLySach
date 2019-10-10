package hbinh.com.quanlysach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import hbinh.com.quanlysach.Adapter.AddBookAdapter;
import hbinh.com.quanlysach.DAO.AddBookDAO;

public class MainListAddBookActivity extends AppCompatActivity {

    ImageView imgaddbook;
    ListView listaddbook;
    AddBookAdapter addBookAdapter;
    AddBookDAO addBookDAO;
//    ArrayList<AddBook> dsAddBook = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_add_book);

        imgaddbook = findViewById(R.id.imgaddbook);
        listaddbook = findViewById(R.id.listaddbook);

        addBookDAO = new AddBookDAO(this);
        addBookAdapter = new AddBookAdapter(this,addBookDAO.getAllAddBook());
        listaddbook.setAdapter(addBookAdapter);

        imgaddbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainListAddBookActivity.this, MainBillBookActivity.class);
                startActivity(intent);
            }
        });
    }
}
