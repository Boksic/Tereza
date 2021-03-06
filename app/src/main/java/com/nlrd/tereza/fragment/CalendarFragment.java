package com.nlrd.tereza.fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.nlrd.tereza.R;
import com.nlrd.tereza.activity.MainActivity;
import com.nlrd.tereza.models.DatabaseQuery;
import com.nlrd.tereza.models.EventObjects;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CalendarFragment extends Fragment
{
    private static final String TAG = MainActivity.class.getSimpleName();
    private ImageView previousDay;
    private ImageView nextDay;
    private TextView currentDate;
    private Calendar cal = Calendar.getInstance();
    private DatabaseQuery mQuery;
    private RelativeLayout mLayout;
    private int eventIndex;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        mQuery = new DatabaseQuery(view.getContext().getApplicationContext());
        mLayout = (RelativeLayout) view.findViewById(R.id.left_event_column);
        eventIndex = mLayout.getChildCount();
        currentDate = (TextView) view.findViewById(R.id.display_current_date);
        currentDate.setText(displayDateInString(cal.getTime()));

        displayDailyEvents();

        previousDay = (ImageView) view.findViewById(R.id.previous_day);
        nextDay = (ImageView) view.findViewById(R.id.next_day);

        previousDay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                previousCalendarDate();
            }
        });

        nextDay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                nextCalendarDate();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    private void previousCalendarDate()
    {
        try {
            mLayout.removeViewAt(eventIndex - 1);
        } catch (Exception e) {
            System.out.print("Erreur : " + e);
        }
        cal.add(Calendar.DAY_OF_MONTH, -1);
        currentDate.setText(displayDateInString(cal.getTime()));
        displayDailyEvents();
    }

    private void nextCalendarDate()
    {
        try {
            mLayout.removeViewAt(eventIndex - 1);
        } catch (Exception e) {
            System.out.print("Erreur : " + e);
        }
        cal.add(Calendar.DAY_OF_MONTH, 1);
        currentDate.setText(displayDateInString(cal.getTime()));
        displayDailyEvents();
    }

    private String displayDateInString(Date mDate)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("d MMMM, yyyy", Locale.ENGLISH);
        return formatter.format(mDate);
    }

    private void displayDailyEvents()
    {
        Date calendarDate = cal.getTime();
        List<EventObjects> dailyEvent = mQuery.getAllFutureEvents(calendarDate);

        for(EventObjects eObject : dailyEvent)
        {
            Date eventDate = eObject.getDate();
            Date endDate = eObject.getEnd();
            String eventMessage = eObject.getMessage();

            int eventBlockHeight = getEventTimeFrame(eventDate, endDate);

            Log.d(TAG, "Height " + eventBlockHeight);

            displayEventSection(eventDate, eventBlockHeight, eventMessage);
        }
    }

    private int getEventTimeFrame(Date start, Date end)
    {
        long timeDifference = end.getTime() - start.getTime();

        Calendar mCal = Calendar.getInstance();
        mCal.setTimeInMillis(timeDifference);

        int hours = mCal.get(Calendar.HOUR);
        int minutes = mCal.get(Calendar.MINUTE);

        return (hours * 60) + ((minutes * 60) / 100);
    }

    private void displayEventSection(Date eventDate, int height, String message)
    {
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm", Locale.FRENCH);

        String displayValue = timeFormatter.format(eventDate);
        String[]hourMinutes = displayValue.split(":");

        int hours = Integer.parseInt(hourMinutes[0]);
        int minutes = Integer.parseInt(hourMinutes[1]);

        Log.d(TAG, "Hour value " + hours);
        Log.d(TAG, "Minutes value " + minutes);

        int topViewMargin = (hours * 60) + ((minutes * 60) / 100);

        Log.d(TAG, "Margin top " + topViewMargin);

        createEventView(topViewMargin, height, message);
    }

    private void createEventView(int topMargin, int height, String message)
    {
        TextView mEventView = new TextView(this.getActivity());

        RelativeLayout.LayoutParams lParam = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        lParam.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        lParam.topMargin = topMargin * 2;
        lParam.leftMargin = 24;

        mEventView.setLayoutParams(lParam);
        mEventView.setPadding(24, 0, 24, 0);
        mEventView.setHeight(height * 2);
        mEventView.setGravity(0x11);
        mEventView.setTextColor(Color.parseColor("#ffffff"));
        mEventView.setText(message);
        mEventView.setBackgroundColor(Color.parseColor("#3F51B5"));

        mLayout.addView(mEventView, eventIndex - 1);
    }
}
