package com.Moive.moive.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.Moive.moive.R;
import com.Moive.moive.models.cast;
import com.bumptech.glide.Glide;

import java.util.List;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder> {


    Context context;
    List<cast> Data;

    public CastAdapter(Context context, List<cast> data) {
        this.context = context;
        Data = data;
    }

    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cast, parent, false);
       return new CastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder holder, int position) {

        Glide.with(context).load(Data.get(position).getImg_link()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return Data.size();
    }

    public class CastViewHolder extends RecyclerView.ViewHolder {

      ImageView img;

        public CastViewHolder(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.img_cast);
        }
    }
}
