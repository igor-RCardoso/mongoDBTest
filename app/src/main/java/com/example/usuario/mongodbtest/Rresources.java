package com.example.usuario.mongodbtest;

import android.app.DownloadManager;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;

import com.example.usuario.mongodbtest.connection.BDConn;

import org.json.JSONArray;
import org.json.JSONObject;

import request.Request;

public class Rresources{

    public static BDConn conn;

    private static final Rresources ourInstance = new Rresources();

    public static Rresources getInstance() {
        return ourInstance;
    }

    public static JSONArray arr;

    private Rresources() {
        conn = new BDConn();
        conn.execute(new Pair<Integer, String>(5000, "192.168.0.106"));
    }


    public JSONArray getEspecialidades(){
//        try {
//            Log.i("TESTE", "1");
//            BDConn._out.writeObject(new Request("select", "especialidades", new JSONArray(), ""));
//            Log.i("TESTE", "2");
//
//            Request resp = (Request)BDConn._in.readObject();
//            Log.i("TESTE", "3");
//
//            JSONArray arr = resp.JSON();
//            Log.i("TESTE", "4");
//
//
//            for(int i = 0; i < arr.length(); i++){
//                JSONObject o = arr.getJSONObject(i);
//
//                for(int j = 0; j < o.length(); j++){
//                    Log.d("specs", o.getString(o.names().getString(j)));
//                }
//            }
//            Log.i("TESTE", "5");
//
//
//            return arr;
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//
//        return null;
        return arr;
    }
}
