package com.example.usuario.mongodbtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;

import com.example.usuario.mongodbtest.models.Atendimento;
import com.example.usuario.mongodbtest.utils.HistoricoMedicoAdapter;
import com.example.usuario.mongodbtest.utils.PerfilAdapter;

import java.util.List;

public class HistoricoMedicoActivity extends AppCompatActivity {

    ListView lstResultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_medico);


        lstResultados = (ListView) findViewById(R.id.lstConsultas);

        List<Atendimento> atendimentos = null;
        final HistoricoMedicoAdapter adapter =
                new HistoricoMedicoAdapter(getBaseContext(), R.layout.atendimento_lista_modelo, atendimentos);
        lstResultados.setAdapter(adapter);

        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                List<Atendimento> atendimentos = null;
                if(isChecked) {
                    //atendimentos = ;
                } else {
                    //atendimentos = ;
                }
                final HistoricoMedicoAdapter adapter =
                        new HistoricoMedicoAdapter(getBaseContext(), R.layout.atendimento_lista_modelo, atendimentos);
                lstResultados.setAdapter(adapter);
            }
        });
    }

    public void cadastrarPaciente(View v) {
        Intent it = new Intent(this, ClienteCadastroActivity.class);
        startActivity(it);
    }
}
