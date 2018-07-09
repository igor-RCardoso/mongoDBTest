package com.example.usuario.mongodbtest.models;

import android.util.Log;
import android.util.Pair;

import com.example.usuario.mongodbtest.connection.BDConn;
import com.example.usuario.mongodbtest.connection.OracleRequest;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import request.Request;

public class Usuario implements Serializable{

    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String telefone;
    private List<CartaoModel> cartoes;
    private List<Paciente> dependentes;

    public List<Paciente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Paciente> dependentes) {
        this.dependentes = dependentes;
    }

    public List<CartaoModel> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<CartaoModel> cartoes) {
        this.cartoes = cartoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Usuario(String nome, String cpf, String email, String senha, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        dependentes = new ArrayList<>();
    }


    public void saveUsr(){
        String sqlFinal = "";
        for(int i = 0; i < dependentes.size(); i++){
            Paciente pac = dependentes.get(i);
            EnderecoModel ends = dependentes.get(i).getEndereco();
            String sqlEndereco = "";
//            for(int j = 0; j < ends.size(); j++) {
                EnderecoModel end = ends;
                String sqlQ = "insert into enderecos values(";
                sqlQ += Integer.toString(EnderecoModel.contador) + ", '" + end.getUF() + "', '" + end.getCidade() + "', '";
                sqlQ += end.getBairro() + "', '" + end.getRua() + "', '";
                sqlQ += end.getComplemento() + "', '" + end.getCep() + "');\n";
                sqlFinal += sqlQ;
//            }

            String sqlQuery = "insert into pacientes values('";
            sqlQuery += pac.getNome() + "', '', to_date('" + new SimpleDateFormat("yyyy-MM-dd").format(pac.getDataNasc()) + "', 'YYYY-MM-DD'),";
            sqlQuery += "'" + pac.getSexo() + "', '',";
            sqlQuery += "(select ref(e) from enderecos e where e.id = " + Integer.toString(EnderecoModel.contador) + "));\n";
            EnderecoModel.contador++;
            sqlFinal += sqlQuery;
        }

        String sqlQuery = "insert into usuarios values('";
        sqlQuery += nome + "', '" + cpf + "', '" + email + "', '" + senha + "', '" + telefone + "', ";
        sqlQuery += "list_cartao(";
        for(int i = 0; i < cartoes.size(); i++){
            CartaoModel card = cartoes.get(i);
            if(i != 0){
                sqlQuery += ",";
            }
            sqlQuery += "t_cartao('" + card.getNmTitular() + "', to_date('2018-12-15', 'YYYY-MM-DD'), '" + card.getNumero() + "')";
        }
        sqlQuery += "), ";
        sqlQuery += "(select cast(collect(ref(p)) as list_paciente) from pacientes p where p.nome = '" + nome+ "'))\n";

        sqlFinal += sqlQuery;

        BDConn db = new BDConn();
        db.execute(new Pair<Integer, String>(5000, "192.168.0.106"));

        OracleRequest orc = new OracleRequest();

        try {
            orc.execute(new Request("query", sqlFinal, new JSONArray(), ""));
            Log.d("json", "enviado");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
