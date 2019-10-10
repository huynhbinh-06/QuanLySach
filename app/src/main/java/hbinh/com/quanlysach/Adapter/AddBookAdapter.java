package hbinh.com.quanlysach.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import hbinh.com.quanlysach.DAO.AddBookDAO;
import hbinh.com.quanlysach.Model.AddBook;
import hbinh.com.quanlysach.R;

import static hbinh.com.quanlysach.MainAddBookActivity.masach;

public class AddBookAdapter extends BaseAdapter {

    public Context context;
    public ArrayList<AddBook> dsAddBook = new ArrayList<>();
    public LayoutInflater inflater;
    public AddBookDAO addBookDAO;

    public AddBookAdapter(Context context, ArrayList<AddBook> dsAddBook) {
        this.context = context;
        this.dsAddBook = dsAddBook;
        this.inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        addBookDAO = new AddBookDAO(context);
    }

    @Override
    public int getCount() {
        return dsAddBook.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(R.layout.custom_list_addbook,null);
        TextView txtnamebook = view.findViewById(R.id.txtnamebook);
        TextView txtgiabook = view.findViewById(R.id.txtgiabook);
        ImageView deleteadd = view.findViewById(R.id.imgdeleteadd);

        final AddBook addBook = dsAddBook.get(position);
        txtnamebook.setText(dsAddBook.get(position).getMasach());
        txtgiabook.setText("$"+dsAddBook.get(position).getGiabia());

        deleteadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                addBookDAO = new AddBookDAO(context);
//                addBookDAO.deleteAddbook(dsAddBook.get(position).getMasach());
//                dsAddBook.remove(position);
//                notifyDataSetChanged();

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Ban co muon xoa khong?").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            if (addBookDAO.deleteAddbook(dsAddBook.get(position).getMasach())){
                                dsAddBook.remove(position);
                                Toast.makeText(context, "Thanh cong!", Toast.LENGTH_SHORT).show();
                                notifyDataSetChanged();
                            }
                            else {
                                Toast.makeText(context, "That bai!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        catch (Exception e){

                        }
                    }
                }).setNegativeButton("Cancel",null);

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        return view;
    }
}
