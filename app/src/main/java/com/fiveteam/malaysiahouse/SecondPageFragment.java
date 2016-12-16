package com.fiveteam.malaysiahouse;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondPageFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private String p2Listitems[];
    private ListView mListView;

    public SecondPageFragment() {
        // Required empty public constructor
    }

    public static SecondPageFragment newInstance(int sectionNumber) {
        SecondPageFragment fragment = new SecondPageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_second_page, container, false);

        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        final ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        p2Listitems=getResources().getStringArray(R.array.page2_main_list);
        mListView = (ListView) rootView.findViewById(R.id.LV_p2);
        mListView.setAdapter(new p2ListAdapter());

        Spinner spinner = (Spinner)rootView.findViewById(R.id.tab2_spinner);
        final String aryspin[] = getResources().getStringArray(R.array.tab2_title_spinner);
        ArrayAdapter<String> aryspinList = new ArrayAdapter<>(getActivity(),
                R.layout.spinner_style, aryspin);
        aryspinList.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(aryspinList);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getActivity(), "你選的是" + aryspin[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return rootView;
    }

    private class p2ListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return p2Listitems.length;
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
                v = LayoutInflater.from(getActivity()).inflate(R.layout.list_item2, null);
                holder = new Holder();
                holder.text = (TextView) v.findViewById(R.id.TV_listItem);

                v.setTag(holder);
            } else{
                holder = (Holder) v.getTag();
            }

            holder.text.setText(p2Listitems[position]);
            return v;
        }
        class Holder{
            TextView text;
        }
    }


}
