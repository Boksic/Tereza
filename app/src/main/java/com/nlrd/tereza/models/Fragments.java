package com.nlrd.tereza.models;


import android.support.v4.app.Fragment;

/**
 * Created by User on 03/07/15.
 */
public class Fragments implements Comparable<Fragments> {

    public Fragment fragment = null;
    public String title  = "";

    public Fragments(Fragment fragment, String title){
        this.fragment = fragment;
        this.title = title;
    }


    @Override
    public int compareTo(Fragments temp) {
        return title.compareTo(temp.getTitle());
    }

    public String getTitle(){
        return this.title;
    }

}
