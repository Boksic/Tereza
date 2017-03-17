package com.nlrd.tereza.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nlrd.tereza.R;
import com.nlrd.tereza.models.HomeObject;
import com.nlrd.tereza.adapters.HomeNewsAdapter;

import java.util.ArrayList;

import static com.nlrd.tereza.R.id.lvdata;

public class HomeFragment extends Fragment
{
    ListView lvdata;

    ArrayList<HomeObject> data = new ArrayList<>();

    public boolean isLoaded = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_news, container, false);

        lvdata = (ListView) v.findViewById(R.id.lvdata);


        data = new ArrayList<>();
        data.add(new HomeObject());
        data.add(new HomeObject());

        HomeNewsAdapter adapter = new HomeNewsAdapter(getActivity(),0, data);
        lvdata.setAdapter(adapter);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (isLoaded) {
            LatestListAsync aTask = new LatestListAsync();
            if (aTask.getStatus().equals(AsyncTask.Status.PENDING)) {
                aTask.execute();
            }
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser) {
            if (!isLoaded) {
                LatestListAsync aTask = new LatestListAsync();
                if (aTask.getStatus().equals(AsyncTask.Status.PENDING)) {
                    aTask.execute();
                }
            }
            isLoaded = true;
        }

    }

    class LatestListAsync extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            data = new ArrayList<>();
            data.add(new HomeObject());
            data.add(new HomeObject());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (data.size() != 0) {
                HomeNewsAdapter adapter = new HomeNewsAdapter(getActivity(), 0, data);
                lvdata.setAdapter(adapter);
            } else {

            }
        }
    }
    /*ArrayList<HomeObject> data = new ArrayList<>();

    public boolean isLoaded = false;

    ListView lvdata;
    public static HomeFragment getInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_news, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvdata = (ListView) view.findViewById(R.id.lvdata);
    }


    @Override
    public void onStart() {
        super.onStart();
        if (isLoaded) {
            LatestListAsync aTask = new LatestListAsync();
            if (aTask.getStatus().equals(AsyncTask.Status.PENDING)) {
                aTask.execute();
            }
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser) {
            if (!isLoaded) {
                LatestListAsync aTask = new LatestListAsync();
                if (aTask.getStatus().equals(AsyncTask.Status.PENDING)) {
                    aTask.execute();
                }
            }
            isLoaded = true;
        }

    }

    class LatestListAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            data = new ArrayList<>();
            data.add(new HomeObject());
            data.add(new HomeObject());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (data.size() != 0) {
                HomeNewsAdapter adapter = new HomeNewsAdapter(getActivity(),0, data);
                lvdata.setAdapter(adapter);
            } else {

            }
        }
    }*/
}
