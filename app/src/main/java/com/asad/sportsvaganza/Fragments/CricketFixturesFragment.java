package com.asad.sportsvaganza.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.asad.sportsvaganza.Adapters.CricketFixturesAdapter;
import com.asad.sportsvaganza.Models.CricketFixturesModel;
import com.asad.sportsvaganza.R;

import java.util.ArrayList;
import java.util.List;


public class CricketFixturesFragment extends Fragment {

    public CricketFixturesFragment(){

    }

    public static CricketFixturesFragment newInstance() {
        CricketFixturesFragment fragment = new CricketFixturesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_cricket_fixtures, viewGroup, false);
        RecyclerView cricket_fixtures_list = view.findViewById(R.id.cricket_fixtures_list);
        cricket_fixtures_list.setLayoutManager(new LinearLayoutManager(getContext()));
        cricket_fixtures_list.setAdapter(new CricketFixturesAdapter(feedItems(), getContext()));


        return view;
    }

    private List<CricketFixturesModel> feedItems(){
        List<CricketFixturesModel> demoItems = new ArrayList<>();
        demoItems.add(new CricketFixturesModel("Team A", "Team B", "15:00", "21/2/2019"));
        demoItems.add(new CricketFixturesModel("Team C", "Team D", "17:00", "21/2/2019"));
        demoItems.add(new CricketFixturesModel("Team E", "Team F", "17:00", "22/2/2019"));
        demoItems.add(new CricketFixturesModel("Team X", "Team Y", "18:00", "22/2/2019"));

        return demoItems;
    }
}
