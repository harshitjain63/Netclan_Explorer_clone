package com.example.myapplication;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private ArrayList<Employee> emplist;

    public Adapter(ArrayList<Employee> emplist) {
        this.emplist = emplist;
    }

    // This method creates a new ViewHolder object for each item in the RecyclerView
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout for each item and return a new ViewHolder object
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_list, parent, false);
        return new MyViewHolder(itemView);
    }

    // This method returns the total
    // number of items in the data set
    @Override
    public int getItemCount() {
        return emplist.size();
    }

    // This method binds the data to the ViewHolder object
    // for each item in the RecyclerView
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Employee currentEmp = emplist.get(position);
        holder.name.setText(currentEmp.getName());
        holder.email.setText(currentEmp.getEmail());
        holder.invite.setText(currentEmp.getInvite());
        holder.km.setText(currentEmp.getKm());
        holder.type.setText(currentEmp.getType());
        holder.about.setText(currentEmp.getAbout());
        holder.img.setImageResource(currentEmp.getImageResource());
    }

    // This class defines the ViewHolder object for each item in the RecyclerView
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView email;
        private TextView invite;
        private TextView km;

        private TextView about;
        private TextView type;
        private ImageView img;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            email = itemView.findViewById(R.id.tvEmail);
            invite = itemView.findViewById(R.id.Invite);
           km = itemView.findViewById(R.id.Km);
            about = itemView.findViewById(R.id.About);
            type = itemView.findViewById(R.id.Type);
            img=itemView.findViewById(R.id.img);
        }
    }
}
