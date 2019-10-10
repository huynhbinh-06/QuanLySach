package hbinh.com.quanlysach.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import hbinh.com.quanlysach.Model.BillDetails;
import hbinh.com.quanlysach.R;

public class BillDetailsAdapter extends BaseAdapter {

    public Context context;
    public ArrayList<BillDetails> dsDetails;
    public LayoutInflater inflater;

    public BillDetailsAdapter(Context context, ArrayList<BillDetails> dsDetails) {
        this.context = context;
        this.dsDetails = dsDetails;
        this.inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dsDetails.size();
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

        View view = inflater.inflate(R.layout.custom_list_billdetails,null);
        TextView txtnamedetails = view.findViewById(R.id.txtnamedetails);
        TextView soluong = view.findViewById(R.id.soluong);
        TextView prices = view.findViewById(R.id.prices);
        TextView txtgiadetails = view.findViewById(R.id.txtgiadetails);

        txtnamedetails.setText(dsDetails.get(position).getMasach());
        soluong.setText(dsDetails.get(position).getSoluong());
        prices.setText(dsDetails.get(position).getPrices());
        txtgiadetails.setText(dsDetails.get(position).getSoluong());

        return view;
    }
}
