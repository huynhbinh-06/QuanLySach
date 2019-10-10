package hbinh.com.quanlysach.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hbinh.com.quanlysach.DAO.AccountDAO;
import hbinh.com.quanlysach.Model.Account;
import hbinh.com.quanlysach.R;

import static hbinh.com.quanlysach.AddUserActivity.username;
import static hbinh.com.quanlysach.MainLoginActivity.strUsername;

public class AccountAdapter extends BaseAdapter {

    public AccountDAO accountDAO;
    public Context context;
    public ArrayList<Account> dsAccount = new ArrayList<>();
    public LayoutInflater inflater;

    public AccountAdapter(Context context, ArrayList<Account> dsAccount) {
        this.context = context;
        this.dsAccount = dsAccount;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        accountDAO = new AccountDAO(context);
    }

    @Override
    public int getCount() {
        return dsAccount.size();
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

        View view = inflater.inflate(R.layout.customlistaccount,null,false);
        final TextView txtuseraccount = view.findViewById(R.id.txtuseraccount);
        TextView sdtaccount = view.findViewById(R.id.sdtaccount);
        ImageView xoaaccount = view.findViewById(R.id.xoaaccount);

        final Account account = dsAccount.get(position);
        txtuseraccount.setText(dsAccount.get(position).getUsername());
        sdtaccount.setText(dsAccount.get(position).getSodienthoai());

        xoaaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Ban co muon xoa khong?").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {

                            if (accountDAO.deleteAccount(username)) {
                                Toast.makeText(context, "Deleted!", Toast.LENGTH_SHORT).show();
                                dsAccount.remove(account);
                                notifyDataSetChanged();
                            } else {
                                Toast.makeText(context, "Loi xoa nguoi dung!", Toast.LENGTH_SHORT).show();
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
