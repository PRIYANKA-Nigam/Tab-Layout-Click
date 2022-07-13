package com.example.tablayoutclick;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
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

public class CallAdapter extends RecyclerView.Adapter<CallAdapter.MyViewHolder2 > {
    Context context;  List<Call> list;
     Dialog dialog;
    public CallAdapter(Context context, List<Call> list) {
        this.context = context;
        this.list = list;
    }

    public CallAdapter() {

    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(context).inflate(R.layout.item_call,parent,false);
        final CallAdapter.MyViewHolder2 myViewHolder= new MyViewHolder2(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {

holder.imageView.setImageResource(list.get(position).getPhoto());
holder.t1.setText(list.get(position).getName());

holder.imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(context,"clicked",Toast.LENGTH_LONG).show();
//        dialog=new Dialog(context);
//        dialog.setContentView(R.layout.dialog_call_image);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        ImageView imageView=(ImageView)dialog.findViewById(R.id.im);
//        imageView.setImageResource(list.get(holder.getAdapterPosition()).getPhoto());
    }
});
holder.layout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
   context.startActivity(new Intent(context,CallActivity.class));
    }
});
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder{
        private TextView t1;
        private ImageView imageView;
        private LinearLayout layout;
        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            layout=itemView.findViewById(R.id.call);
            t1=itemView.findViewById(R.id.cn);
            imageView=itemView.findViewById(R.id.img);


        }
    }
}
