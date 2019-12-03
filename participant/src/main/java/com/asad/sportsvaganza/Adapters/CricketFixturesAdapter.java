package com.asad.sportsvaganza.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asad.businesslogic.CricketMatch;
import com.asad.sportsvaganza.R;

import java.util.List;

public class CricketFixturesAdapter extends RecyclerView.Adapter<CricketFixturesAdapter.CricketFixturesViewHolder> {

    private List<CricketMatch> cricketFixturesModelList;
    private Context context;

    public CricketFixturesAdapter(List<CricketMatch> cricketFixturesModelList, Context context){
        this.cricketFixturesModelList = cricketFixturesModelList;
        this.context = context;

    }

    @NonNull
    @Override
    public CricketFixturesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_cricket_fixtures, parent, false);
        return new CricketFixturesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CricketFixturesViewHolder holder, int position) {
        holder.mteamA.setText(cricketFixturesModelList.get(position).getTeam1().getName());
        holder.mteamB.setText(cricketFixturesModelList.get(position).getTeam2().getName());
        holder.mtime.setText(cricketFixturesModelList.get(position).getTime());
        holder.mdate.setText(cricketFixturesModelList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return cricketFixturesModelList.size();
    }

    public class CricketFixturesViewHolder extends RecyclerView.ViewHolder{
        TextView mteamA;
        TextView mteamB;
        TextView mdate;
        TextView mtime;
        public CricketFixturesViewHolder(@NonNull View itemView) {
            super(itemView);
            mteamA = itemView.findViewById(R.id.textView_teamAName4);
            mteamB = itemView.findViewById(R.id.textView_teamBName4);
            mdate = itemView.findViewById(R.id.match_date4);
            mtime = itemView.findViewById(R.id.text_matchTime4);
        }
    }

}
