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
import com.asad.sportsvaganza.Adapters.CricketLiveAdapter;
import com.asad.sportsvaganza.R;

import java.util.ArrayList;
import java.util.List;


public class CricketLiveFragment extends Fragment {

    public CricketLiveFragment(){

    }

    public static CricketLiveFragment newInstance() {
        CricketLiveFragment fragment = new CricketLiveFragment();
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
        View view = inflater.inflate(R.layout.fragment_cricket_live, viewGroup, false);
        RecyclerView cricket_live_list = view.findViewById(R.id.cricket_live_list);
        cricket_live_list.setLayoutManager(new LinearLayoutManager(getContext()));
        cricket_live_list.setAdapter(new CricketLiveAdapter(getMatches(Main.getInstance().getCricketMatchesList()), getContext()));

        return view;
    }

    private List<CricketMatch> getMatches(List<CricketMatch> matchesList){
        List<CricketMatch> scheduledMatches = new ArrayList<>();

        for(int i=0;i<matchesList.size();i++){
            if(matchesList.get(i).getState().equals(Match.LIVE)){
                scheduledMatches.add(matchesList.get(i));
            }
        }

        return scheduledMatches;
    }
}
