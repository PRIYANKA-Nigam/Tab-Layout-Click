package com.example.tablayoutclick;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> implements Filterable {
    private List<Contact> v;
    private static final int REQUEST_CALL = 1 ;
    Context context; Dialog dialog;
List<Contact> list;
TextView textView2;
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
                textView2=(TextView)dialog.findViewById(R.id.tt2);
                ImageView imageView=(ImageView)dialog.findViewById(R.id.im);
                textView.setText(list.get(myViewHolder.getAdapterPosition()).getName());
                textView2.setText(list.get(myViewHolder.getAdapterPosition()).getPhone());
                imageView.setImageResource(list.get(myViewHolder.getAdapterPosition()).getPhoto());
                Button b1=(Button)dialog.findViewById(R.id.bb);
                Button b2=(Button)dialog.findViewById(R.id.bb2);
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String n=textView2.getText().toString();
                      Intent intent=new Intent(context,PhoneActivity.class);
                      intent.putExtra("call",n);
                      context.startActivity(intent);
                    }
                });
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String n=textView2.getText().toString();
                        Intent intent=new Intent(context,SMSActivity.class);
                        intent.putExtra("sms",n);
                        context.startActivity(intent);
                    }
                });
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
holder.imageView2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String n=holder.t2.getText().toString();
        Intent intent=new Intent(context,PhoneActivity.class);
        intent.putExtra("call",n);
        context.startActivity(intent);
    }
});
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

//    public void setFilter(String newText) {
//      v=new ArrayList<>(); o=new ArrayList<>();
//        for (String i : o){
//          if (i.toLowerCase().contains(newText))
//              v.add(i);
//      }
//      notifyDataSetChanged();
//    }

    @Override
    public Filter getFilter() {   v=new ArrayList<>();
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                charSequence=charSequence.toString().toLowerCase().trim();
               // list.clear();
                if (charSequence.length()==0)
                    list.addAll(v);
                else {
                    for (Contact c:v){
                        if (c.getName().toLowerCase(Locale.getDefault()).contains(charSequence)||c.getPhone().toLowerCase(Locale.getDefault()).contains(charSequence)){
                            list.add(c);
                        }
                    }
                }
                FilterResults results=new FilterResults();
                results.values=list;
                results.count=list.size();
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
             if (filterResults.count==0){
                 Toast.makeText(context,"No Results Found",Toast.LENGTH_LONG).show();
                 notifyDataSetChanged();
             }else {
                 notifyDataSetChanged();
             }
            }
        };
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
private TextView t1,t2;
private ImageView imageView,imageView2;
private LinearLayout layout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            layout=itemView.findViewById(R.id.contact);
            t1=itemView.findViewById(R.id.cn);
            t2=itemView.findViewById(R.id.pn);
            imageView=itemView.findViewById(R.id.img);
            imageView2=itemView.findViewById(R.id.img2);


        }
    }
}
