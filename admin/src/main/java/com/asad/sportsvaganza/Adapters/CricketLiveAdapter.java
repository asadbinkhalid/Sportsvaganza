package com.asad.sportsvaganza.Adapters;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asad.businesslogic.CricketMatch;
import com.asad.businesslogic.Match;
import com.asad.sportsvaganza.Activities.CricketMainActivity;
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
        View view = inflater.inflate(R.layout.item_cricket_live, parent, false);
        return new CricketLiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CricketLiveViewHolder holder, final int position) {
        holder.mteamA.setText(cricketLiveModelList.get(position).getTeam1().getName());
        holder.mteamB.setText(cricketLiveModelList.get(position).getTeam2().getName());

        holder.mruns.setText(String.valueOf(cricketLiveModelList.get(position).getTeam1Runs()));
        holder.mruns.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                holder.mruns.setText(s.toString());
                cricketLiveModelList.get(position).setTeam1Runs(Integer.parseInt(s.toString()));
                ((CricketMainActivity) context).updateCricketMatchVIAService(cricketLiveModelList.get(position));
                ((CricketMainActivity) context).refreshActivity();
            }
        });

        holder.mtarget.setText(String.valueOf(cricketLiveModelList.get(position).getTeam2Runs()));
        holder.movers.setText(String.valueOf(cricketLiveModelList.get(position).getOvers()));
        holder.mwickets.setText(String.valueOf(cricketLiveModelList.get(position).getWickets()));

        holder.endButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cricketLiveModelList.get(position).setState(Match.ENDED);

                ((CricketMainActivity) context).updateCricketMatchVIAService(cricketLiveModelList.get(position));
                ((CricketMainActivity) context).refreshActivity();
            }
        });
        holder.addScoreButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cricketLiveModelList.get(position).setTeam1Runs(cricketLiveModelList.get(position).getTeam1Runs() + 1);

                ((CricketMainActivity) context).updateCricketMatchVIAService(cricketLiveModelList.get(position));
                ((CricketMainActivity) context).refreshActivity();
            }
        });
        holder.subScoreButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cricketLiveModelList.get(position).setTeam1Runs(cricketLiveModelList.get(position).getTeam1Runs() - 1);

                ((CricketMainActivity) context).updateCricketMatchVIAService(cricketLiveModelList.get(position));
                ((CricketMainActivity) context).refreshActivity();
            }
        });
        holder.addWicketsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cricketLiveModelList.get(position).setWickets(cricketLiveModelList.get(position).getWickets() + 1);

                ((CricketMainActivity) context).updateCricketMatchVIAService(cricketLiveModelList.get(position));
                ((CricketMainActivity) context).refreshActivity();
            }
        });
        holder.subWicketsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cricketLiveModelList.get(position).setWickets(cricketLiveModelList.get(position).getWickets() - 1);

                ((CricketMainActivity) context).updateCricketMatchVIAService(cricketLiveModelList.get(position));
                ((CricketMainActivity) context).refreshActivity();
            }
        });
        holder.addOversButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cricketLiveModelList.get(position).setOvers(cricketLiveModelList.get(position).getOvers() + 1);

                ((CricketMainActivity) context).updateCricketMatchVIAService(cricketLiveModelList.get(position));
                ((CricketMainActivity) context).refreshActivity();
            }
        });
        holder.changeInningsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(cricketLiveModelList.get(position).getTeam2Runs() == 0){
                    String temp = cricketLiveModelList.get(position).getTeam1().getName();
                    cricketLiveModelList.get(position).getTeam1().setName(cricketLiveModelList.get(position).getTeam2().getName());
                    cricketLiveModelList.get(position).getTeam2().setName(temp);

                    int tempInt = cricketLiveModelList.get(position).getTeam1Runs();
                    cricketLiveModelList.get(position).setTeam1Runs(cricketLiveModelList.get(position).getTeam2Runs());
                    cricketLiveModelList.get(position).setTeam2Runs(tempInt);

                    cricketLiveModelList.get(position).setOvers(0);
                    cricketLiveModelList.get(position).setWickets(0);

                    //holder.mtarget.setText(String.valueOf(cricketLiveModelList.get(position).getTeam1Runs()));

                    ((CricketMainActivity) context).updateCricketMatchVIAService(cricketLiveModelList.get(position));
                    ((CricketMainActivity) context).refreshActivity();
                }
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
        EditText mruns;
        TextView mtarget;
        TextView movers;
        TextView mwickets;
        Button endButton;
        Button addScoreButton;
        Button subScoreButton;
        Button addWicketsButton;
        Button subWicketsButton;
        Button addOversButton;
        Button changeInningsButton;

        public CricketLiveViewHolder(@NonNull View itemView) {
            super(itemView);

            mteamA = itemView.findViewById(R.id.textView_battingTeam);
            mteamB = itemView.findViewById(R.id.textView_fieldingTeam);
            mruns = itemView.findViewById(R.id.textView_runs);
            mtarget = itemView.findViewById(R.id.textView_targetScore);
            movers = itemView.findViewById(R.id.textView_over);
            mwickets = itemView.findViewById(R.id.textView_wickets);
            endButton = itemView.findViewById(R.id.button2);
            addScoreButton = itemView.findViewById(R.id.button9);
            subScoreButton = itemView.findViewById(R.id.button11);
            addWicketsButton = itemView.findViewById(R.id.button10);
            subWicketsButton = itemView.findViewById(R.id.button12);
            addOversButton = itemView.findViewById(R.id.button8);
            changeInningsButton = itemView.findViewById(R.id.button13);

        }
    }

}
