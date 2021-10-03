package com.example.shiva.forum;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by shiva on 3/12/2017.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder>{
    private ArrayList<Deom> persons;
    public RVAdapter(ArrayList<Deom> persons) {
        this.persons = persons;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyl, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.personName.setText(persons.get(i).text);
        viewHolder.personPhoto.setImageResource(persons.get(i).pic);

    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        TextView personName;
        ImageView personPhoto;

        ViewHolder(View itemView) {
            super(itemView);
            //cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.name);
            personPhoto = (ImageView)itemView.findViewById(R.id.pic);

        }
    }


}