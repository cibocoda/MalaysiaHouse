package com.fiveteam.malaysiahouse;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstPageFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private ViewPager ad1viewPager, slcviewPager;
    private View rootView;
    private int[] ad1images = new ItemGroups().house_images;
    private String[] aryslc;
    private int selectedItem = 0;
    private TextView areaCheck, searchBar;

    public FirstPageFragment() {
        // Required empty public constructor
    }

    public static FirstPageFragment newInstance(int sectionNumber) {
        FirstPageFragment fragment = new FirstPageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_first_page, container, false);
        aryslc = getResources().getStringArray(R.array.page1_select_list);

        areaCheck = (TextView) rootView.findViewById(R.id.fp_tab_tv1);
        areaCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("title", "地區");
                Intent intent = new Intent(getActivity(), P2slcActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        searchBar = (TextView) rootView.findViewById(R.id.TV_tab1_sreachbar);
        searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SRPageActivity.class);
                startActivity(intent);
            }
        });

        initToolbar();
        initad1VP();
        initslcVP();
        initnhGV();
        initgsLV();

        return rootView;
    }

    public void initToolbar(){
        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        final ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
    }

    public void initad1VP(){
        P1ad1VPAdapter mCustomPagerAdapter = new P1ad1VPAdapter(getContext());
        ad1viewPager = (ViewPager) rootView.findViewById(R.id.VP_p1_ad1);
        ad1viewPager.setAdapter(mCustomPagerAdapter);
        ad1viewPager.setCurrentItem(0);
    }

    public  void initslcVP(){
        P1slcVPAdapter mCustomPagerAdapter = new P1slcVPAdapter(getActivity().getSupportFragmentManager());
        slcviewPager = (ViewPager) rootView.findViewById(R.id.VP_p1_selects);
        slcviewPager.setAdapter(mCustomPagerAdapter);
        slcviewPager.setCurrentItem(0);
    }

    public void initnhGV(){
        String[] mResources = getResources().getStringArray(R.array.page1_newhouse_list);
        List<Map<String, Object>> items = new ArrayList<>();
        for (int i = 0; i < mResources.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("image", R.drawable.ic_home_black_24dp);
            item.put("text", mResources[i]);
            items.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(getContext(),
                items, R.layout.p1slcvp1_gv_items, new String[]{"image", "text"},
                new int[]{R.id.IV_p1slcvp1_gv, R.id.TV_p1slcvp1_gv});
        GridView gridView = (GridView)rootView.findViewById(R.id.GV_p1_newhouse);
        gridView.setNumColumns(3);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }

        });
    }

    public void initgsLV(){
        ListView mListView = (ListView) rootView.findViewById(R.id.LV_p1_guess_list);
        mListView.setAdapter(new p1ListAdapter());
        setListViewHeightBasedOnChildren(mListView);
    }

    private class p1ListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return ad1images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            Holder holder;
            if(v == null){
                v = LayoutInflater.from(getActivity()).inflate(R.layout.list_item_houseinfo, null);
                holder = new Holder();
                holder.image = (ImageView) v.findViewById(R.id.IV_listItem);
                //holder.text = (TextView) v.findViewById(R.id.TV_listItem);

                v.setTag(holder);
            } else{
                holder = (Holder) v.getTag();
            }

            holder.image.setImageResource(ad1images[position]);
            //holder.text.setText("房屋資訊");
            return v;
        }
        class Holder{
            ImageView image;
            TextView text;
        }
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            if (listItem instanceof ViewGroup) {
                listItem.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, AbsListView.LayoutParams.WRAP_CONTENT));
            }
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            ad1viewPager.setCurrentItem(selectedItem);
            selectedItem++;
            if(selectedItem == ad1images.length){
                selectedItem = 0;
            }
            mHandler.sendEmptyMessageDelayed(0, 3000);
        }
    };

    //每次當onResume有焦點時發送個空消息開始輪播
    @Override
    public void onResume(){
        super.onResume();
        mHandler.sendEmptyMessageDelayed(0, 2000);
    }

    //當暫停時停止輪播
    @Override
    public void onPause(){
        super.onPause();
        mHandler.removeCallbacksAndMessages(null);
    }
}
