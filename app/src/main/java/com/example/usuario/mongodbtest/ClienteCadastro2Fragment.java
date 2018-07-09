package com.example.usuario.mongodbtest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.usuario.mongodbtest.models.EnderecoModel;
import com.example.usuario.mongodbtest.utils.CustomAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ClienteCadastro2Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ClienteCadastro2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClienteCadastro2Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnClienteCadastro2FragmentListener mListener;

//    public Button mButtonAdd;
    public Button mButtonNext;
    public EditText etCep;
    public EditText etRua;
    public EditText etBairro;
    public EditText etN;
    public EditText etComplemento;
    public EditText etCidade;
    public EditText etUf;
//    public ListView lstView;

    public List<EnderecoModel> enderecoModels;

    @Override
    public void setEnterTransition(@Nullable Object transition) {
        super.setEnterTransition(transition);
    }

    public ClienteCadastro2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClienteCadastro2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClienteCadastro2Fragment newInstance(String param1, String param2) {
        ClienteCadastro2Fragment fragment = new ClienteCadastro2Fragment();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cliente_cadastro2, container, false);

//        mButtonAdd = view.findViewById(R.id.addEnd);
        etBairro = view.findViewById(R.id.et_bairro);
        etCep = view.findViewById(R.id.et_cep);
        etCidade = view.findViewById(R.id.et_cidade);
        etComplemento = view.findViewById(R.id.et_complemento);
        etN = view.findViewById(R.id.et_n);
        etRua = view.findViewById(R.id.et_rua);
        etUf = view.findViewById(R.id.et_uf);
//        lstView = view.findViewById(R.id.list_view_endereco);
        mButtonNext = view.findViewById(R.id.btCadastro2);

//        lstView.getId();

//        enderecoModels = new ArrayList<EnderecoModel>();

//        mButtonAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                EnderecoModel enderecoModel = new EnderecoModel(etRua.getText().toString(), etN.getText().toString(),
//                etBairro.getText().toString(), etCidade.getText().toString(), etUf.getText().toString(),
//                etComplemento.getText().toString(), etCep.getText().toString());
//                if(validaCampos(etBairro, etCep, etCidade, etN, etRua, etUf)) {
//                    enderecoModels.add(enderecoModel);
//                    mListener.addEndereco(enderecoModels, lstView);
//                    etCep.setText("");
//                    etBairro.setText("");
//                    etCidade.setText("");
//                    etComplemento.setText("");
//                    etN.setText("");
//                    etUf.setText("");
//                    etRua.setText("");
//                }

//            }
//        });
        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnderecoModel enderecoModel = new EnderecoModel(etRua.getText().toString(), etN.getText().toString(),
                etBairro.getText().toString(), etCidade.getText().toString(), etUf.getText().toString(),
                etComplemento.getText().toString(), etCep.getText().toString());
                if(validaCampos(etBairro, etCep, etCidade, etN, etRua, etUf)) {
                    mListener.goTo3(enderecoModel);
                }
            }
        });


        return view;
    }

    boolean validaCampos(EditText etBairro, EditText etCep, EditText etCidade,
                         EditText etN, EditText etRua, EditText etUf){
        boolean flag = true;
        if(etBairro.getText().toString().isEmpty()){
            etBairro.setError("Campo obrigatório");
            flag = false;
        }
        if(etCep.getText().toString().isEmpty()){
            etCep.setError("Campo obrigatório");
            flag = false;
        }if(etCidade.getText().toString().isEmpty()){
            etCidade.setError("Campo obrigatório");
            flag = false;
        }if(etN.getText().toString().isEmpty()){
            etN.setError("Campo obrigatório");
            flag = false;
        }if(etRua.getText().toString().isEmpty()){
            etRua.setError("Campo obrigatório");
            flag = false;
        }
        if(etUf.getText().toString().isEmpty()){
            etUf.setError("Campo obrigatório");
            flag = false;
        }

        return flag;



    }

    // TODO: Rename method, update argument and hook method into UI event

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnClienteCadastro2FragmentListener) context;
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public interface OnClienteCadastro2FragmentListener {
        void goTo3(EnderecoModel enderecoModel);

//        void addEndereco(List<EnderecoModel> enderecoModels, ListView lstView);
    }

}
