package com.example.tablayoutclick;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentContact extends Fragment {   MenuItem menuItem;
    View view;  RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;
    private List<Contact> list;
    public FragmentContact() {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     //   myViewHolder=new RecyclerViewAdapter.MyViewHolder(view);
        view=inflater.inflate(R.layout.contact_frag,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.rec);
      recyclerViewAdapter=new RecyclerViewAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<>();
        list.add(new Contact("Priyanka","8932946515",R.drawable.gg1));
        list.add(new Contact("Chiya","9129520224",R.drawable.gg2));
        list.add(new Contact("Priya","9599339822",R.drawable.gg3));
        list.add(new Contact("Babloo","9450728740",R.drawable.gg4));
        list.add(new Contact("Vishnu","8317063305",R.drawable.gg6));
        list.add(new Contact("Vivek","9695012565",R.drawable.p2));
        list.add(new Contact("Abhishek","8707216762",R.drawable.gg1));
        list.add(new Contact("Divya","9461799737",R.drawable.gg2));
        list.add(new Contact("Sunita","8604453309",R.drawable.gg3));
        list.add(new Contact("Priyanka","8932946515",R.drawable.gg1));
        list.add(new Contact("Chiya","9129520224",R.drawable.gg2));
        list.add(new Contact("Priya","9599339822",R.drawable.gg3));
        list.add(new Contact("Babloo","9450728740",R.drawable.gg4));
        list.add(new Contact("Vishnu","8317063305",R.drawable.gg6));
        list.add(new Contact("Vivek","9695012565",R.drawable.p2));
        list.add(new Contact("Abhishek","8707216762",R.drawable.gg1));
        list.add(new Contact("Divya","9461799737",R.drawable.gg2));
        list.add(new Contact("Sunita","8604453309",R.drawable.gg3));
        list.add(new Contact("Hina","(111) 251236741",R.drawable.gg4));
        list.add(new Contact("Shelly","(111) 251236741",R.drawable.gg6));
        list.add(new Contact("Divya","(111) 251236741",R.drawable.p2));
        list.add(new Contact("Priyanka","(111) 251236741",R.drawable.gg1));
        list.add(new Contact("Chiya","(111) 251236741",R.drawable.gg2));
        list.add(new Contact("Tessy","(111) 251236741",R.drawable.gg3));
        list.add(new Contact("Hina","(111) 251236741",R.drawable.gg4));
        list.add(new Contact("Shelly","(111) 251236741",R.drawable.gg6));
        list.add(new Contact("Divya","(111) 251236741",R.drawable.p2));
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    //  inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);
//        MenuItem item=menu.findItem(R.id.sea);
//      //  menuItem=menu.add("menu_search");
//        SearchView searchView=(SearchView)item.getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
////                ((RecyclerViewAdapter)recyclerView.getAdapter()).setFilter(query);
////                recyclerViewAdapter.notifyDataSetChanged();
//               // recyclerViewAdapter.getFilter().filter(query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                recyclerViewAdapter.getFilter().filter(newText);
//                return false;
//            }
//        });
    }


//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId()==R.id.note){ Intent intent=new Intent(getContext(),NoteActivity.class);
//            startActivity(intent);return true; }
//        return false;
//
//    }
}
