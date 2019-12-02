package com.asad.sportsvaganza.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asad.businesslogic.CricketMatch;
import com.asad.businesslogic.Match;
import com.asad.sportsvaganza.R;

import java.util.List;

public class CricketLiveAdapter extends RecyclerView.Adapter<CricketLiveAdapter.CricketLiveViewHolder> {

    private List<CricketMatch> cricketLiveModelList;
    private Context context;

    public CricketLiveAdapter(List<CricketMatch> cricketLiveModelList, Context context){
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
    public void onBindViewHolder(@NonNull CricketLiveViewHolder holder, final int position) {
        holder.mteamA.setText(cricketLiveModelList.get(position).getTeam1().getName());
        holder.mteamB.setText(cricketLiveModelList.get(position).getTeam2().getName());
        holder.mruns.setText(String.valueOf(cricketLiveModelList.get(position).getTeam1Runs()));
        holder.mtarget.setText(String.valueOf(cricketLiveModelList.get(position).getTeam2Runs()));
        holder.movers.setText(String.valueOf(cricketLiveModelList.get(position).getOvers()));
        holder.mwickets.setText(String.valueOf(cricketLiveModelList.get(position).getWickets()));
        holder.endButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            cricketLiveModelList.get(position).setState(Match.ENDED);
            //refreshActivity();
        }
    });
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
        Button endButton;

        public CricketLiveViewHolder(@NonNull View itemView) {
            super(itemView);
            mteamA = itemView.findViewById(R.id.textView_battingTeam);
            mteamB = itemView.findViewById(R.id.textView_fieldingTeam);
            mruns = itemView.findViewById(R.id.textView_runs);
            mtarget = itemView.findViewById(R.id.textView_targetScore);
            movers = itemView.findViewById(R.id.textView_over);
            mwickets = itemView.findViewById(R.id.textView_wickets);
            endButton = itemView.findViewById(R.id.button2);
        }
    }

}
