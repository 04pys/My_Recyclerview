package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    ArrayList<Item> items = new ArrayList<>();


    public RecyclerAdapter(ArrayList<Item> items) {
        this.items = items;
    }

    public interface OnItemClickListener{
        void onItemClick(View v,int position);
    }

    private OnItemClickListener mListener = null;

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item,parent,false);
        RecyclerAdapter.ViewHolder viewHolder= new RecyclerAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        Item item = items.get(position);
        holder.tobTv.setText(item.getTopText());
        holder.bottomTv.setText(item.getBottomText());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tobTv, bottomTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img);
            tobTv = itemView.findViewById(R.id.tobTv);
            bottomTv = itemView.findViewById(R.id.bottomTv);

            itemView.setOnClickListener(v -> {
                int pos = getAdapterPosition();
                Log.e("position",pos+"");

                if(pos != RecyclerView.NO_POSITION){
                    mListener.onItemClick(v,pos);

                }
            });
        }
    }
}
