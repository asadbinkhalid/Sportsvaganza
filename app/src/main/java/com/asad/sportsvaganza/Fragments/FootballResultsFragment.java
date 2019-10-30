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
import com.asad.sportsvaganza.R;

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
        RecyclerView football_fixtures_list = view.findViewById(R.id.football_results_list);
        football_fixtures_list.setLayoutManager(new LinearLayoutManager(getContext()));
        String[] matches = {"match 1", "match 2", "match 3", "match 4", "match 5", "match 6", "match 7", "match 8", "match 9", "match 10", "match 11", "match 12", "match 13", "match 14", "match 15"};
        football_fixtures_list.setAdapter(new FootballResultsAdapter(matches));


        return view;
    }

}
