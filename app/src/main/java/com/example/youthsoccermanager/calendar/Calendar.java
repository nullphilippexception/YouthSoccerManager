package com.example.youthsoccermanager.calendar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.gamedate.EMonth;
import com.example.youthsoccermanager.gamedate.GameDate;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;
import com.example.youthsoccermanager.todaysevents.TodaysEvents;
import com.example.youthsoccermanager.userhelplibrary.IHelpProvider;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Calendar extends AppCompatActivity implements IHelpProvider {
    private final int LL_TITLE_BAR = R.id.title_bar_calendar;
    private EMonth displayedMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        GameDate gameDate = new GameDate(7, EMonth.FEB); // IN REALITY; READ FROM MEMORY!
        displayedMonth = gameDate.getMonth();
        final String PAGE_TITLE = gameDate.getCurrentMonthAsString();
        TitleBarSetter.postTitleBar(getLayoutInflater().inflate(R.layout.title_bar, null),
                (LinearLayout)findViewById(LL_TITLE_BAR), PAGE_TITLE);
        Logger.getAnonymousLogger().log(Level.INFO, "Basic page loaded");
        displayCalendarDays(gameDate.getDay(), gameDate.getMonth());
    }

    public void help(View view) {

    }

    private void displayCalendarDays(int day, EMonth eMonth) {
        GameDate gameDate = new GameDate(day, eMonth); // day doesnt matter
        ((Button)findViewById(R.id.calendar_day31)).setVisibility(View.VISIBLE);
        ((Button)findViewById(R.id.calendar_day30)).setVisibility(View.VISIBLE);
        ((Button)findViewById(R.id.calendar_day29)).setVisibility(View.VISIBLE);
        if(gameDate.daysInMonth() < 31) {
            ((Button)findViewById(R.id.calendar_day31)).setVisibility(View.INVISIBLE);
            if(gameDate.daysInMonth() == 28) { // it is february
                ((Button)findViewById(R.id.calendar_day30)).setVisibility(View.INVISIBLE);
                ((Button)findViewById(R.id.calendar_day29)).setVisibility(View.INVISIBLE);
            }
        }
    }

    public void showDay(View view) {
        String day = ((Button)view).getText().toString();
        Intent intent = new Intent(this, CalendarDay.class);
        intent.putExtra("DAY", day);
        intent.putExtra("MONTH", displayedMonth.toString());
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void switchToNextMonth(View view) {
        if(displayedMonth.equals(EMonth.JUN)) {
            Toast.makeText(this, "Can only show calendar for this season", Toast.LENGTH_LONG).show();
        }
        else {
            displayedMonth = displayedMonth.getNextMonth();
            ((TextView)findViewById(R.id.title_bar_pagetitle)).setText(displayedMonth.toString());
            displayCalendarDays(1, displayedMonth); // day doesnt matter
        }
    }

    /*CRASH REPORT
    * This crashes when trying to go to previous mont hfrom december, FIX*/
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void switchToPreviousMonth(View view) {
        if(displayedMonth.equals(EMonth.JUL)) {
            Toast.makeText(this, "Can only show calendar for this season", Toast.LENGTH_LONG).show();
        }
        else {
            displayedMonth = displayedMonth.getPreviousMonth();
            ((TextView)findViewById(R.id.title_bar_pagetitle)).setText(displayedMonth.toString());
            displayCalendarDays(1, displayedMonth); // day doesnt matter
        }
    }


}
