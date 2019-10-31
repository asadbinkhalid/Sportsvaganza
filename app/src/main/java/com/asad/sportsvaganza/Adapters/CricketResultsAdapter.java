package com.asad.sportsvaganza.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asad.sportsvaganza.Models.CricketResultsModel;
import com.asad.sportsvaganza.R;

import java.util.List;

public class CricketResultsAdapter extends RecyclerView.Adapter<CricketResultsAdapter.CricketResultsViewHolder> {

    private List<CricketResultsModel> cricketResultsModelList;
    private Context context;

    public CricketResultsAdapter(List<CricketResultsModel> cricketResultsModelList, Context context){
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
        holder.mteamA.setText(cricketResultsModelList.get(position).teamA);
        holder.mteamB.setText(cricketResultsModelList.get(position).teamB);
    }

    @Override
    public int getItemCount() {
        return cricketResultsModelList.size();
    }

    public class CricketResultsViewHolder extends RecyclerView.ViewHolder{
        TextView mteamA;
        TextView mteamB;
        public CricketResultsViewHolder(@NonNull View itemView) {
            super(itemView);
            mteamA = itemView.findViewById(R.id.textView_teamAName5);
            mteamB = itemView.findViewById(R.id.textView_teamBName5);
        }
    }

}
