package com.example.usuario.mongodbtest.utils;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.usuario.mongodbtest.ClienteCadastroActivity;
import com.example.usuario.mongodbtest.R;

import org.w3c.dom.Text;

import java.util.List;

public class PerfilAdapter extends RecyclerView.Adapter<PerfilAdapter.MyViewHolder>{
    private List<Object> mDataset;
    private Activity mActivity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout mItem;
        public MyViewHolder(View v) {
            super(v);
            mItem = (LinearLayout) v.findViewById(R.id.paciente_ll);
        }
    }

    public PerfilAdapter(Activity activity) {
        mActivity = activity;
    }

    @Override
    public PerfilAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.paciente_lista_modelo, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        TextView tvNome = (TextView) holder.mItem.findViewById(R.id.lbPaciente);
//        tvNome.setText();

        TextView tvDtNasc = (TextView) holder.mItem.findViewById(R.id.lbData);
//        tvDtNasc.setText();

        TextView tvSexo = (TextView) holder.mItem.findViewById(R.id.lbSexo);
//        tvSexo.setText();

        TextView tvReputacao = (TextView) holder.mItem.findViewById(R.id.lbReputacao);
//        tvReputacao.setText();

        holder.mItem.findViewById(R.id.img_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(mActivity, ClienteCadastroActivity.class);
                //preencher o intent
                mActivity.startActivity(it);
            }
        });

        holder.mItem.findViewById(R.id.img_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //deletar do banco
                holder.mItem.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
