package com.lapremavera.groentenzoeker.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.lapremavera.Groente;
import com.lapremavera.groentenzoeker.JSONResourceReader;
import com.lapremavera.groentenzoeker.recycleview.MyRecyclerViewAdapter;
import com.lapremavera.groentenzoeker.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewDisplayActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerViewMain;
    private ArrayList<String> images = new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager;
    MyRecyclerViewAdapter adapter;

    JSONResourceReader jsonResourceReader;
    List<Groente> originalListGroente;

    Integer []thumbnail = {
            R.drawable.artisjok,
            R.drawable.courgette, R.drawable.doperwt,
            R.drawable.tomaat, R.drawable.rucola,
            R.drawable.aardpeer, R.drawable.andijvie,
            R.drawable.asperges
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_display);

        jsonResourceReader = new JSONResourceReader(this.getResources(),R.raw.groenten_data);
        originalListGroente = jsonResourceReader.constructUsingGson();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //getWidgets();



        recyclerViewMain = (RecyclerView) findViewById(R.id.my_recycler_view);
        setGridLayoutManager();
        setAdapter();

    }

//    private void getWidgets() {
//        recyclerViewMain = (RecyclerView) findViewById(R.id.my_recycler_view);
//    }


    private void setGridLayoutManager() {
        recyclerViewMain.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerViewMain.setLayoutManager(layoutManager);
        adapter = new MyRecyclerViewAdapter(thumbnail, this, originalListGroente);

    }

    private void setAdapter() {
        recyclerViewMain.setAdapter(adapter);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
