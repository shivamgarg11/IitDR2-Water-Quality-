package com.shivam.iitdr2water_quality;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptor extends RecyclerView.Adapter<Adaptor.CourseViewHolder> {

    private Context context;

    public Adaptor(Context context, ArrayList<com.shivam.iitdr2water_quality.swimmingpools> swimmingpools) {
        this.context = context;
        this.swimmingpools = swimmingpools;
    }

    private ArrayList<swimmingpools> swimmingpools;


    @NonNull
    @Override
    public Adaptor.CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(viewType, parent, false);

        return new CourseViewHolder(itemView);
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.swimmingpoolrecycleview;
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptor.CourseViewHolder holder, int position) {

        swimmingpools pool=swimmingpools.get(position);
        holder.Swimmingpoolname.setText(pool.getName());
        holder.SWimmingpooladdress.setText(pool.getAddress());
        holder.phvalue.setText(String.valueOf(pool.getPh()));
        holder.clvalue.setText(String.valueOf(pool.getChlorine()));
        holder.remarkcl.setText(String.valueOf(pool.getChlorinethreshold_max()+"-"+pool.getChlorinethreshold_min()));

        if(pool.getPh()<pool.getPhthreshold_min()||pool.getPh()>pool.getPhthreshold_max()){
            holder.phvalue.setTextColor(Color.RED);
            holder.frameswimmingpool.setBackgroundColor(Color.RED);
            holder.imageok.setImageResource(R.drawable.notok);

            if(pool.getPh()<pool.getPhthreshold_min()){
                holder.remarkph.setText("INCREASE");
            }else{
                holder.remarkph.setText("DECREASE");
            }

        }
        else{
            holder.remarkph.setText("OK");
        }


        if(pool.getChlorine()<pool.getChlorinethreshold_min()||pool.getChlorine()>pool.getChlorinethreshold_max()){
            holder.clvalue.setTextColor(Color.RED);
            holder.frameswimmingpool.setBackgroundColor(Color.RED);

            holder.imageok.setImageResource(R.drawable.notok);

            if(pool.getChlorine()<pool.getChlorinethreshold_min()){
                holder.remarkcl.setText("INCREASE");
            }else{
                holder.remarkcl.setText("DECREASE");
            }
        }else{
            holder.remarkcl.setText("OK");
        }

    }

    @Override
    public int getItemCount() {
        return swimmingpools.size();
    }



    static class CourseViewHolder extends RecyclerView.ViewHolder {
        FrameLayout frameswimmingpool;
        TextView Swimmingpoolname, SWimmingpooladdress, phvalue,remarkph,clvalue,remarkcl;
        ImageView imageok;

        public CourseViewHolder(View itemView) {
            super(itemView);
            frameswimmingpool=itemView.findViewById(R.id.frameswimmingpool);
            Swimmingpoolname = itemView.findViewById(R.id.Swimmingpoolname);
            SWimmingpooladdress = itemView.findViewById(R.id.SWimmingpooladdress);
            phvalue = itemView.findViewById(R.id.phvalue);
            remarkph = itemView.findViewById(R.id.remarkph);
            clvalue = itemView.findViewById(R.id.clvalue);
            remarkcl = itemView.findViewById(R.id.remarkcl);
            imageok=itemView.findViewById(R.id.imagerecycleok);
        }
    }
}
