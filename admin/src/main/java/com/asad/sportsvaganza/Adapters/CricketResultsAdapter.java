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

public class CricketResultsAdapter extends RecyclerView.Adapter<CricketResultsAdapter.CricketResultsViewHolder> {

    private List<CricketMatch> cricketResultsModelList;
    private Context context;

    public CricketResultsAdapter(List<CricketMatch> cricketResultsModelList, Context context){
        this.cricketResultsModelList = cricketResultsModelList;
        this.context = context;

    }

    @NonNull
    @Override
    public CricketResultsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.listitem_cricket_results, parent, false);
        return new CricketResultsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CricketResultsViewHolder holder, int position) {
        holder.mteamA.setText(cricketResultsModelList.get(position).getTeam1().getName());
        holder.mteamB.setText(cricketResultsModelList.get(position).getTeam2().getName());
        holder.mtime1.setText(cricketResultsModelList.get(position).getTime());
        holder.mdate1.setText(cricketResultsModelList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return cricketResultsModelList.size();
    }

    public class CricketResultsViewHolder extends RecyclerView.ViewHolder{
        TextView mteamA;
        TextView mteamB;
        TextView mtime1;
        TextView mdate1;
        public CricketResultsViewHolder(@NonNull View itemView) {
            super(itemView);
            mteamA = itemView.findViewById(R.id.textView_teamAName5);
            mteamB = itemView.findViewById(R.id.textView_teamBName5);
            mtime1 = itemView.findViewById(R.id.text_matchTime3);
            mdate1 = itemView.findViewById(R.id.match_date3);
        }
    }

}
