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

import com.example.usuario.mongodbtest.models.EnderecoModel;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MedicoCadastro2Fragment.OnMedicoCadastro2FragmentListener} interface
 * to handle interaction events.
 * Use the {@link MedicoCadastro2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MedicoCadastro2Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Button mButtonNext;
    public EditText etCep;
    public EditText etRua;
    public EditText etBairro;
    public EditText etN;
    public EditText etComplemento;
    public EditText etCidade;
    public EditText etUf;

    private OnMedicoCadastro2FragmentListener mListener;

    public MedicoCadastro2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MedicoCadastro2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MedicoCadastro2Fragment newInstance(String param1, String param2) {
        MedicoCadastro2Fragment fragment = new MedicoCadastro2Fragment();
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
        View view =  inflater.inflate(R.layout.fragment_medico_cadastro2, container, false);
        etBairro = view.findViewById(R.id.et_bairro_medico);
        etCep = view.findViewById(R.id.et_cep_medico);
        etCidade = view.findViewById(R.id.et_cidade_medico);
        etComplemento = view.findViewById(R.id.et_complemento_medico);
        etN = view.findViewById(R.id.et_n_medico);
        etRua = view.findViewById(R.id.et_rua_medico);
        etUf = view.findViewById(R.id.et_uf_medico);
        mButtonNext = view.findViewById(R.id.btCadastro2_medico);

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
//                if(validaCampos(etBairro, etCep, etCidade, etN, etRua, etUf)) {
                    mListener.goTo3(enderecoModel);
//                }
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
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMedicoCadastro2FragmentListener) {
            mListener = (OnMedicoCadastro2FragmentListener) context;
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
    public interface OnMedicoCadastro2FragmentListener {
        void goTo3(EnderecoModel enderecoModel);

    }
}
