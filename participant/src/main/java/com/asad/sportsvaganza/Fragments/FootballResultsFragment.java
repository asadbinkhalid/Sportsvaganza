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
import com.asad.sportsvaganza.Adapters.FootballResultsAdapter;
import com.asad.sportsvaganza.R;

import java.util.ArrayList;
import java.util.List;

public class FootballResultsFragment extends Fragment {

    public FootballResultsFragment(){

    }

    public static FootballResultsFragment newInstance() {
        FootballResultsFragment fragment = new FootballResultsFragment();
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
        View view = inflater.inflate(R.layout.fragment_football_results, viewGroup, false);
        RecyclerView football_results_list = view.findViewById(R.id.football_results_list);
        football_results_list.setLayoutManager(new LinearLayoutManager(getContext()));
        football_results_list.setAdapter(new FootballResultsAdapter(getMatches(Main.getInstance().getFootballMatchesList()), getContext()));

        return view;
    }

    private List<FootballMatch> getMatches(List<FootballMatch> matchesList){
        List<FootballMatch> scheduledMatches = new ArrayList<>();

        for(int i=0;i<matchesList.size();i++){
            if(matchesList.get(i).getState().equals(Match.ENDED)){
                scheduledMatches.add(matchesList.get(i));
            }
        }

        return scheduledMatches;
    }

}
