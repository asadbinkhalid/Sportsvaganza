package com.asad.sportsvaganza.Activities;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.asad.businesslogic.Main;
import com.asad.businesslogic.Globals;
import com.asad.sportsvaganza.Fragments.FootballLiveFragment;
import com.asad.sportsvaganza.Fragments.FootballResultsFragment;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.rhexgomez.typer.roboto.TyperRoboto;
import com.asad.sportsvaganza.Adapters.ViewPagerAdapter;
import com.asad.sportsvaganza.R;
import com.asad.sportsvaganza.Fragments.FootballFixturesFragment;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import java.util.Objects;


public class Activity3_football_main extends AppCompatActivity {
    TabLayout tabLayout;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(!Globals.isLogin){
            this.onDestroy();
        }
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity3_football_scrollingtabs);
        tabLayout = findViewById(R.id.tabs);
        Toolbar toolbar = findViewById(R.id.toolbar1);
        ViewPager mViewPager = findViewById(R.id.viewpager1);

        ViewPagerAdapter mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        toolbar.setTitle(R.string.football);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Activity2_gamesList.class));
                finish();
            }
        });

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setExpandedTitleColor(Color.parseColor("#00FFFFFF"));
        collapsingToolbarLayout.setCollapsedTitleTypeface(TyperRoboto.ROBOTO_REGULAR());
        collapsingToolbarLayout.setExpandedTitleTypeface(TyperRoboto.ROBOTO_REGULAR());

        mViewPagerAdapter.addFragment(FootballLiveFragment.newInstance(),"Live");
        mViewPagerAdapter.addFragment(FootballFixturesFragment.newInstance(), "Fixtures");
        mViewPagerAdapter.addFragment(FootballResultsFragment.newInstance(), "Results");

        mViewPager.setAdapter(mViewPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton addmatchfootball = findViewById(R.id.football_add_match_button);
        addmatchfootball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity3_football_main.this, Activity4_football_addMatch.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onRestart() {
        if(!Globals.isLogin){
            this.onDestroy();
        }
        super.onRestart();
    }

    @Override
    protected void onResume() {
        if(!Globals.isLogin){
            this.onDestroy();
        }
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    public void refreshActivity(){
        Intent refresh = new Intent(this, Activity3_football_main.class);
        startActivity(refresh);
        this.finish();
    }
}
