package br.ufcg.edu.empsoft.hospet.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import br.ufcg.edu.empsoft.hospet.models.Profile;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

import br.ufcg.edu.empsoft.hospet.R;
import br.ufcg.edu.empsoft.hospet.utils.ProfileAdapter;

public class ProfileFragment extends Fragment {
    private List<Profile> profileList;

    private static final int VAZIO = 0;
    public static ProfileAdapter adapter;
    private SearchView searchView;
    //    private ProgressDialog progress;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView listaProfile;
    private CardView campoProfile;
    private LinearLayout erro;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        listaProfile = (RecyclerView) view.findViewById(R.id.rview_disciplinas);
        campoProfile = (CardView) view.findViewById(R.id.ll_profile);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_layout);
        erro = (LinearLayout) view.findViewById(R.id.erro);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        listaProfile.setLayoutManager(llm);
        profileList = new ArrayList<Profile>();
        campoProfile.setVisibility(View.GONE);
        getTodosProfiles();

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        getActivity().getMenuInflater().inflate(R.menu.menu_search, menu);
    }
    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem mSearchMenuItem = menu.findItem(R.id.menuSearch);
        searchView = (SearchView) mSearchMenuItem.getActionView();

//        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
//            @Override
//            public boolean onClose() {
//                Log.d("fecho", "true");
//                campoDisciplinas.setVisibility(View.GONE);
//                erro.setVisibility(View.GONE);
////                showProgress();
//                if (disciplinasBuscadas.size() == 0) {
//                    Log.d("fecho23", "true");
//                    getTodasDisciplinas();
//                    refresh();
//                }
//                return false;
//            }
//        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
//                showProgress();

                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }

//            @Override
//            public boolean onQueryTextChange(String newText) {
//                if (newText.trim().isEmpty()) {
////                    showProgress();
//                    Log.d("fecho", "true2");
//                    disciplinasBuscadas = new ArrayList<Disciplina>();
//                    getTodasDisciplinas();
//                    refresh();
//                    return true;
//                }
//                return true;
//            }
        });
    }
    @Override
    public void onResume() {
        getTodosProfiles();
        super.onResume();
        refresh();
    }
    private void refresh() {
        adapter = new ProfileAdapter(new ArrayList<Profile>((ArrayList)profileList), getContext());
        listaProfile.setAdapter(adapter);
//        mSwipeRefreshLayout.setRefreshing(false);
    }
    private void refreshContent(){
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                getTodosProfiles();
//                mSwipeRefreshLayout.setRefreshing(false);

            }
        });
    }

    public void getTodosProfiles() {
        mSwipeRefreshLayout.setRefreshing(true);
        Profile joao = new Profile();
        profileList.add(joao);
        campoProfile.setVisibility(View.VISIBLE);
        erro.setVisibility(View.GONE);
    }
}