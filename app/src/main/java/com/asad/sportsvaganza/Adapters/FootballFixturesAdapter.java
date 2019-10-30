package com.asad.sportsvaganza.Adapters;

<<<<<<< HEAD
=======
import android.content.Context;
>>>>>>> e681d18ffb2a242a14b8e17d0032f5112ec79b42
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

<<<<<<< HEAD
import com.asad.sportsvaganza.R;

public class FootballFixturesAdapter extends RecyclerView.Adapter<FootballFixturesAdapter.FootballFixturesViewHolder> {

    private String[] data;

    public FootballFixturesAdapter(String[] data){
        this.data = data;
=======
import com.asad.sportsvaganza.Models.FootballFixturesModel;
import com.asad.sportsvaganza.R;

import java.util.List;

public class FootballFixturesAdapter extends RecyclerView.Adapter<FootballFixturesAdapter.FootballFixturesViewHolder> {

    private List<FootballFixturesModel> footballFixturesModelList;
    private Context context;

    public FootballFixturesAdapter(List<FootballFixturesModel> footballFixturesModelList, Context context){
        this.footballFixturesModelList = footballFixturesModelList;
        this.context = context;
>>>>>>> e681d18ffb2a242a14b8e17d0032f5112ec79b42

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
<<<<<<< HEAD
        String title = data[position];
        holder.text123.setText(title);
=======
        holder.mteamA.setText(footballFixturesModelList.get(position).teamA);
        holder.mteamB.setText(footballFixturesModelList.get(position).teamB);
        holder.mtime.setText(footballFixturesModelList.get(position).time);
        holder.mdate.setText(footballFixturesModelList.get(position).date);
>>>>>>> e681d18ffb2a242a14b8e17d0032f5112ec79b42
    }

    @Override
    public int getItemCount() {
<<<<<<< HEAD
        return data.length;
    }

    public class FootballFixturesViewHolder extends RecyclerView.ViewHolder{
        TextView text123;
        View view1;
        public FootballFixturesViewHolder(@NonNull View itemView) {
            super(itemView);
            text123 = itemView.findViewById(R.id.text123);
            view1 = itemView.findViewById(R.id.view123);
        }
    }

}
=======
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
>>>>>>> e681d18ffb2a242a14b8e17d0032f5112ec79b42
