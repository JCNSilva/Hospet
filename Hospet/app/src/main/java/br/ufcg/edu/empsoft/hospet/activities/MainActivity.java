package br.ufcg.edu.empsoft.hospet.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import br.ufcg.edu.empsoft.hospet.fragments.FilterFragment;
import br.ufcg.edu.empsoft.hospet.R;
import br.ufcg.edu.empsoft.hospet.fragments.ListFragment;
import br.ufcg.edu.empsoft.hospet.fragments.ProfileFragment;
import br.ufcg.edu.empsoft.hospet.fragments.SignupFragment;

public class MainActivity extends AppCompatActivity {
    private ProfileFragment profileFragment;
    private SignupFragment signupFragment;
    private FragmentManager fragmentManager;
    private FilterFragment filterFragment;
    private ListFragment listFragment;
    public static final String PROFILE_TAG = "PROFILE_TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setUpFragments();



    }

    /*//Mudança necessária para customizar fontes
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }*/

    private void setUpFragments() {
        profileFragment = new ProfileFragment();
        signupFragment = new SignupFragment();
        filterFragment = new FilterFragment();
        listFragment = new ListFragment();

        //lastFragment = R.id.nav_map;

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, listFragment, PROFILE_TAG);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {

    }


}
