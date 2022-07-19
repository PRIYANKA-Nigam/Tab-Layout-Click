package com.example.tablayoutclick;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentFav extends Fragment {
    View view; TextView t1,t2;
    public FragmentFav() {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fav_fragment,container,false);
        t1=view.findViewById(R.id.textView12);
        t2=view.findViewById(R.id.textView13);
//         Bundle bundle=this.getArguments();
//         if(bundle!=null) {
//             String data = bundle.getString("names");
//             String data2 = bundle.getString("mob");
//             t1.setText(data);
//             t2.setText(data2);
//         }
        return view;
    }
}
