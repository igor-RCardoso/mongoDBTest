package com.example.usuario.mongodbtest.utils;

/**
 * Created by Geraldo on 23/06/2017.
 */

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.usuario.mongodbtest.R;
import com.example.usuario.mongodbtest.models.Atendimento;
import com.example.usuario.mongodbtest.models.Consulta;

import java.util.List;

public class AtendimentoAdapter extends ArrayAdapter<Atendimento> {
    private List<Atendimento> items;

    public AtendimentoAdapter(Context context, int textViewResourceId, List<Atendimento> items) {
        super(context, textViewResourceId, items);
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            Context ctx = getContext();
            LayoutInflater vi = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.atendimento_lista_modelo, null);
        }
        Log.i("Adapter", "Chegou aqui");
        Atendimento atendimento = items.get(position);
        if (atendimento != null) {
            ((TextView) v.findViewById(R.id.lbMedico)).setText(atendimento.getConsulta().getMedico().getNome());
            ((TextView) v.findViewById(R.id.lbPaciente)).setText(atendimento.getPaciente().getNome());
            ((TextView) v.findViewById(R.id.lbData)).setText(atendimento.getDataConsulta().toString());
        }
        return v;
    }
}