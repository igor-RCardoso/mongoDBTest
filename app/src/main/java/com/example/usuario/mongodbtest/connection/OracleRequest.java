package com.example.usuario.mongodbtest.connection;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import request.Request;

import static java.lang.Thread.sleep;

public class OracleRequest extends AsyncTask<Request, Void, Request> {
    private boolean _validExit;
    private static Request response;

    public Request getRequest(){
        Log.d("orcl", "Tentando pegar request");
        while(!_validExit){
            try {
                sleep(1);
            } catch (InterruptedException e) {
                Log.d("oracle", e.getClass().getSimpleName() + ": " + e.getMessage());
            }
        }

        Log.d("orcl", "Request retirado");

        return response;
    }

    @Override
    public void onPreExecute(){
        _validExit = false;
    }

    @Override
    public Request doInBackground(Request... params){

        while(!BDConn.setConn){
            Log.d("orcl", "Esperando conexao ser estabelecida...");
            try {
                sleep(1);
            } catch (InterruptedException e) {
                Log.d("orcl", e.getClass().getSimpleName() + ": " + e.getMessage());
            }
        }

        Log.d("orcl","Conexão estabelecida. Enviando request...");

        try {
            BDConn._out.writeObject(params[0]);

            Log.d("orcl","Request enviado...");

            Request resposta = (Request)BDConn._in.readObject();

            Log.d("orcl","Resposta recebida...");

            //Log.d("resp", resposta.toString());

            return null;
        } catch (IOException e) {
            Log.d("orcl", e.getClass().getSimpleName() + ": " + e.getMessage());
        } catch (ClassNotFoundException e) {
            Log.d("orcl", e.getClass().getSimpleName() + ": " + e.getMessage());
        }

        return null;

    }

    @Override
    public void onPostExecute(Request resp){
        Log.d("orcl", "postExecute lançado");
        response = resp;
        _validExit = true;
    }
}