package hernandez.perez.uca.com.taximetrodos.activities;

import android.app.Activity;
import android.app.Dialog;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.tumblr.remember.Remember;

import hernandez.perez.uca.com.taximetrodos.R;
import hernandez.perez.uca.com.taximetrodos.db.AppDatabase;
import hernandez.perez.uca.com.taximetrodos.fragments.ConductorFragment;
import hernandez.perez.uca.com.taximetrodos.fragments.SuggestionFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Dialog categoriesDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        isAuthenticated();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        refreshFragments(ConductorFragment.class);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,
                "database-name")
                .allowMainThreadQueries()
                .build();


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    /**
     * Initialize SignInActivity and finish the current activity
     */

    private void backToSignInActivity()
    {
        Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
        startActivity(intent);
        finish();
    }


    /**
     * Validate if the access_token is empty and call backToSignInActivity
     */
    private void isAuthenticated()
    {
        if(Remember.getString(getString(R.string.key_access_token),"").isEmpty())
        {
            backToSignInActivity();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment;
        Class fragmentClass =null;

        switch(item.getItemId()) {
            case R.id.nav_drivers:
                fragmentClass = ConductorFragment.class;
                break;
            case R.id.nav_show_suggestions:
                fragmentClass = SuggestionFragment.class;
                break;
            case R.id.nav_suggestions:
                Intent intent = new Intent(getApplicationContext(), SuggestionActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_resume:
                Intent intentr = new Intent(getApplicationContext(), ResumeActivity.class);
                startActivity(intentr);
                break;
            case R.id.nav_log_out:
                Remember.clear();
                backToSignInActivity();

                break;
            default:
                fragmentClass = ConductorFragment.class;
        }
        refreshFragments(fragmentClass);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        categoriesDialog.dismiss();
        refreshFragments(ConductorFragment.class);
    }

    private void refreshFragments(Class fragmentClass){

        Fragment fragment;
        try {

            fragment = (Fragment) fragmentClass.newInstance();
            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
