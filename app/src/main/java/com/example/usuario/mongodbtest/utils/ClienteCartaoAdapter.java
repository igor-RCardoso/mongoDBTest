package com.example.usuario.mongodbtest.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.usuario.mongodbtest.R;
import com.example.usuario.mongodbtest.models.CartaoModel;

import java.util.List;

public class ClienteCartaoAdapter  extends BaseAdapter {

    private Context mContext;
    private List<CartaoModel> lstCartao;

    public ClienteCartaoAdapter(Context mContext, List<CartaoModel> lstCartao){
        this.mContext = mContext;
        this.lstCartao = lstCartao;
    }


    @Override
    public int getCount() {
        return this.lstCartao.size();
    }

    @Override
    public Object getItem(int position) {
        return this.lstCartao.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row, null);
        TextView txtUser = (TextView) view.findViewById(R.id.txtUser);
        txtUser.setText(this.lstCartao.get(position).getApelido());
        return view;
    }
}