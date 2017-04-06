package com.nlrd.tereza.models;

/**
 * Created by BOKSIC on 11/01/2017.
 */

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class Database extends SQLiteAssetHelper
{
    private static final String DATABASE_NAMES = "events.db.zip";
    private static final int DATABASE_VERSION = 3;

    public Database(Context context)
    {
        super(context, DATABASE_NAMES, null, DATABASE_VERSION);
    }
}
