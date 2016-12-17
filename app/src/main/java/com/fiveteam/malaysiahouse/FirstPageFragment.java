package com.fiveteam.malaysiahouse;


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

        initToolbar();
        initad1VP();
        initslcVP();

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
