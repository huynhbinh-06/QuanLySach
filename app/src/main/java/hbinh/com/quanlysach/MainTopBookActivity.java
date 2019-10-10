package hbinh.com.quanlysach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import hbinh.com.quanlysach.Adapter.TopBookAdapter;
import hbinh.com.quanlysach.Model.TopBook;

public class MainTopBookActivity extends AppCompatActivity {

    ImageView imgfind;
    ListView listviewtop;
    ArrayList<TopBook> dsTopBook = new ArrayList<>();
    TopBookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_top_book);

        imgfind = findViewById(R.id.imgfind);
        listviewtop = findViewById(R.id.listviewtop);

        TopBook topBook = new TopBook("Java 1",20);
        TopBook topBook1 = new TopBook("CNTT",10);
        dsTopBook.add(topBook);
        dsTopBook.add(topBook1);

        adapter = new TopBookAdapter(this,dsTopBook);
        listviewtop.setAdapter(adapter);

    }
}
