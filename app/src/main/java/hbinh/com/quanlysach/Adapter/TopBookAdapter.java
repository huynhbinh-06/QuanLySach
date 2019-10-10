package hbinh.com.quanlysach.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import hbinh.com.quanlysach.Model.TopBook;
import hbinh.com.quanlysach.R;

public class TopBookAdapter extends BaseAdapter {

    public Context context;
    public ArrayList<TopBook> dsTopBook;
    public LayoutInflater inflater;

    public TopBookAdapter(Context context, ArrayList<TopBook> dsTopBook) {
        this.context = context;
        this.dsTopBook = dsTopBook;
        this.inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dsTopBook.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(R.layout.custom_list_topbook,null);
        TextView txtnametopbook = view.findViewById(R.id.txtnametopbook);
        TextView txtsltopbook = view.findViewById(R.id.txtsltopbook);

        txtnametopbook.setText(dsTopBook.get(position).getMasach());
        txtsltopbook.setText(dsTopBook.get(position).getSoluongmua()+" Book");

        return view;
    }
}
