package com.example.ahmad.agrition;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    BottomNavigationView btmView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btmView = findViewById(R.id.btmNav);
        btmView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                Fragment currentfragment = getSupportFragmentManager().findFragmentById(R.id.container);
                switch (item.getItemId()){
                    case R.id.home:
                        if (!(currentfragment instanceof Home)){
                            fragment = new Home();
                            loadFrag(fragment);
                            return true;
                        }
                        break;

                    case R.id.toko:
                        if (!(currentfragment instanceof Toko)){
                            fragment = new Toko();
                            loadFrag(fragment);
                            return true;
                        }
                        break;

                    case R.id.konsul:
                        if (!(currentfragment instanceof Konsul)){
                            fragment = new Konsul();
                            loadFrag(fragment);
                            return true;
                        }
                        break;

                    case R.id.acc:
                        if (!(currentfragment instanceof Profile)){
                            fragment = new Profile();
                            loadFrag(fragment);
                            return true;
                        }
                        break;


                }
                return false;
            }
        });
        loadFrag(new Home());
    }

    private void loadFrag (Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.commit();
    }


}
