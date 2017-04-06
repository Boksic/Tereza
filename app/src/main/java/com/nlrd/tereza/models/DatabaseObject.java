package com.nlrd.tereza.models;

/**
 * Created by BOKSIC on 11/01/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseObject
{
    private static Database dbHelper;
    private SQLiteDatabase db;

    public DatabaseObject(Context context)
    {
        dbHelper = new Database(context);
        this.db = dbHelper.getWritableDatabase();
        this.db = dbHelper.getReadableDatabase();
    }

    public SQLiteDatabase getDbConnection()
    {
        return this.db;
    }

    public void closeDbConnection()
    {
        if(this.db != null)
        {
            this.db.close();
        }
    }
}
