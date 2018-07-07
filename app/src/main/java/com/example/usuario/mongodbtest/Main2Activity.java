package com.example.usuario.mongodbtest;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.usuario.mongodbtest.models.User;
//import com.example.usuario.mongodbtest.utils.CustomAdapter;
//import com.facebook.common.Common;
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    ListView lstView;
    Button btAdd, btEdit, btDelete;
    EditText edtUser;
    User userSelected = null;
    List<User> users = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lstView = (ListView)findViewById(R.id.lstView);
        edtUser = (EditText)findViewById(R.id.edtUser);
//        new GetData().execute(Connection.getInstance().getAddressAPI());
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                userSelected = users.get(position);
                edtUser.setText(userSelected.getUser());
            }
        });

    }
//
//    public void addClick(View view){
//        new PostData(edtUser.getText().toString()).execute(Connection.getInstance().getAddressAPI());
//    }
//    public void editClick(View view){
//        new PutData(edtUser.getText().toString()).execute(Connection.getInstance().getAddressSingle(userSelected));
//    }
//    public void deleteClick(View view){
//        new DeleteData(userSelected).execute(Connection.getInstance().getAddressSingle(userSelected));
//    }
//
//    class GetData extends AsyncTask<String, Void, String>{
//        ProgressDialog pd = new ProgressDialog(Main2Activity.this);
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            pd.setTitle("Please wait...");
//            pd.show();
//        }
//
//        @Override
//        protected String doInBackground(String... strings) {
//            String stream = null;
//            String urlString = strings[0];
//            HTTPDataHandler http = new HTTPDataHandler();
//            stream = http.GetHTTPData(urlString);
//            return stream;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            Gson gson = new Gson();
//            Type listType = new TypeToken<List<User>>(){}.getType();
//            users=gson.fromJson(s, listType);
//            CustomAdapter adapter = new CustomAdapter(getApplicationContext(), users);
//            lstView.setAdapter(adapter);
//            pd.dismiss();
//        }
//
//
//    }
//    class PostData extends AsyncTask<String, String, String>{
//        ProgressDialog pd = new ProgressDialog(Main2Activity.this);
//        String userName;
//        public PostData(String userName){
//            this.userName = userName;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            pd.setTitle("Please wait...");
//            pd.show();
//        }
//
//        @Override
//        protected String doInBackground(String... strings) {
//
//            String urlString = strings[0];
//            HTTPDataHandler http = new HTTPDataHandler();
//            String json = "{\"user\":\""+userName+"\"}";
//            http.PostHTTPData(urlString, json);
//            return "";
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
////            new GetData().execute(Connection.getInstance().getAddressAPI());
//            pd.dismiss();
//        }
//
//
//    }
//    class PutData extends AsyncTask<String, String, String>{
//        ProgressDialog pd = new ProgressDialog(Main2Activity.this);
//        String userName;
//        public PutData(String userName){
//            this.userName = userName;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            pd.setTitle("Please wait...");
//            pd.show();
//        }
//
//        @Override
//        protected String doInBackground(String... strings) {
//
//            String urlString = strings[0];
//            HTTPDataHandler http = new HTTPDataHandler();
//            String json = "{\"user\":\""+userName+"\"}";
//            http.PutHTTPData(urlString, json);
//            return "";
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            new GetData().execute(Connection.getInstance().getAddressAPI());
//            pd.dismiss();
//        }
//
//
//    }
//    class DeleteData extends AsyncTask<String, String, String>{
//        ProgressDialog pd = new ProgressDialog(Main2Activity.this);
//        User user;
//        public DeleteData(User user){
//            this.user = user;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            pd.setTitle("Please wait...");
//            pd.show();
//        }
//
//        @Override
//        protected String doInBackground(String... strings) {
//
//            String urlString = strings[0];
//            HTTPDataHandler http = new HTTPDataHandler();
//            String json = "{\"user\":\""+user.getUser()+"\"}";
//            Log.i("TESTE", json.toString());
//            http.DeleteHTTPData(urlString, json);
//            return "";
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            new GetData().execute(Connection.getInstance().getAddressAPI());
//            pd.dismiss();
//        }
//
//
//    }
//

}
