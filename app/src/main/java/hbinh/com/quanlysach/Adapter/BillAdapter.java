package hbinh.com.quanlysach.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import hbinh.com.quanlysach.Model.Bill;
import hbinh.com.quanlysach.R;

public class BillAdapter extends BaseAdapter {

    public Context context;
    public ArrayList<Bill> dsBill;
    public LayoutInflater inflater;

    public BillAdapter(Context context, ArrayList<Bill> dsBill) {
        this.context = context;
        this.dsBill = dsBill;
        this.inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dsBill.size();
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

        View view = inflater.inflate(R.layout.custom_list_inputbill,null);
        TextView txtnamebill = view.findViewById(R.id.txtnamebill);
        TextView txtdatebill = view.findViewById(R.id.txtdatebill);
        ImageView imgdeletebill = view.findViewById(R.id.imgdeletebill);

        txtnamebill.setText(dsBill.get(position).getMahoadon());
        txtdatebill.setText(dsBill.get(position).getNgaymua());


        return view;
    }
}
