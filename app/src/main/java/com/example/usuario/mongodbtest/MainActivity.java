package com.example.usuario.mongodbtest;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    ImageView logo;
    EditText etUsr;
    EditText etSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo = findViewById(R.id.logo_image_view);
        logo.setImageResource(R.drawable.logo);
        etUsr = findViewById(R.id.et_login_usr);
        etSenha = findViewById(R.id.et_login_senha);



        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

    public void cadastroUsuario(View view){
        Intent it = new Intent(this, ClienteCadastroActivity.class);
        startActivity(it);
    }

    public void cadastroMedico(View view){
        Intent it = new Intent(this, MedicoCadastroActivity.class);
        startActivity(it);
    }

    public void onClick(View view){
        if(etSenha.getText().toString().equals("medico") && etUsr.getText().toString().equals("medico")){

        }
        else{

        }
    }
}
