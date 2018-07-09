package com.example.usuario.mongodbtest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class MedicoCadastro1Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnMedicoCadastro1FragmentListener mListener;

    public Button mButtonNext;
    public EditText etNome;
    public EditText etCpf;
    public EditText etCrm;
    public EditText etEmail;
    public EditText etTel;
    public EditText etCel;
    public EditText etSenha;
    public EditText etRepSenha;

    public MedicoCadastro1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MedicoCadastro1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MedicoCadastro1Fragment newInstance(String param1, String param2) {
        MedicoCadastro1Fragment fragment = new MedicoCadastro1Fragment();
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
        View view = inflater.inflate(R.layout.fragment_medico_cadastro1, container, false);

        mButtonNext = (Button) view.findViewById(R.id.btCadastro1_medico);
        etNome = view.findViewById(R.id.etNome_medico);
        etCpf = view.findViewById(R.id.etCpf_medico);
        etCrm = view.findViewById(R.id.etCrm_medico);
        etEmail = view.findViewById(R.id.etEmail_medico);
        etTel = view.findViewById(R.id.etTel_medico);
        etCel = view.findViewById(R.id.etCel_medico);
        etSenha = view.findViewById(R.id.etSenha_medico);
        etRepSenha = view.findViewById(R.id.etRepetirSenha_medico);

        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //if(validaCampos(etNome, etCpf, etCrm, etEmail, etTel, etCel, etSenha, etRepSenha)) {
                    mListener.goTo2(etNome.getText().toString(), etCpf.getText().toString(), etCrm.getText().toString(),
                            etEmail.getText().toString(), etTel.getText().toString(), etCel.getText().toString(),
                            etSenha.getText().toString(), etRepSenha.getText().toString());
//                }
            }
        });
        return view;
    }

    public boolean validaCampos(EditText etNome, EditText etCpf,EditText etCrm, EditText etEmail, EditText etTel,
                                EditText etCel, EditText etSenha, EditText etRepSenha){
        boolean flag = true;
        if(etNome.getText().toString().isEmpty()){
            etNome.setError("Campo obrigatório");
            flag = false;
        }
        if(etCpf.getText().toString().isEmpty()){
            etCpf.setError("Campo obrigatório");
            flag = false;
        }
        if(etCrm.getText().toString().isEmpty()){
            etCrm.setError("Campo obrigatório");
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


        if(!etRepSenha.getText().toString().equals(etSenha.getText().toString())){
            etRepSenha.setError("Senhas não equivalentes");
            flag = false;
        }



        return flag;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMedicoCadastro1FragmentListener) {
            mListener = (OnMedicoCadastro1FragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */


    public interface OnMedicoCadastro1FragmentListener {
        void goTo2(String nome, String cpf, String crm, String email,
                   String tel, String cel, String senha, String repSenha);
    }
}
