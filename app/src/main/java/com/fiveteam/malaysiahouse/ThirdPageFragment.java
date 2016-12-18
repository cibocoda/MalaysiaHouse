package com.fiveteam.malaysiahouse;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdPageFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private int imageId[]=new ItemGroups().page3_list_icons;
    private String p3Listitems[];
    private ListView mListView;
    private TextView mLogin;
    private View rootView;

    public ThirdPageFragment() {
        // Required empty public constructor
    }

    public static ThirdPageFragment newInstance(int sectionNumber) {
        ThirdPageFragment fragment = new ThirdPageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_third_page, container, false);

        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        final ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        p3Listitems=getResources().getStringArray(R.array.page3_main_list);
        mListView = (ListView) rootView.findViewById(R.id.LV_p3);
        mListView.setAdapter(new p3ListAdapter());
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getContext(), "你選擇的是" + list[position], Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
                bundle.putString("title", p3Listitems[position]);
                Intent intent = new Intent(getActivity(), P2slcActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        mLogin = (TextView) rootView.findViewById(R.id.TV_p3_login);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("title", mLogin.getText().toString());
                Intent intent = new Intent(getActivity(), P2slcActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        return rootView;
    }

    private class p3ListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return p3Listitems.length;
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
                v = LayoutInflater.from(getActivity()).inflate(R.layout.list_item_page34, null);
                holder = new Holder();
                holder.image = (ImageView) v.findViewById(R.id.IV_listItem);
                holder.text = (TextView) v.findViewById(R.id.TV_listItem);

                v.setTag(holder);
            } else{
                holder = (Holder) v.getTag();
            }

            holder.image.setImageResource(imageId[position]);
            holder.text.setText(p3Listitems[position]);
            return v;
        }
        class Holder{
            ImageView image;
            TextView text;
        }
    }

}
