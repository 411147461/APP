package com.example.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Note_RecyclerViewAdapter extends RecyclerView.Adapter<Note_RecyclerViewAdapter.MyViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;

    Context context;
    ArrayList<NoteModel> noteModels;
    public Note_RecyclerViewAdapter(Context context,ArrayList<NoteModel>noteModels,RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.noteModels = noteModels;
        this.recyclerViewInterface = recyclerViewInterface;
    }
    @NonNull
    @Override
    public Note_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);

        return new Note_RecyclerViewAdapter.MyViewHolder(view,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Note_RecyclerViewAdapter.MyViewHolder holder, int position) {
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
        Button tvButton;

        public MyViewHolder(@NonNull View itemView,RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.mTitleText);
            tvDetail = itemView.findViewById(R.id.mDetailText);
            tvImage = itemView.findViewById(R.id.imageView2);
            tvButton = itemView.findViewById(R.id.button);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if (recyclerViewInterface != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemLongClick(position);
                        }
                    }
                    return true;
                }
            });

            tvButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onButtonClick(position);
                        }
                    }
                }
            });

        }
    }
}