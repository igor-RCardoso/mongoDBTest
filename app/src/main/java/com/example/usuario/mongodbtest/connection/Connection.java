//package com.example.usuario.mongodbtest.connection;
//
//import android.util.Log;
//
//import com.example.usuario.mongodbtest.models.User;
//
//public class Connection {
//    private static final Connection ourInstance = new Connection();
//    private static String DB_NAME = "igordb";
//    private static String COLLECTION_NAME = "user";
//    private static String API_KEY = "ZZUxqhK4gM-sJIDdkIfI1mfHbBV6XmzG";
//
//    public static Connection getInstance() {
//        return ourInstance;
//    }
//
//    private Connection() {
//
//    }
//
////    public String getAddressSingle(User user){
////        String baseUrl = String.format("https://api.mlab.com/api/1/databases/%s/collections/%s", DB_NAME, COLLECTION_NAME);
////        StringBuilder stringBuilder = new StringBuilder(baseUrl);
////        stringBuilder.append("/" +user.get_id().getOid()+"?apiKey="+API_KEY);
////        return stringBuilder.toString();
////    }
////
////    public String getAddressAPI(){
////        String baseUrl = String.format("https://api.mlab.com/api/1/databases/%s/collections/%s", DB_NAME, COLLECTION_NAME);
////        StringBuilder stringBuilder = new StringBuilder(baseUrl);
////        stringBuilder.append("?apiKey="+API_KEY);
////        return stringBuilder.toString();
////    }
//}
