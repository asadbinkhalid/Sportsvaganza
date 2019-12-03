package com.asad.sportsvaganza.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asad.businesslogic.FootballMatch;
import com.asad.sportsvaganza.R;


import java.util.List;

public class FootballResultsAdapter extends RecyclerView.Adapter<FootballResultsAdapter.FootballResultsViewHolder> {

    private List<FootballMatch> footballResultsModelList;
    private Context context;

    public FootballResultsAdapter(List<FootballMatch> footballResultsModelList, Context context){
        this.footballResultsModelList = footballResultsModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public FootballResultsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_football_results, parent, false);
        return new FootballResultsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FootballResultsViewHolder holder, int position) {
        holder.mteamA1.setText(footballResultsModelList.get(position).getTeam1().getName());
        holder.mteamB1.setText(footballResultsModelList.get(position).getTeam2().getName());
        holder.mtime1.setText(footballResultsModelList.get(position).getTime());
        holder.mdate1.setText(footballResultsModelList.get(position).getDate());
        holder.mscoreA1.setText(String.valueOf(footballResultsModelList.get(position).getTeam1Score()));
        holder.mscoreB1.setText(String.valueOf(footballResultsModelList.get(position).getTeam2Score()));
    }

    @Override
    public int getItemCount() {
        return footballResultsModelList.size();
    }

    public class FootballResultsViewHolder extends RecyclerView.ViewHolder{
        TextView mteamA1;
        TextView mteamB1;
        TextView mtime1;
        TextView mdate1;
        TextView mscoreA1;
        TextView mscoreB1;

        public FootballResultsViewHolder(@NonNull View itemView) {
            super(itemView);
            mteamA1 = itemView.findViewById(R.id.textView_teamAName2);
            mteamB1 = itemView.findViewById(R.id.textView_teamBName2);
            mtime1 = itemView.findViewById(R.id.text_matchTime2);
            mdate1 = itemView.findViewById(R.id.match_date2);
            mscoreA1 = itemView.findViewById(R.id.textView_scoreA);
            mscoreB1 = itemView.findViewById(R.id.textView_scoreB);
        }
    }

}
