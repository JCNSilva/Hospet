package br.ufcg.edu.empsoft.hospet.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import br.ufcg.edu.empsoft.hospet.R;

public class SignupFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TAG = "SignupFragment";

    private EditText nomeDono;
    private EditText estadoDono;
    private EditText cidadeDono;
    private EditText enderecoDono;
    private EditText nomeAnimal;
    private EditText especieAnimal;
    private EditText racaAnimal;
    private EditText infoAnimal;
    private ImageButton addFotoPerfil;
    private ImageButton addFotoGaleria;
    private ImageView fotoGaleria1;
    private ImageView fotoGaleria2;
    private ImageView fotoGaleria3;
    private Button concluirCadastro;


    public SignupFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        setUpViews(view);
        return view;
    }

    private void setUpViews(View view) {
        this.nomeDono = (EditText)  view.findViewById(R.id.et_nome_dono);
        this.estadoDono = (EditText) view.findViewById(R.id.et_estado_dono);
        this.cidadeDono = (EditText) view.findViewById(R.id.et_cidade_dono);
        this.enderecoDono = (EditText) view.findViewById(R.id.et_endereco_dono);
        this.nomeAnimal = (EditText) view.findViewById(R.id.et_nome_animal);
        this.especieAnimal = (EditText) view.findViewById(R.id.et_tipo_animal);
        this.racaAnimal = (EditText) view.findViewById(R.id.et_raca_animal);
        this.infoAnimal = (EditText) view.findViewById(R.id.et_info_animal);
        this.addFotoPerfil = (ImageButton) view.findViewById(R.id.ib_foto_perfil);
        this.addFotoGaleria = (ImageButton) view.findViewById(R.id.ib_foto_galeria);
        this.fotoGaleria1 = (ImageView) view.findViewById(R.id.iv_foto1);
        this.fotoGaleria2 = (ImageView) view.findViewById(R.id.iv_foto2);
        this.fotoGaleria3 = (ImageView) view.findViewById(R.id.iv_foto3);
        this.concluirCadastro = (Button) view.findViewById(R.id.btn_concluir_cadastro);
    }

    /*// TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
