package com.example.tablayoutclick;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder2 > {
    Context context;  List<Chat> list;
     Dialog dialog;  ImageView imageView;
    public ChatAdapter(Context context, List<Chat> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(context).inflate(R.layout.item_chat,parent,false);
        final ChatAdapter.MyViewHolder2 myViewHolder= new MyViewHolder2(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
holder.imageView.setImageResource(list.get(position).getPhoto());
holder.t1.setText(list.get(position).getName());
holder.t2.setText(list.get(position).getNum());
holder.imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(view.getRootView().getContext());
        View dialogView =LayoutInflater.from(view.getRootView().getContext()).inflate(R.layout.dialog_chat_image,null);
        ImageView imageView=(ImageView)dialogView.findViewById(R.id.im);
        ImageButton imageView2=dialogView.findViewById(R.id.imageButton);
       ImageButton imageView3=dialogView.findViewById(R.id.imageButton2);
                     imageView2.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View view) {
                             Animation animation= AnimationUtils.loadAnimation(context,R.anim.zoom_in);
                             imageView.startAnimation(animation);
                         }
                     });
                     imageView3.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View view) {
                             Animation animation= AnimationUtils.loadAnimation(context,R.anim.zoom_out);
                             imageView.startAnimation(animation);
                         }
                     });
        imageView.setImageResource(list.get(holder.getAdapterPosition()).getPhoto());
        builder.setView(dialogView);
        builder.setCancelable(true);
        builder.show();
    }
});
holder.layout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(context, ChatActivity.class);
        intent.putExtra("Desc",list.get(holder.getAdapterPosition()).getPhoto());
        intent.putExtra("Num",list.get(holder.getAdapterPosition()).getNum());
        intent.putExtra("Name",list.get(holder.getAdapterPosition()).getName());

        context.startActivity(intent);
    }
});
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder{
        private TextView t1,t2;
        private ImageView imageView;
        private LinearLayout layout;
        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            layout=itemView.findViewById(R.id.call);
            t1=itemView.findViewById(R.id.cn);
            t2=itemView.findViewById(R.id.num);
            imageView=itemView.findViewById(R.id.img);


        }
    }
}
