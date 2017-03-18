package org.coursera.mypentagram;

import android.Manifest;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.coursera.fragment.FavFragment;
import org.coursera.fragment.HomeFragment;
import org.coursera.org.coursera.adapter.PageAdapter;
import org.coursera.org.coursera.adapter.PetAdapter;

import java.util.ArrayList;

import static org.coursera.mypentagram.R.id.fab;
import static org.coursera.mypentagram.R.id.rvPets;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tablayout;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        tablayout = (TabLayout) findViewById(R.id.tabLayout);
        viewpager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.cat_footprint_filled_100);

        /*getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logoo);*/


        if (toolbar != null){
            setSupportActionBar(toolbar);
        }

    }

    private ArrayList<Fragment> addFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new FavFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewpager.setAdapter(new PageAdapter(getSupportFragmentManager(), addFragments()));
        tablayout.setupWithViewPager(viewpager);
        tablayout.getTabAt(0).setIcon(R.drawable.blackbone);
        tablayout.getTabAt(1).setIcon(R.drawable.ic_star);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_favorites) {
            Intent i = new Intent(this, Favorites.class);
            startActivity(i);
        }
        if(id == R.id.action_contacts){
            Intent i = new Intent(this, ContactActivity.class);
            startActivity(i);
        }
        if(id == R.id.action_about){
            Intent i = new Intent(this, AboutActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }



}
