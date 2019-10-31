package com.asad.sportsvaganza.Activities;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.asad.sportsvaganza.Fragments.CricketFixturesFragment;
import com.asad.sportsvaganza.Fragments.CricketLiveFragment;

import com.asad.sportsvaganza.Fragments.CricketResultsFragment;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.rhexgomez.typer.roboto.TyperRoboto;
import com.asad.sportsvaganza.Adapters.ViewPagerAdapter;
import com.asad.sportsvaganza.R;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;


public class Activity3_cricket_main extends AppCompatActivity {
    TabLayout tabLayout;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_cricket_scrollingtabs);
        tabLayout = findViewById(R.id.tabs);
        Toolbar toolbar = findViewById(R.id.toolbarCricket);
        ViewPager mViewPager = findViewById(R.id.viewpager2);

        ViewPagerAdapter mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        toolbar.setTitle(R.string.cricket);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.toolbar_layoutCricket);
        collapsingToolbarLayout.setExpandedTitleColor(Color.parseColor("#00FFFFFF"));
        collapsingToolbarLayout.setCollapsedTitleTypeface(TyperRoboto.ROBOTO_REGULAR());
        collapsingToolbarLayout.setExpandedTitleTypeface(TyperRoboto.ROBOTO_REGULAR());

        mViewPagerAdapter.addFragment(CricketLiveFragment.newInstance(),"Live");
        mViewPagerAdapter.addFragment(CricketFixturesFragment.newInstance(), "Fixtures");
        mViewPagerAdapter.addFragment(CricketResultsFragment.newInstance(), "Results");

        mViewPager.setAdapter(mViewPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);


    }
}
