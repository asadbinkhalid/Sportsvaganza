package com.asad.sportsvaganza.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.asad.sportsvaganza.Adapters.FootballResultsAdapter;
import com.asad.sportsvaganza.Models.FootballFixturesModel;
import com.asad.sportsvaganza.Models.FootballResultsModel;
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
        football_results_list.setAdapter(new FootballResultsAdapter(feedItems(), getContext()));


        return view;
    }

    private List<FootballResultsModel> feedItems(){
        List<FootballResultsModel> demoItems = new ArrayList<>();
        demoItems.add(new FootballResultsModel("Team A", "Team B", "1", "0", "15:00", "21/2/2019"));
        demoItems.add(new FootballResultsModel("Team C", "Team D", "2", "2","15:30", "21/2/2019"));
        demoItems.add(new FootballResultsModel("Team Y", "Team Z", "1", "3","16:00", "21/2/2019"));

        return demoItems;
    }

}
