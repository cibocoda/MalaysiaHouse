package com.fiveteam.malaysiahouse;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class P1slcvpItemsFragment extends Fragment {
    int position;
    private static final String ARG_SECTION_NUMBER = "section_number";
    private View rootView;
    String[] mResources;

    public P1slcvpItemsFragment() {
        // Required empty public constructor
    }

    public static P1slcvpItemsFragment newInstance(int sectionNumber) {
        P1slcvpItemsFragment fragment = new P1slcvpItemsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.p1slcvp_items, container, false);
        ImageView leftarrow = (ImageView) rootView.findViewById(R.id.IV_p1slcvp1);
        ImageView rightarrow = (ImageView) rootView.findViewById(R.id.IV_p1slcvp2);

        leftarrow.setVisibility(View.VISIBLE);
        rightarrow.setVisibility(View.VISIBLE);

        Bundle bundle = getArguments();
        if (bundle != null) {
            position = bundle.getInt(ARG_SECTION_NUMBER);
        }

        /*Toast toast = Toast.makeText(getActivity(),
                Integer.toString(position), Toast.LENGTH_LONG);
        //顯示Toast
        toast.show();*/
        mResources = getResources().getStringArray(R.array.page1_select_list);
        int counts , gvnumbers = position*8;
        if(((position+1)*8) <= mResources.length){
            counts = 8;
        }else{
            counts = mResources.length%8;
        }

        List<Map<String, Object>> items = new ArrayList<>();
        for (int i = 0; i < counts; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("image", R.drawable.ic_home_black_24dp);
            item.put("text", mResources[(i+gvnumbers)]);
            items.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(getContext(),
                items, R.layout.p1slcvp1_gv_items, new String[]{"image", "text"},
                new int[]{R.id.IV_p1slcvp1_gv, R.id.TV_p1slcvp1_gv});

        GridView gridView = (GridView)rootView.findViewById(R.id.GV_p1slcvp1);
        gridView.setNumColumns(4);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }

        });

        if(position==0){
            leftarrow.setVisibility(View.INVISIBLE);
        }else if(mResources.length < ((position+1)*8)){
            rightarrow.setVisibility(View.INVISIBLE);
        }

        return rootView;
    }

}
