package com.asad.sportsvaganza.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asad.sportsvaganza.R;

public class CricketLiveAdapter extends RecyclerView.Adapter<CricketLiveAdapter.CricketLiveViewHolder> {

    private String[] data;

    public CricketLiveAdapter(String[] data){
        this.data = data;

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
        String title = data[position];
        holder.text123.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class CricketLiveViewHolder extends RecyclerView.ViewHolder{
        TextView text123;
        View view1;
        public CricketLiveViewHolder(@NonNull View itemView) {
            super(itemView);
            text123 = itemView.findViewById(R.id.text123);
            view1 = itemView.findViewById(R.id.view123);
        }
    }

}
