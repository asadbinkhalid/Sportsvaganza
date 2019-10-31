package com.asad.sportsvaganza.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.asad.sportsvaganza.Adapters.CricketResultsAdapter;
import com.asad.sportsvaganza.Adapters.FootballResultsAdapter;
import com.asad.sportsvaganza.Models.CricketResultsModel;
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
        cricket_results_list.setAdapter(new CricketResultsAdapter(feedItems(), getContext()));

        return view;
    }

    private List<CricketResultsModel> feedItems(){
        List<CricketResultsModel> demoItems = new ArrayList<>();
        demoItems.add(new CricketResultsModel("Team A", "Team B"));
        demoItems.add(new CricketResultsModel("Team C", "Team D"));
        demoItems.add(new CricketResultsModel("Team E", "Team F"));
        demoItems.add(new CricketResultsModel("Team X", "Team Y"));

        return demoItems;
    }

}
