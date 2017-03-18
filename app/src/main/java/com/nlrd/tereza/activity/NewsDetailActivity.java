package com.nlrd.tereza.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.nlrd.tereza.R;
import com.nlrd.tereza.models.HomeObject;


public class NewsDetailActivity extends AppCompatActivity {

    ImageView ivimage;
    TextView tvnewstitle;
    TextView tvauthor;
    TextView tvdesc;

    HomeObject homeObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        Bundle b = getIntent().getExtras();

        if (b != null) {
            homeObject = (HomeObject) b.get("object");
        }

        init();
        fillData();
    }

    public void fillData() {
        tvnewstitle.setText(homeObject.news_title);
        tvdesc.setText(homeObject.news_description);
        tvauthor.setText("Published by : " + homeObject.news_authorname + " " + homeObject.news_published_date);
    }



    private void init() {

        ivimage = (ImageView) findViewById(R.id.ivimage);
        tvnewstitle = (TextView) findViewById(R.id.tvnewstitle);
        tvauthor = (TextView) findViewById(R.id.tvauthor);
        tvdesc = (TextView) findViewById(R.id.tvdesc);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
