package com.example.pocbottomsheetchipgroup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRv extends RecyclerView.Adapter<AdapterRv.ViewHolder>{


    ArrayList Img, Name;
    Context context;

    public AdapterRv(Context context, ArrayList Img, ArrayList Name) {
        this.context = context;
        this.Img = Img;
        this.Name = Name;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView photo;
        TextView teks;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.imageCardRv);
            teks = itemView.findViewById(R.id.imageinfo);
        }
    }


    @NonNull
    @Override
    public AdapterRv.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRv.ViewHolder holder, int position) {
        int res = (int) Img.get(position);
        holder.photo.setImageResource(res);
        holder.teks.setText((CharSequence) Name.get(position));
    }

    @Override
    public int getItemCount() {
        return Img.size();
    }
}
