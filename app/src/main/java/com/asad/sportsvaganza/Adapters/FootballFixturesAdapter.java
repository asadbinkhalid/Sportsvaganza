package com.asad.sportsvaganza.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asad.sportsvaganza.Models.FootballFixturesModel;
import com.asad.sportsvaganza.R;

import java.util.List;

public class FootballFixturesAdapter extends RecyclerView.Adapter<FootballFixturesAdapter.FootballFixturesViewHolder> {

    private List<FootballFixturesModel> footballFixturesModelList;
    private Context context;

    public FootballFixturesAdapter(List<FootballFixturesModel> footballFixturesModelList, Context context){
        this.footballFixturesModelList = footballFixturesModelList;
        this.context = context;

    }

    @NonNull
    @Override
    public FootballFixturesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.listitem_football_fixtures, parent, false);
        return new FootballFixturesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FootballFixturesViewHolder holder, int position) {
        holder.mteamA.setText(footballFixturesModelList.get(position).teamA);
        holder.mteamB.setText(footballFixturesModelList.get(position).teamB);
        holder.mtime.setText(footballFixturesModelList.get(position).time);
        holder.mdate.setText(footballFixturesModelList.get(position).date);
    }

    @Override
    public int getItemCount() {
        return footballFixturesModelList.size();
    }

    public class FootballFixturesViewHolder extends RecyclerView.ViewHolder{
        TextView mteamA;
        TextView mteamB;
        TextView mtime;
        TextView mdate;
        public FootballFixturesViewHolder(@NonNull View itemView) {
            super(itemView);
            mteamA = itemView.findViewById(R.id.textView_teamAName);
            mteamB = itemView.findViewById(R.id.textView_teamBName);
            mtime = itemView.findViewById(R.id.text_matchTime);
            mdate = itemView.findViewById(R.id.match_date);
        }
    }

}
