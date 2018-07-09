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
import com.example.usuario.mongodbtest.models.Medico;

import java.util.List;

public class BuscarMedicoAdapter extends ArrayAdapter<Medico> {
    private List<Medico> items;

    public BuscarMedicoAdapter(Context context, int textViewResourceId, List<Medico> items) {
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
        Medico medico = items.get(position);
        if (medico != null) {
            ((TextView) v.findViewById(R.id.lbMedico)).setText(medico.getNome());
            ((TextView) v.findViewById(R.id.lbCpf)).setText(medico.getCpf());
            ((TextView) v.findViewById(R.id.lbCRM)).setText(medico.getCrm());
        }
        return v;
    }
}