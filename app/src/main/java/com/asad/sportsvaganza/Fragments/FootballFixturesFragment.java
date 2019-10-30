package com.asad.sportsvaganza.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.asad.sportsvaganza.Adapters.FootballFixturesAdapter;
import com.asad.sportsvaganza.Models.FootballFixturesModel;
import com.asad.sportsvaganza.R;

import java.util.ArrayList;
import java.util.List;


public class FootballFixturesFragment extends Fragment {

    public FootballFixturesFragment(){

    }

    public static FootballFixturesFragment newInstance() {
        FootballFixturesFragment fragment = new FootballFixturesFragment();
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
        View view = inflater.inflate(R.layout.fragment_football_fixtures, viewGroup, false);
        RecyclerView football_fixtures_list = view.findViewById(R.id.football_fixtures_list);
        football_fixtures_list.setLayoutManager(new LinearLayoutManager(getContext()));
        //String[] matches = {"match 1", "match 2", "match 3", "match 4", "match 5", "match 6", "match 7", "match 8", "match 9", "match 10", "match 11", "match 12", "match 13", "match 14", "match 15", "match 16", "match 17"};
        football_fixtures_list.setAdapter(new FootballFixturesAdapter(feedItems(), getContext()));


        return view;
    }

    private List<FootballFixturesModel> feedItems(){
        List<FootballFixturesModel> demoItems = new ArrayList<>();
        demoItems.add(new FootballFixturesModel("Team A", "Team B", "15:00", "21/2/2019"));
        demoItems.add(new FootballFixturesModel("Team C", "Team D", "15:30", "21/2/2019"));
        demoItems.add(new FootballFixturesModel("Team Y", "Team Z", "16:00", "21/2/2019"));

        return demoItems;
    }
}
