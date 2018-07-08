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
import android.widget.ListView;

import com.example.usuario.mongodbtest.models.CartaoModel;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ClienteCadastro3Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ClienteCadastro3Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClienteCadastro3Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EditText etN;
    public EditText etTitular;
    public EditText etApelido;
    public Button mButtonAdd;
    public ListView lstView;

    public List<CartaoModel> cartaoModels;

    private OnClienteCadastro3FragmentListener mListener;

    public ClienteCadastro3Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClienteCadastro3Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClienteCadastro3Fragment newInstance(String param1, String param2) {
        ClienteCadastro3Fragment fragment = new ClienteCadastro3Fragment();
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
        View view = inflater.inflate(R.layout.fragment_cliente_cadastro3, container, false);
        etApelido = view.findViewById(R.id.apelido);
        etN = view.findViewById(R.id.num);
        etTitular = view.findViewById(R.id.nm_titular);
        mButtonAdd = view.findViewById(R.id.bt_add_cartao);
        lstView = view.findViewById(R.id.list_view_financeiro);

        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartaoModel cartaoModel = new CartaoModel(etN.getText().toString(), etTitular.getText().toString(),
                        etApelido.getText().toString());
                cartaoModels.add(cartaoModel);
                mListener.addCartao(cartaoModels, lstView);
            }
        });




        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnClienteCadastro3FragmentListener) context;
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public interface OnClienteCadastro3FragmentListener {
        void addCartao(List<CartaoModel> cartaoModels, ListView lstView);
    }
}
