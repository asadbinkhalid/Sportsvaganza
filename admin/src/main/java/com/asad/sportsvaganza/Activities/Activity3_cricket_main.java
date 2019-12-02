package com.asad.sportsvaganza.Activities;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.asad.businesslogic.Globals;
import com.asad.sportsvaganza.Fragments.CricketFixturesFragment;
import com.asad.sportsvaganza.Fragments.CricketLiveFragment;

import com.asad.sportsvaganza.Fragments.CricketResultsFragment;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.rhexgomez.typer.roboto.TyperRoboto;
import com.asad.sportsvaganza.Adapters.ViewPagerAdapter;
import com.asad.sportsvaganza.R;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import java.util.Objects;


public class Activity3_cricket_main extends AppCompatActivity {
    TabLayout tabLayout;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_cricket_scrollingtabs);

//        if(!Globals.isLogin){
//            this.onDestroy();
//        }

        tabLayout = findViewById(R.id.tabs);
        Toolbar toolbar = findViewById(R.id.toolbarCricket);
        ViewPager mViewPager = findViewById(R.id.viewpager2);

        ViewPagerAdapter mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        toolbar.setTitle(R.string.cricket);
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

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.toolbar_layoutCricket);
        collapsingToolbarLayout.setExpandedTitleColor(Color.parseColor("#00FFFFFF"));
        collapsingToolbarLayout.setCollapsedTitleTypeface(TyperRoboto.ROBOTO_REGULAR());
        collapsingToolbarLayout.setExpandedTitleTypeface(TyperRoboto.ROBOTO_REGULAR());

        mViewPagerAdapter.addFragment(CricketLiveFragment.newInstance(),"Live");
        mViewPagerAdapter.addFragment(CricketFixturesFragment.newInstance(), "Fixtures");
        mViewPagerAdapter.addFragment(CricketResultsFragment.newInstance(), "Results");

        mViewPager.setAdapter(mViewPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton addmatchcricket = findViewById(R.id.cricket_add_match_button);
        addmatchcricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity3_cricket_main.this, Activity4_cricket_addMatch.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
//        if(!Globals.isLogin){
//            this.onDestroy();
//            Log.d("asad", "screen not openned because user is logged out");
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        if(!Globals.isLogin){
//            this.onDestroy();
//            Log.d("asad", "screen not openned because user is logged out");
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.button_logout) {
            FirebaseAuth.getInstance().signOut();

            Intent i = new Intent(this, Activity_Login_Main.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            //Globals.isLogin = false;
            Toast.makeText(getApplicationContext(), "Logged Out!", Toast.LENGTH_LONG).show();
            finish();


            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    public void refreshActivity(){
//        Intent refresh = new Intent(this, Activity3_football_main.class);
//        startActivity(refresh);
//        this.finish();

        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
    }
}
