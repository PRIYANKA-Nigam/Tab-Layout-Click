package com.example.tablayoutclick;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
private TabLayout tabLayout;
private ViewPager viewPager;
private ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=(TabLayout)findViewById(R.id.tab);
        viewPager=findViewById(R.id.vv);
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.AddFragment(new FragmentCall(),"Call");
        viewPagerAdapter.AddFragment(new FragmentContact(),"Contact"); //adding Fragments
        viewPagerAdapter.AddFragment(new FragmentFav(),"Favourite");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.call);
        tabLayout.getTabAt(1).setIcon(R.drawable.chat);
        tabLayout.getTabAt(2).setIcon(R.drawable.favorite);
        ActionBar actionBar=getSupportActionBar();   //Remove Shadow from the action bar
        actionBar.setElevation(0);
    }


}