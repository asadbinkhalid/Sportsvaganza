package com.asad.sportsvaganza.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asad.sportsvaganza.R;

public class CricketFixturesAdapter extends RecyclerView.Adapter<CricketFixturesAdapter.CricketFixturesViewHolder> {

    private String[] data;

    public CricketFixturesAdapter(String[] data){
        this.data = data;

    }

    @NonNull
    @Override
    public CricketFixturesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.listitem_cricket_live, parent, false);
        return new CricketFixturesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CricketFixturesViewHolder holder, int position) {
        String title = data[position];
        holder.text123.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class CricketFixturesViewHolder extends RecyclerView.ViewHolder{
        TextView text123;
        View view1;
        public CricketFixturesViewHolder(@NonNull View itemView) {
            super(itemView);
            text123 = itemView.findViewById(R.id.text123);
            view1 = itemView.findViewById(R.id.view123);
        }
    }

}
