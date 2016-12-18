package com.fiveteam.malaysiahouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SRPageActivity extends AppCompatActivity {
    private ListView mListView;
    private int[] ad1images = new ItemGroups().house_images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srpage);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mListView = (ListView) findViewById(R.id.LV_srpage);
        mListView.setAdapter(new srpageListAdapter());

        TextView toMap = (TextView) findViewById(R.id.TV_srpage_map);
        toMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SRPageActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });
    }

    private class srpageListAdapter extends BaseAdapter {

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
                v = LayoutInflater.from(SRPageActivity.this).inflate(R.layout.list_item_houseinfo, null);
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
            //TextView text;
        }
    }
}
