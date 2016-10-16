package br.ufcg.edu.empsoft.hospet.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.ufcg.edu.empsoft.hospet.R;
import br.ufcg.edu.empsoft.hospet.models.ConstantesFiltro;
import br.ufcg.edu.empsoft.hospet.models.Hospedeiro;
import br.ufcg.edu.empsoft.hospet.utils.HospedeiroAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    private ListView perfis;

    private List<Hospedeiro> hospedeiros;


    public ListFragment() {
        hospedeiros = new ArrayList<>();

        Hospedeiro h1 = new Hospedeiro("Andrea Mello", "", 50.0, Calendar.getInstance(),
                Calendar.getInstance(), 1, new ArrayList<ConstantesFiltro.TipoAnimal>(),
                ConstantesFiltro.TipoLocal.CASA, new ArrayList<ConstantesFiltro.TipoPagamento>(), 500.0
                );
        Hospedeiro h2 = new Hospedeiro("Silvana Mello", "", 30.0, Calendar.getInstance(),
                Calendar.getInstance(), 0, new ArrayList<ConstantesFiltro.TipoAnimal>(),
                ConstantesFiltro.TipoLocal.CASA, new ArrayList<ConstantesFiltro.TipoPagamento>(), 10.0
        );
        Hospedeiro h3 = new Hospedeiro("Mariana Mello", "", 60.0, Calendar.getInstance(),
                Calendar.getInstance(), 0, new ArrayList<ConstantesFiltro.TipoAnimal>(),
                ConstantesFiltro.TipoLocal.CASA, new ArrayList<ConstantesFiltro.TipoPagamento>(), 50.0
        );
        Hospedeiro h4 = new Hospedeiro("Ze do Alho", "", 50.0, Calendar.getInstance(),
                Calendar.getInstance(), 2, new ArrayList<ConstantesFiltro.TipoAnimal>(),
                ConstantesFiltro.TipoLocal.CASA, new ArrayList<ConstantesFiltro.TipoPagamento>(), 0.5
        );
        Hospedeiro h5 = new Hospedeiro("Gugu Liberato", "", 50.0, Calendar.getInstance(),
                Calendar.getInstance(), 1, new ArrayList<ConstantesFiltro.TipoAnimal>(),
                ConstantesFiltro.TipoLocal.APARTAMENTO, new ArrayList<ConstantesFiltro.TipoPagamento>(),1500.0
        );
        Hospedeiro h6 = new Hospedeiro("Sheilla Mello", "", 110.0, Calendar.getInstance(),
                Calendar.getInstance(), 4, new ArrayList<ConstantesFiltro.TipoAnimal>(),
                ConstantesFiltro.TipoLocal.CASA, new ArrayList<ConstantesFiltro.TipoPagamento>(), 30.0
        );
        Hospedeiro h7 = new Hospedeiro("Sheilla Carvalho", "", 20.0, Calendar.getInstance(),
                Calendar.getInstance(), 2, new ArrayList<ConstantesFiltro.TipoAnimal>(),
                ConstantesFiltro.TipoLocal.APARTAMENTO, new ArrayList<ConstantesFiltro.TipoPagamento>(), 50.0
        );
        Hospedeiro h8 = new Hospedeiro("Nazare Tedesco", "", 60.0, Calendar.getInstance(),
                Calendar.getInstance(), 0, new ArrayList<ConstantesFiltro.TipoAnimal>(),
                ConstantesFiltro.TipoLocal.CASA, new ArrayList<ConstantesFiltro.TipoPagamento>(), 10.0
        );
        h8.setNumEstrelas(4.5);
        hospedeiros.add(h1);
        hospedeiros.add(h2);
        hospedeiros.add(h3);
        hospedeiros.add(h4);
        hospedeiros.add(h5);
        hospedeiros.add(h6);
        hospedeiros.add(h7);
        hospedeiros.add(h8);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_fragment, container, false);

        perfis = (ListView) view.findViewById(R.id.lv_perfis);
        HospedeiroAdapter adapter = new HospedeiroAdapter(getContext(), R.layout.item_profile, hospedeiros);
        perfis.setAdapter(adapter);
        return view;
    }

}
