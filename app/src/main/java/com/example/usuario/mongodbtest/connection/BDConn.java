package com.example.usuario.mongodbtest.connection;

import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class BDConn extends AsyncTask<Pair<Integer, String>, Void, Void> {

    static public Socket socket;
    static public ObjectOutputStream _out;
    static public ObjectInputStream _in;

    static public boolean setConn = false;

    @Override
    public Void doInBackground(Pair<Integer, String>... params){
        try {
            Log.d("socket", "Iniciando conexao com " + params[0].second + ":" + params[0].first);
            socket = new Socket(params[0].second, params[0].first);
            _out = new ObjectOutputStream(socket.getOutputStream());
            _in = new ObjectInputStream(socket.getInputStream());
            Log.d("socket", "Conexão estabelecida, Streams criados com sucesso...");
        } catch (IOException e) {
            Log.d("socket", e.getClass().getSimpleName() + ": " + e.getMessage());
        }
        setConn = true;
        return null;
    }
}