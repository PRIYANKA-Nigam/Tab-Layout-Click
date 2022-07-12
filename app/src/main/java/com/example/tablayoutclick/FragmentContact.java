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

public class FragmentContact extends Fragment {
    View view;
    private RecyclerView recyclerView;
    private List<Contact> list;
    public FragmentContact() {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.contact_frag,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.rec);
        RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<>();
        list.add(new Contact("Priyanka","(111) 251236741",R.drawable.gg1));
        list.add(new Contact("Chiya","(111) 251236741",R.drawable.gg2));
        list.add(new Contact("Tessy","(111) 251236741",R.drawable.gg3));
        list.add(new Contact("Hina","(111) 251236741",R.drawable.gg4));
        list.add(new Contact("Shelly","(111) 251236741",R.drawable.gg6));
        list.add(new Contact("Divya","(111) 251236741",R.drawable.p2));
        list.add(new Contact("Priyanka","(111) 251236741",R.drawable.gg1));
        list.add(new Contact("Chiya","(111) 251236741",R.drawable.gg2));
        list.add(new Contact("Tessy","(111) 251236741",R.drawable.gg3));
        list.add(new Contact("Hina","(111) 251236741",R.drawable.gg4));
        list.add(new Contact("Shelly","(111) 251236741",R.drawable.gg6));
        list.add(new Contact("Divya","(111) 251236741",R.drawable.p2));
        list.add(new Contact("Priyanka","(111) 251236741",R.drawable.gg1));
        list.add(new Contact("Chiya","(111) 251236741",R.drawable.gg2));
        list.add(new Contact("Tessy","(111) 251236741",R.drawable.gg3));
        list.add(new Contact("Hina","(111) 251236741",R.drawable.gg4));
        list.add(new Contact("Shelly","(111) 251236741",R.drawable.gg6));
        list.add(new Contact("Divya","(111) 251236741",R.drawable.p2));
    }
}
