package com.Moive.moive.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Moive.moive.R;
import com.Moive.moive.models.Moive;

import java.util.List;

public class MoiveAdapter extends RecyclerView.Adapter<MoiveAdapter.MyViewHolder> {

    Context context;
    List<Moive> mData;
    Moiveitemclicklistener moiveitemclicklistener;

    public MoiveAdapter(Context context, List<Moive> mData, Moiveitemclicklistener listener) {
        this.context = context;
        this.mData = mData;
        moiveitemclicklistener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_moive, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.Tvtitle.setText(mData.get(position).getTitle());
        holder.imgMoive.setImageResource(mData.get(position).getThumbnail());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView Tvtitle;
        private ImageView imgMoive;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Tvtitle = itemView.findViewById(R.id.item_moive_title);
            imgMoive = itemView.findViewById(R.id.item_moive_img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    moiveitemclicklistener.onMoiveClick(mData.get(getAdapterPosition()),imgMoive);
                }
            });
        }
    }
}
