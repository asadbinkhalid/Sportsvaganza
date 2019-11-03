package com.asad.sportsvaganza.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asad.sportsvaganza.Models.CricketLiveModel;
import com.asad.sportsvaganza.R;

import java.util.List;

public class CricketLiveAdapter extends RecyclerView.Adapter<CricketLiveAdapter.CricketLiveViewHolder> {

    private List<CricketLiveModel> cricketLiveModelList;
    private Context context;

    public CricketLiveAdapter(List<CricketLiveModel> cricketLiveModelList, Context context){
        this.cricketLiveModelList = cricketLiveModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public CricketLiveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.listitem_cricket_live, parent, false);
        return new CricketLiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CricketLiveViewHolder holder, int position) {
        holder.mteamA.setText(cricketLiveModelList.get(position).teamA);
        holder.mteamB.setText(cricketLiveModelList.get(position).teamB);
        holder.mruns.setText(Integer.toString(cricketLiveModelList.get(position).runs));
        holder.mtarget.setText(Integer.toString(cricketLiveModelList.get(position).target));
        holder.movers.setText(Integer.toString(cricketLiveModelList.get(position).overs));
        holder.mwickets.setText(Integer.toString(cricketLiveModelList.get(position).wickets));
    }

    @Override
    public int getItemCount() {
        return cricketLiveModelList.size();
    }

    public class CricketLiveViewHolder extends RecyclerView.ViewHolder{
        TextView mteamA;
        TextView mteamB;
        TextView mruns;
        TextView mtarget;
        TextView movers;
        TextView mwickets;

        public CricketLiveViewHolder(@NonNull View itemView) {
            super(itemView);
            mteamA = itemView.findViewById(R.id.textView_battingTeam);
            mteamB = itemView.findViewById(R.id.textView_fieldingTeam);
            mruns = itemView.findViewById(R.id.textView_runs);
            mtarget = itemView.findViewById(R.id.textView_targetScore);
            movers = itemView.findViewById(R.id.textView_over);
            mwickets = itemView.findViewById(R.id.textView_wickets);
        }
    }

}
