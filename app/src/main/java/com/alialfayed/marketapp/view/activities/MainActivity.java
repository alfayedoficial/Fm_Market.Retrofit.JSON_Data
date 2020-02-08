package com.alialfayed.marketapp.view.activities;

import android.os.Bundle;
import android.view.MenuItem;

import com.alialfayed.marketapp.R;
import com.alialfayed.marketapp.viewmodel.MainViewModel;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {

    public Toolbar toolbar;
    public DrawerLayout drawerLayout;
    public NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainViewModel mainViewModel = ViewModelProviders.of(this, new MainViewModelFactory(this)).get(MainViewModel.class);
        mainViewModel.viewPagerCategory();

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navView);


        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("FM Market");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_dehaze_black_24dp);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if ((item.getItemId()) == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    class MainViewModelFactory implements ViewModelProvider.Factory {
        private MainActivity mainActivity;

        MainViewModelFactory(MainActivity mActivity) {
            this.mainActivity = mActivity;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new MainViewModel(mainActivity);
        }
    }
}
