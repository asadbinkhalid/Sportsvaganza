package com.asad.sportsvaganza.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asad.businesslogic.FootballMatch;
import com.asad.businesslogic.Main;
import com.asad.businesslogic.Match;
import com.asad.sportsvaganza.Activities.Activity3_football_main;
import com.asad.sportsvaganza.R;

import java.util.List;

public class FootballLiveAdapter extends RecyclerView.Adapter<FootballLiveAdapter.FootballLiveViewHolder> {

    private List<FootballMatch> footballLiveModelList;
    private Context context;

    public FootballLiveAdapter(List<FootballMatch> footballLiveModelList, Context context){
        this.footballLiveModelList = footballLiveModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public FootballLiveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.listitem_football_live, parent, false);
        return new FootballLiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FootballLiveViewHolder holder, final int position) {
        holder.mteamA3.setText(footballLiveModelList.get(position).getTeam1().getName());
        holder.mteamB3.setText(footballLiveModelList.get(position).getTeam2().getName());
        holder.mscoreA3.setText(String.valueOf(footballLiveModelList.get(position).getTeam1Score()));
        holder.mscoreB3.setText(String.valueOf(footballLiveModelList.get(position).getTeam2Score()));
        holder.endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                footballLiveModelList.get(position).setState(Match.ENDED);
                Main.getInstance().updateFootballToEnded  (footballLiveModelList.get(position));
                Main.getInstance().initiateFootballMatches();
            }
        });
    }

    @Override
    public int getItemCount() {
        return footballLiveModelList.size();
    }

    public class FootballLiveViewHolder extends RecyclerView.ViewHolder{
        TextView mteamA3;
        TextView mteamB3;
        TextView mscoreA3;
        TextView mscoreB3;
        Button endButton;

        public FootballLiveViewHolder(@NonNull View itemView) {
            super(itemView);
            mteamA3 = itemView.findViewById(R.id.textView_teamAName3);
            mteamB3 = itemView.findViewById(R.id.textView_teamBName3);
            mscoreA3 = itemView.findViewById(R.id.textView_scoreA3);
            mscoreB3 = itemView.findViewById(R.id.textView_scoreB3);
            endButton = itemView.findViewById(R.id.button3);
        }
    }

}
