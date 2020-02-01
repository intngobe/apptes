package com.example.aku_pintar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_home:
                    HomeFragment br = new HomeFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fl_container, br);
                    fragmentTransaction.commit();
                    return true;
                case R.id.action_diskusi:
                    DiskusiFragment pf = new DiskusiFragment();
                    FragmentTransaction profilTransaction = getSupportFragmentManager().beginTransaction();
                    profilTransaction.replace(R.id.fl_container, pf);
                    profilTransaction.commit();
                    return true;
                case R.id.action_feed:
                    FeedFragment bt = new FeedFragment();
                    FragmentTransaction bantuanTransaction = getSupportFragmentManager().beginTransaction();
                    bantuanTransaction.replace(R.id.fl_container, bt);
                    bantuanTransaction.commit();
                    return true;
                case R.id.action_account:
                    AccountFragment tt = new AccountFragment();
                    FragmentTransaction tentangTransaction = getSupportFragmentManager().beginTransaction();
                    tentangTransaction.replace(R.id.fl_container, tt);
                    tentangTransaction.commit();
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeFragment br = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_container, br);
        fragmentTransaction.commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bn_main);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}