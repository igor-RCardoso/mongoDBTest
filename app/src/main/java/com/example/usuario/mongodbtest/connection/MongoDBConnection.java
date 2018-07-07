//package com.example.usuario.mongodbtest.connection;
//
//import android.util.Log;
//
//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//
//import org.bson.Document;
//
//public class MongoDBConnection {
//    private static final MongoDBConnection ourInstance = new MongoDBConnection();
//
//    public static MongoDBConnection getInstance() {
//        return ourInstance;
//    }
//
//    private MongoDBConnection() {
//    }
//
//    public static void addToDatabase(String username){
//        MongoClientURI uri  = new MongoClientURI(""); //ver values/strings
//        MongoClient client = new MongoClient(uri);
//        MongoDatabase db = client.getDatabase(uri.getDatabase());
//        MongoCollection<Document> coll = db.getCollection("user");
//        Log.i("TESTE", "TESTE3");
//        Document doc = new Document("username", username);
//        coll.insertOne(doc);
//        client.close();
//    }
//}
