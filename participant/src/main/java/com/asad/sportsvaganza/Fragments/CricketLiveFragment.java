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
import com.asad.sportsvaganza.Adapters.CricketLiveAdapter;
import com.asad.sportsvaganza.Adapters.FootballFixturesAdapter;
import com.asad.sportsvaganza.Models.CricketLiveModel;
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
        cricket_live_list.setAdapter(new CricketLiveAdapter(feedItems(), getContext()));

        return view;
    }

    private List<CricketLiveModel> feedItems(){
        List<CricketLiveModel> demoItems = new ArrayList<>();
        demoItems.add(new CricketLiveModel("Team A", "Team B", 112, 58, 3, 6));
        demoItems.add(new CricketLiveModel("Team C", "Team D", 90, 30, 5, 7));

        return demoItems;
    }
}
