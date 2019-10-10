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

import hbinh.com.quanlysach.DAO.AddTypeBookDAO;
import hbinh.com.quanlysach.Model.TypeOfBook;
import hbinh.com.quanlysach.R;

public class TypeOfBookAdapter extends BaseAdapter {

    public Context context;
    public ArrayList<TypeOfBook> dsTypeBook;
    public LayoutInflater inflater;
    public AddTypeBookDAO typeBookDAO;

    public TypeOfBookAdapter(Context context, ArrayList<TypeOfBook> dsTypeBook) {
        this.context = context;
        this.dsTypeBook = dsTypeBook;
        this.inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        typeBookDAO = new AddTypeBookDAO(context);
    }

    @Override
    public int getCount() {
        return dsTypeBook.size();
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

        View view = inflater.inflate(R.layout.custom_list_typebook,null);
        TextView txttensach = view.findViewById(R.id.txttensach);
        ImageView imgdeletetype = view.findViewById(R.id.imgdeletetype);
        txttensach.setText(dsTypeBook.get(position).getTentheloai());

        imgdeletetype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Ban co muon xoa khong?")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            if (typeBookDAO.deleteTypeBook(dsTypeBook.get(position).getMatheloai())){
                                dsTypeBook.remove(position);
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
                })
                        .setNegativeButton("Cancel",null);

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        return view;
    }
}
