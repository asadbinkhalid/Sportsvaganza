package com.asad.sportsvaganza.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.asad.businesslogic.FootballMatch;
import com.asad.businesslogic.Main;
import com.asad.businesslogic.Match;
import com.asad.sportsvaganza.Adapters.FootballFixturesAdapter;
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
        football_fixtures_list.setAdapter(new FootballFixturesAdapter(getMatches(Main.getInstance().getFootballMatchesList()), getContext()));

        return view;
    }

    private List<FootballMatch> getMatches(List<FootballMatch> matchesList){
        List<FootballMatch> scheduledMatches = new ArrayList<>();

        for(int i=0;i<matchesList.size();i++){
            if(matchesList.get(i).getState().equals(Match.SCHEDULED)){
                scheduledMatches.add(matchesList.get(i));
            }
        }

        return scheduledMatches;
    }
}
