package com.example.tablayoutclick;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
Context context; Dialog dialog;
List<Contact> list;

    public RecyclerViewAdapter(Context context, List<Contact> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(context).inflate(R.layout.item_contact,parent,false);
       final MyViewHolder myViewHolder=new MyViewHolder(view);
        dialog=new Dialog(context);
        dialog.setContentView(R.layout.dialog_contact);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myViewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView textView=(TextView)dialog.findViewById(R.id.tt);
                TextView textView2=(TextView)dialog.findViewById(R.id.tt2);
                ImageView imageView=(ImageView)dialog.findViewById(R.id.im);
                textView.setText(list.get(myViewHolder.getAdapterPosition()).getName());
                textView2.setText(list.get(myViewHolder.getAdapterPosition()).getPhone());
                imageView.setImageResource(list.get(myViewHolder.getAdapterPosition()).getPhoto());

                Toast.makeText(context,"Test Clicked"+String.valueOf(myViewHolder.getAdapterPosition()),Toast.LENGTH_LONG).show();
                dialog.show();
            }
        });
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
holder.t1.setText(list.get(position).getName());
holder.t2.setText(list.get(position).getPhone());
holder.imageView.setImageResource(list.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
private TextView t1,t2;
private ImageView imageView;
private LinearLayout layout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            layout=itemView.findViewById(R.id.contact);
            t1=itemView.findViewById(R.id.cn);
            t2=itemView.findViewById(R.id.pn);
            imageView=itemView.findViewById(R.id.img);

        }
    }
}
