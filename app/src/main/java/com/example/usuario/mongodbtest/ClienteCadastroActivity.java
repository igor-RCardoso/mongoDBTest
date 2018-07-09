package com.example.usuario.mongodbtest;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.sql.*;

import com.example.usuario.mongodbtest.connection.BDConn;
import com.example.usuario.mongodbtest.connection.OracleRequest;
import com.example.usuario.mongodbtest.models.CartaoModel;
import com.example.usuario.mongodbtest.models.EnderecoModel;
import com.example.usuario.mongodbtest.models.Paciente;
import com.example.usuario.mongodbtest.models.Usuario;
import com.example.usuario.mongodbtest.utils.ClienteCartaoAdapter;
import com.example.usuario.mongodbtest.utils.CustomAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.shuhart.stepview.StepView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import request.Request;

public class ClienteCadastroActivity extends FragmentActivity
        implements ClienteCadastro1Fragment.OnClienteCadastro1FragmentListener,
        ClienteCadastro2Fragment.OnClienteCadastro2FragmentListener, ClienteCadastro3Fragment.OnClienteCadastro3FragmentListener{
    FrameLayout mainFrame;
    StepView stepView;

    public Usuario usr;
    public Paciente paciente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_cadastro);
        mainFrame = (FrameLayout)findViewById(R.id.main_frame);

        stepView = (StepView)findViewById(R.id.step_view_cadastro_cliente);

        stepView.getState()
                .selectedTextColor(ContextCompat.getColor(this, R.color.colorAccent))
                .animationType(StepView.ANIMATION_CIRCLE)
                .selectedCircleColor(ContextCompat.getColor(this, R.color.colorAccent))
                .selectedCircleRadius(getResources().getDimensionPixelSize(R.dimen.dp14))
                .selectedStepNumberColor(ContextCompat.getColor(this, R.color.colorPrimary))
                .steps(new ArrayList<String>() {{
                    add("Dados pessoais");
                    add("Endereços");
                    add("Financeiro");
                }})
                .stepsNumber(4)
                .animationDuration(getResources().getInteger(android.R.integer.config_shortAnimTime))
                .stepLineWidth(getResources().getDimensionPixelSize(R.dimen.dp1))
                .textSize(getResources().getDimensionPixelSize(R.dimen.sp14))
                .stepNumberTextSize(getResources().getDimensionPixelSize(R.dimen.sp16))
                .typeface(ResourcesCompat.getFont(this, R.font.roboto))
                .commit();

        ClienteCadastro1Fragment clienteCadastro1Fragment = new ClienteCadastro1Fragment();
        setFragment(clienteCadastro1Fragment);

    }


    public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }


    @Override
    public void goTo2(String nome, String cpf, String email, String tel, String cel, String senha, String repSenha, String desc, String dtNasc, String sexo) {
        //TODO Implementar o model e crirar objeto aqui...
        usr = new Usuario(nome,cpf,email,senha,tel);
        paciente = new Paciente(nome, new Date(dtNasc), sexo);
        stepView.go(1, true);
        setFragment(new ClienteCadastro2Fragment());


    }

    @Override
    public void goTo3(EnderecoModel enderecoModel) {
//        paciente = new Paciente()
        paciente.setEndereco(enderecoModel);
        stepView.go(2, true);
        setFragment(new ClienteCadastro3Fragment());
    }
//
//    @Override
//    public void addEndereco(List<EnderecoModel> enderecoModels, ListView lstView) {
//        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), enderecoModels);
//        Log.i("TESTE", lstView.getId() + "");
//        Log.i("TESTE", enderecoModels.size() + "");
//        Log.i("TESTE", adapter.toString());
//
//
//        lstView.setAdapter(adapter);
//    }

    @Override
    public void addCartao(List<CartaoModel> cartaoModels, ListView lstView) {
        ClienteCartaoAdapter adapter = new ClienteCartaoAdapter(getApplicationContext(), cartaoModels);
        lstView.setAdapter(adapter);
    }

    @Override
    public void finalizar(List<CartaoModel> cartaoModels) {
        usr.setCartoes(cartaoModels);

        usr.getDependentes().add(paciente);

        usr.saveUsr();


    }
}
