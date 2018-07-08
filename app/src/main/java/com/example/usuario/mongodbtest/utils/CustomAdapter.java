package com.example.usuario.mongodbtest.utils;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.usuario.mongodbtest.R;
import com.example.usuario.mongodbtest.models.EnderecoModel;
import com.example.usuario.mongodbtest.models.User;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private Context mContext;
    private List<EnderecoModel> lstEnd;

    public CustomAdapter(Context mContext, List<EnderecoModel> lstEnd){
        this.mContext = mContext;
        this.lstEnd = lstEnd;

    }


    @Override
    public int getCount() {
        return this.lstEnd.size();
    }

    @Override
    public Object getItem(int position) {
        return this.lstEnd.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row, null);
        TextView txtUser = (TextView) view.findViewById(R.id.txtUser);
        ImageButton btExcluir = view.findViewById(R.id.bt_exclir_linha);

        btExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lstEnd.remove(position);
                Log.i("TESTE", "detectou click");
            }
        });
        txtUser.setText(this.lstEnd.get(position).getNumero() + ", " + this.lstEnd.get(position).getRua());
        return view;
    }
}
