package br.ufcg.edu.empsoft.hospet.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.ufcg.edu.empsoft.hospet.R;
import br.ufcg.edu.empsoft.hospet.activities.MainActivity;
import br.ufcg.edu.empsoft.hospet.models.ConstantesFiltro;
import br.ufcg.edu.empsoft.hospet.models.Hospedeiro;
import br.ufcg.edu.empsoft.hospet.utils.HospedeiroAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    private ListView perfis;
    private SearchView searchView;
    private ProgressDialog progress;

    private List<Hospedeiro> hospedeiros;


    public ListFragment() {
        hospedeiros = new ArrayList<>();

        Hospedeiro h1 = new Hospedeiro("Andrea Mello", "", 50.0, Calendar.getInstance(),
                Calendar.getInstance(), 1, new ArrayList<ConstantesFiltro.TipoAnimal>(),
                ConstantesFiltro.TipoLocal.CASA, new ArrayList<ConstantesFiltro.TipoPagamento>(), 500.0
                );
        Hospedeiro h2 = new Hospedeiro("Jaqueline Petkovic", "", 30.0, Calendar.getInstance(),
                Calendar.getInstance(), 0, new ArrayList<ConstantesFiltro.TipoAnimal>(),
                ConstantesFiltro.TipoLocal.CASA, new ArrayList<ConstantesFiltro.TipoPagamento>(), 10.0
        );
        Hospedeiro h3 = new Hospedeiro("Mariana Mello", "", 60.0, Calendar.getInstance(),
                Calendar.getInstance(), 0, new ArrayList<ConstantesFiltro.TipoAnimal>(),
                ConstantesFiltro.TipoLocal.CASA, new ArrayList<ConstantesFiltro.TipoPagamento>(), 50.0
        );
        Hospedeiro h4 = new Hospedeiro("Suzana Vieira", "", 50.0, Calendar.getInstance(),
                Calendar.getInstance(), 2, new ArrayList<ConstantesFiltro.TipoAnimal>(),
                ConstantesFiltro.TipoLocal.CASA, new ArrayList<ConstantesFiltro.TipoPagamento>(), 0.5
        );
        h4.setNumEstrelas(3.5);
        Hospedeiro h5 = new Hospedeiro("Gugu Liberato", "", 50.0, Calendar.getInstance(),
                Calendar.getInstance(), 1, new ArrayList<ConstantesFiltro.TipoAnimal>(),
                ConstantesFiltro.TipoLocal.APARTAMENTO, new ArrayList<ConstantesFiltro.TipoPagamento>(),1500.0
        );
        h5.setNumEstrelas(3.0);
        Hospedeiro h6 = new Hospedeiro("Richard Rasmussen", "", 110.0, Calendar.getInstance(),
                Calendar.getInstance(), 4, new ArrayList<ConstantesFiltro.TipoAnimal>(),
                ConstantesFiltro.TipoLocal.CASA, new ArrayList<ConstantesFiltro.TipoPagamento>(), 30.0
        );
        Hospedeiro h7 = new Hospedeiro("Dr. Pet", "", 20.0, Calendar.getInstance(),
                Calendar.getInstance(), 2, new ArrayList<ConstantesFiltro.TipoAnimal>(),
                ConstantesFiltro.TipoLocal.APARTAMENTO, new ArrayList<ConstantesFiltro.TipoPagamento>(), 50.0
        );
        h7.setNumEstrelas(5.0);
        Hospedeiro h8 = new Hospedeiro("Luiza Mel", "", 60.0, Calendar.getInstance(),
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_fragment, container, false);
        progress = new ProgressDialog(getContext());
        perfis = (ListView) view.findViewById(R.id.lv_perfis);
        HospedeiroAdapter adapter = new HospedeiroAdapter(getContext(), R.layout.item_profile, hospedeiros);
        perfis.setAdapter(adapter);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        getActivity().getMenuInflater().inflate(R.menu.menu_search, menu);
    }

    private void showProgress(){
        progress.setMessage(getString(R.string.carregando));
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.setProgress(0);
        progress.show();
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem mSearchMenuItem = menu.findItem(R.id.search);
        searchView = (SearchView) mSearchMenuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                showProgress();
                //TODO
                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search) {
            return true;
        } else if (id == R.id.filter) {
            FilterFragment filterFragment = new FilterFragment();
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, filterFragment, MainActivity.PROFILE_TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
