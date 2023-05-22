package com.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class soppingcartRecyerView extends RecyclerView.Adapter<soppingcartRecyerView.MyViewHolder> {

    Context context;
    ArrayList<shoppingcartNoteModel> noteModels;
    public soppingcartRecyerView(Context context,ArrayList<shoppingcartNoteModel> noteModels){
        this.context = context;
        this.noteModels = noteModels;
    }
    @NonNull
    @Override
    public soppingcartRecyerView.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_shopping_cart, parent, false);

        return new soppingcartRecyerView.MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull soppingcartRecyerView.MyViewHolder holder, int position) {
        holder.tvTitle.setText(noteModels.get(position).gettitle());
        holder.tvDetail.setText(noteModels.get(position).getDetail());
        holder.tvImage.setImageResource(noteModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return noteModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle,tvDetail;
        ImageView tvImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.textView);
            tvDetail = itemView.findViewById(R.id.textView2);
            tvImage = itemView.findViewById(R.id.imageView3);

        }
    }
}
