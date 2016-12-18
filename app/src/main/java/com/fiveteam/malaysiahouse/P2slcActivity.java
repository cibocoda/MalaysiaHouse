package com.fiveteam.malaysiahouse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class P2slcActivity extends AppCompatActivity {
    private ListView mListView;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2slc);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tvslc = (TextView) findViewById(R.id.TV_p2slc_title);
        bundle = getIntent().getExtras();
        tvslc.setText(bundle.getString("title"));

        mListView = (ListView) findViewById(R.id.LV_p2slc);
        mListView.setAdapter(new p2slcListAdapter());
    }

    private class p2slcListAdapter extends BaseAdapter {
        int counts_temp = 5;

        @Override
        public int getCount() {
            return counts_temp;
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
                v = LayoutInflater.from(P2slcActivity.this).inflate(R.layout.list_item_p2selections, null);
                holder = new Holder();
                holder.text = (TextView) v.findViewById(R.id.TV_listItem);

                v.setTag(holder);
            } else{
                holder = (Holder) v.getTag();
            }
            String ntitle = bundle.getString("title")+ "項目 " + Integer.toString(position);
            holder.text.setText(ntitle);
            return v;
        }
        class Holder{
            TextView text;
        }
    }

}
