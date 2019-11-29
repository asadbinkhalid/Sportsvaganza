package com.asad.sportsvaganza.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.asad.businesslogic.CricketMatch;
import com.asad.businesslogic.Main;
import com.asad.businesslogic.Match;
import com.asad.sportsvaganza.Adapters.CricketResultsAdapter;
import com.asad.sportsvaganza.R;

import java.util.ArrayList;
import java.util.List;

public class CricketResultsFragment extends Fragment {

    public CricketResultsFragment(){

    }

    public static CricketResultsFragment newInstance() {
        CricketResultsFragment fragment = new CricketResultsFragment();
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
        View view = inflater.inflate(R.layout.fragment_cricket_results, viewGroup, false);
        RecyclerView cricket_results_list = view.findViewById(R.id.cricket_results_list);
        cricket_results_list.setLayoutManager(new LinearLayoutManager(getContext()));
        cricket_results_list.setAdapter(new CricketResultsAdapter(getMatches(Main.getInstance().getCricketMatchesList()), getContext()));

        return view;
    }

    private List<CricketMatch> getMatches(List<CricketMatch> matchesList){
        List<CricketMatch> scheduledMatches = new ArrayList<>();

        for(int i=0;i<matchesList.size();i++){
            if(matchesList.get(i).getState().equals(Match.ENDED)){
                scheduledMatches.add(matchesList.get(i));
            }
        }

        return scheduledMatches;
    }

}
