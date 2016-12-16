package com.fiveteam.malaysiahouse;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FourthPageFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private int imageId[]=new ItemGroups().page4_list_icons;
    private String p4Listitems[];
    private ListView mListView;

    public FourthPageFragment() {
        // Required empty public constructor
    }

    public static FourthPageFragment newInstance(int sectionNumber) {
        FourthPageFragment fragment = new FourthPageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fourth_page, container, false);

        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        final ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        p4Listitems=getResources().getStringArray(R.array.page4_main_list);
        mListView = (ListView) rootView.findViewById(R.id.LV_p4);
        mListView.setAdapter(new p4ListAdapter());
        return rootView;
    }

    private class p4ListAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return p4Listitems.length;
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
                v = LayoutInflater.from(getActivity()).inflate(R.layout.list_item, null);
                holder = new Holder();
                holder.image = (ImageView) v.findViewById(R.id.IV_listItem);
                holder.text = (TextView) v.findViewById(R.id.TV_listItem);

                v.setTag(holder);
            } else{
                holder = (Holder) v.getTag();
            }

            holder.image.setImageResource(imageId[position]);
            holder.text.setText(p4Listitems[position]);
            return v;
        }
        class Holder{
            ImageView image;
            TextView text;
        }
    }
}
