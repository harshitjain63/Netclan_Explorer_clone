package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Initialize variables
    TabLayout tabLayout;
    ViewPager viewPager;
    ImageView refine;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // assign variable
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        navigationView=findViewById(R.id.nav_view);
        refine=findViewById(R.id.refine);
        refine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Refine.class);
                startActivity(intent);
            }
        });
        final DrawerLayout drawerLayout = findViewById(R.id.my_drawer_layout);
        findViewById(R.id.menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);// to make linear layout act as a drawer
            }

        });
        // Initialize array list
        ArrayList<String> arrayList = new ArrayList<>(0);

        // Add title in array list
        arrayList.add("Personal");
        arrayList.add("Business");
        arrayList.add("Merchant");

        // Setup tab layout
        tabLayout.setupWithViewPager(viewPager);

        // Prepare view pager
        prepareViewPager(viewPager, arrayList);

    }

    private void prepareViewPager(ViewPager viewPager, ArrayList<String> arrayList) {
        // Initialize main adapter
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());

        // Initialize main fragment
        MainFragment mainFragment = new MainFragment();

        // Use for loop
        for (int i = 0; i < arrayList.size(); i++) {
            // Initialize bundle
            Bundle bundle = new Bundle();

            // Put title
            bundle.putString("title", arrayList.get(i));

            // set argument
            mainFragment.setArguments(bundle);

            // Add fragment
            adapter.addFragment(mainFragment, arrayList.get(i));
            mainFragment = new MainFragment();
        }
        // set adapter
        viewPager.setAdapter(adapter);
    }

    private class MainAdapter extends FragmentPagerAdapter {
        // Initialize arrayList
        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();


        public MainAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        // Create constructor
        public void addFragment(Fragment fragment, String s) {
            // Add fragment
            fragmentArrayList.add(fragment);
            // Add title
            stringArrayList.add(s);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            // return fragment position
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            // Return fragment array list size
            return fragmentArrayList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {


            // Initialize spannable image
            SpannableString spannableString = new SpannableString("" + stringArrayList.get(position));


            return spannableString;
        }
    }
}