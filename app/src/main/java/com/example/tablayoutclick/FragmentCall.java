package com.example.tablayoutclick;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentCall extends Fragment {
    View view;
    private RecyclerView recyclerView;
    private List<Call> list;
    public FragmentCall() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.call_frag,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.rec);
       CallAdapter callAdapter=new CallAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(callAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<>();
        list.add(new Call("Priyanka","8932946515",R.drawable.gg1));
        list.add(new Call("Chiya","9129520224",R.drawable.gg2));
        list.add(new Call("Priya","9599339822",R.drawable.gg3));
        list.add(new Call("Babloo","9450728740",R.drawable.gg4));
        list.add(new Call("Vishnu","8317063305",R.drawable.gg6));
        list.add(new Call("Vivek","9695012565",R.drawable.p2));
        list.add(new Call("Abhishek","8707216762",R.drawable.gg1));
        list.add(new Call("Divya","9461799737",R.drawable.gg2));
        list.add(new Call("Sunita","8604453309",R.drawable.gg3));
        list.add(new Call("Priyanka","8932946515",R.drawable.gg1));
        list.add(new Call("Chiya","9129520224",R.drawable.gg2));
        list.add(new Call("Priya","9599339822",R.drawable.gg3));
        list.add(new Call("Babloo","9450728740",R.drawable.gg4));
        list.add(new Call("Vishnu","8317063305",R.drawable.gg6));
        list.add(new Call("Vivek","9695012565",R.drawable.p2));
        list.add(new Call("Abhishek","8707216762",R.drawable.gg1));
        list.add(new Call("Divya","9461799737",R.drawable.gg2));
        list.add(new Call("Sunita","8604453309",R.drawable.gg3));
        list.add(new Call("Hina","(111) 251236741",R.drawable.gg4));
        list.add(new Call("Shelly","(111) 251236741",R.drawable.gg6));
        list.add(new Call("Divya","(111) 251236741",R.drawable.p2));
        list.add(new Call("Priyanka","(111) 251236741",R.drawable.gg1));
        list.add(new Call("Chiya","(111) 251236741",R.drawable.gg2));
        list.add(new Call("Tessy","(111) 251236741",R.drawable.gg3));
        list.add(new Call("Hina","(111) 251236741",R.drawable.gg4));
        list.add(new Call("Shelly","(111) 251236741",R.drawable.gg6));
        list.add(new Call("Divya","(111) 251236741",R.drawable.p2));
    }
}
