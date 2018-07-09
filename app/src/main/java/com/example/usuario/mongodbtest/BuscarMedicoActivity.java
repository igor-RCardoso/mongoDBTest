package com.example.usuario.mongodbtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;

import com.example.usuario.mongodbtest.models.Medico;
import com.example.usuario.mongodbtest.utils.BuscarMedicoAdapter;

import java.util.List;

public class BuscarMedicoActivity extends AppCompatActivity {

    ListView lstResultados;
    LinearLayoutManager mLayoutManager;
    private BuscarMedicoAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_medico);
        lstResultados = (ListView) findViewById(R.id.lstMedicos);
    }

    public void buscar(View v) {
        //TODO
        List<Medico> medicos = null;
        final BuscarMedicoAdapter adapter =
                new BuscarMedicoAdapter(getBaseContext(), R.layout.medico_lista_modelo, medicos);
        lstResultados.setAdapter(adapter);
    }
}
