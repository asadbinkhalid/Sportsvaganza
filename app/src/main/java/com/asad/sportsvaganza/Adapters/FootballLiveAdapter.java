package com.asad.sportsvaganza.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asad.sportsvaganza.R;

public class FootballLiveAdapter extends RecyclerView.Adapter<FootballLiveAdapter.FootballLiveViewHolder> {

    private String[] data;

    public FootballLiveAdapter(String[] data){
        this.data = data;

    }

    @NonNull
    @Override
    public FootballLiveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.listitem_football_live, parent, false);
        return new FootballLiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FootballLiveViewHolder holder, int position) {
        String title = data[position];
        holder.text123.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class FootballLiveViewHolder extends RecyclerView.ViewHolder{
        TextView text123;
        View view1;
        public FootballLiveViewHolder(@NonNull View itemView) {
            super(itemView);
            text123 = itemView.findViewById(R.id.text123);
            view1 = itemView.findViewById(R.id.view123);
        }
    }

}
