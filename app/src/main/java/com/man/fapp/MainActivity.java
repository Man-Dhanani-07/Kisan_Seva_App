package com.man.fapp;

import static android.app.PendingIntent.getActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.man.fapp.Fragment.FragmentChat;
import com.man.fapp.Fragment.FragmentInformation;
import com.man.fapp.Fragment.FragmentProfile;
import com.man.fapp.Fragment.FragmentQuality;
import com.man.fapp.Fragment.Item_list;
import com.man.fapp.Model.Order_Activity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    FragmentManager fragmentManager;
    private Fragment currentFragment;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.chk);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_drawer);
        navigationView.setNavigationItemSelectedListener(this);
        bottomNavigationView = findViewById(R.id.bottomnavigationview);
         bottomNavigationView.setBackground(null);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, new Item_list());
        transaction.commit();
        bottomNavigationView = findViewById(R.id.bottomnavigationview);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if (item.getItemId() == R.id.home) {
//                    transaction.replace(R.id.content,new Item_list());
                    getSupportFragmentManager().popBackStack();
//                    transaction.commit();
                } else if (item.getItemId() == R.id.quality) {
                    transaction.replace(R.id.content, new FragmentQuality());
                    transaction.addToBackStack(null);
//                    transaction.commit();
                    getSupportFragmentManager().popBackStack();
                } else if (item.getItemId() == R.id.chat) {
                    transaction.replace(R.id.content, new FragmentChat());
                    transaction.addToBackStack(null);
//                    transaction.commit();
                    getSupportFragmentManager().popBackStack();
                } else if (item.getItemId() == R.id.info) {
                    transaction.replace(R.id.content, new FragmentInformation());
                    transaction.addToBackStack(null);
//                    transaction.commit();
                    getSupportFragmentManager().popBackStack();
                } else if (item.getItemId() == R.id.profile) {
                    transaction.replace(R.id.content, new FragmentProfile());
                    transaction.addToBackStack(null);
//                    transaction.commit();
                    getSupportFragmentManager().popBackStack();
                }
                transaction.commit();
                return true;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void openFragment(Fragment fragment) {
        FragmentManager fragmentManager1 = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager1.beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemidd = item.getItemId();
        if (itemidd == R.id.nav_language) {
            Intent i = new Intent(MainActivity.this,Change_language.class);
            startActivity(i);
//            Toast.makeText(this, "Translate", Toast.LENGTH_SHORT).show();
        }
        else if(itemidd==R.id.nav_weather){
            Intent i = new Intent(MainActivity.this, wheather_activity.class);
            startActivity(i);
        }
        else if (itemidd==R.id.nav_orders){
            Intent i = new Intent(MainActivity.this, Order_Activity.class);
            startActivity(i);
        }
        drawerLayout.closeDrawer(GravityCompat.START);
//             transaction.commit();
        return true;
    }


}