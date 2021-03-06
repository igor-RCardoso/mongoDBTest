package com.example.usuario.mongodbtest;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class ClienteCadastro1Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private OnClienteCadastro1FragmentListener mListener;

    public Button mButtonNext;
    public EditText etNome;
    public EditText etCpf;
    public EditText etEmail;
    public EditText etTel;
    public EditText etCel;
    public EditText etSenha;
    public EditText etRepSenha;
    public EditText etObs;
    public EditText etDtNasc;
    public EditText etSexo;
    public CheckBox cbHiv;
    public CheckBox cbDiabete;
    public CheckBox cbTestJeova;
    public CheckBox cbCoracao;




    public ClienteCadastro1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClienteCadastro1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClienteCadastro1Fragment newInstance(String param1, String param2) {
        ClienteCadastro1Fragment fragment = new ClienteCadastro1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cliente_cadastro1, container, false);

        mButtonNext = (Button) view.findViewById(R.id.btCadastro1);
        etNome = view.findViewById(R.id.etNome);
        etCpf = view.findViewById(R.id.etCpf);
        etEmail = view.findViewById(R.id.etEmail);
        etTel = view.findViewById(R.id.etTel);
        etCel = view.findViewById(R.id.etCel);
        etSenha = view.findViewById(R.id.etSenha);
        etRepSenha = view.findViewById(R.id.etRepetirSenha);
        etDtNasc = view.findViewById(R.id.etDtNasc);
        etSexo = view.findViewById(R.id.etSexo);
        etObs = view.findViewById(R.id.etObs);
        cbHiv = view.findViewById(R.id.cbHiv);
        cbDiabete = view.findViewById(R.id.cbDiabete);
        cbTestJeova = view.findViewById(R.id.cbTestJeova);
        cbCoracao = view.findViewById(R.id.cbCoracao);


        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String desc = "";
                if (cbHiv.isChecked()) desc = desc + "Portador de HIV, ";
                if (cbCoracao.isChecked()) desc = desc + "Problemas cardiacos, ";
                if (cbDiabete.isChecked()) desc = desc + "Diabetico, ";
                if (cbTestJeova.isChecked()) desc = desc + "Testemunha de Jeová, ";

                if(!etObs.getText().toString().isEmpty()) desc = desc  + etObs.getText().toString();

                if(validaCampos(etNome, etCpf, etEmail, etTel, etCel, etSenha, etRepSenha, etDtNasc, etSexo)) {
                    mListener.goTo2(etNome.getText().toString(), etCpf.getText().toString(),
                            etEmail.getText().toString(), etTel.getText().toString(), etCel.getText().toString(),
                            etSenha.getText().toString(), etRepSenha.getText().toString(), desc, etDtNasc.getText().toString(), etSexo.getText().toString() );
                }
            }
        });
        return view;
    }

    public boolean validaCampos(EditText etNome, EditText etCpf, EditText etEmail, EditText etTel,
                                EditText etCel, EditText etSenha, EditText etRepSenha, EditText etDtNasc, EditText etSexo){
        boolean flag = true;
        if(etNome.getText().toString().isEmpty()){
            etNome.setError("Campo obrigatório");
            flag = false;
        }
        if(etCpf.getText().toString().isEmpty()){
            etCpf.setError("Campo obrigatório");
            flag = false;
        }
        if(etEmail.getText().toString().isEmpty()){
            etEmail.setError("Campo obrigatório");
            flag = false;
        }

        if(etTel.getText().toString().isEmpty()){
            etTel.setError("Campo obrigatório");
            flag = false;
        }

        if(etCel.getText().toString().isEmpty()){
            etCel.setError("Campo obrigatório");
            flag = false;
        }
        if(etSenha.getText().toString().isEmpty()){
            etSenha.setError("Campo obrigatório");
            flag = false;
        }
        if(etRepSenha.getText().toString().isEmpty()){
            etRepSenha.setError("Campo obrigatório");
            flag = false;
        }
        if(etDtNasc.getText().toString().isEmpty()){
            etDtNasc.setError("Campo obrigatório");
            flag = false;
        }
        if(etSexo.getText().toString().isEmpty()){
            etSexo.setError("Campo obrigatório");
            flag = false;
        }


        if(!etRepSenha.getText().toString().equals(etSenha.getText().toString())){
            etRepSenha.setError("Senhas não equivalentes");
            flag = false;
        }



        return flag;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnClienteCadastro1FragmentListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " deve implementar CreateEmailListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnClienteCadastro1FragmentListener {
        void goTo2(String nome, String cpf, String email,
                     String tel, String cel, String senha, String repSenha, String desc, String dtNasc, String sexo);
    }


}
