package com.nlrd.tereza.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nlrd.tereza.models.HomeObject;
import com.nlrd.tereza.activity.NewsDetailActivity;
import com.nlrd.tereza.R;

import java.util.ArrayList;

/**
 * Created by dharmesh panchal on 04-12-2016.
 */
public class HomeNewsAdapter extends ArrayAdapter<HomeObject> {

    ArrayList<HomeObject> dataList = new ArrayList<>();

    Context context;

    public HomeNewsAdapter(Context context, int textViewResourceId, ArrayList<HomeObject> objects) {
        super(context, textViewResourceId, objects);
        this.dataList = objects;
        this.context = context;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = null;

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.custom_home_item, null);

        TextView tvdesc;
        ImageView ivimage;


        tvdesc = (TextView) v.findViewById(R.id.tvdesc);
        ivimage = (ImageView) v.findViewById(R.id.ivimage);

        tvdesc.setText(dataList.get(position).news_title);

        tvdesc.setTag(position);
        tvdesc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int index = (int) v.getTag();
                HomeObject t = dataList.get(index);
                Intent detailAct = new Intent(context, NewsDetailActivity.class);
                detailAct.putExtra("object",t);
                context.startActivity(detailAct);
            }
        });

        ivimage.setTag(position);
        ivimage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int index = (int) v.getTag();
                HomeObject t = dataList.get(index);
                Intent detailAct = new Intent(context, NewsDetailActivity.class);
                detailAct.putExtra("object",t);
                context.startActivity(detailAct);
            }
        });


        return v;

    }

}