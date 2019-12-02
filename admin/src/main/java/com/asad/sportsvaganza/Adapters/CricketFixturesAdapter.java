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
import com.asad.businesslogic.FootballMatch;
import com.asad.businesslogic.Match;
import com.asad.sportsvaganza.R;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
        View view = inflater.inflate(R.layout.listitem_cricket_fixtures, parent, false);
        return new CricketFixturesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CricketFixturesViewHolder holder, final int position) {
        holder.mteamA.setText(cricketFixturesModelList.get(position).getTeam1().getName());
        holder.mteamB.setText(cricketFixturesModelList.get(position).getTeam2().getName());
        holder.mtime.setText(cricketFixturesModelList.get(position).getTime());
        holder.mdate.setText(cricketFixturesModelList.get(position).getDate());

        holder.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cricketFixturesModelList.get(position).setState(Match.LIVE);
            }
        });
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
        Button startButton;
        public CricketFixturesViewHolder(@NonNull View itemView) {
            super(itemView);
            mteamA = itemView.findViewById(R.id.textView_teamAName4);
            mteamB = itemView.findViewById(R.id.textView_teamBName4);
            mdate = itemView.findViewById(R.id.match_date4);
            mtime = itemView.findViewById(R.id.text_matchTime4);
            startButton = itemView.findViewById(R.id.button);
        }
    }

}
