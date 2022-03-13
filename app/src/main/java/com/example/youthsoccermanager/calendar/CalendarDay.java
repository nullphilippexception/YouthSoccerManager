package com.example.youthsoccermanager.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.gamedate.EMonth;
import com.example.youthsoccermanager.gamedate.GameDate;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;
import com.example.youthsoccermanager.userhelplibrary.IHelpProvider;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CalendarDay extends AppCompatActivity implements IHelpProvider {
    private final int LL_TITLE_BAR = R.id.title_bar_calendar_day;
    private GameDate displayedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_day);
        final int day = Integer.parseInt(getIntent().getStringExtra("DAY"));
        final EMonth month = EMonth.valueOf(getIntent().getStringExtra("MONTH"));
        displayedDate = new GameDate(day, month);
        final String PAGE_TITLE = displayedDate.getDateAsString();
        TitleBarSetter.postTitleBar(getLayoutInflater().inflate(R.layout.title_bar, null),
                (LinearLayout)findViewById(LL_TITLE_BAR), PAGE_TITLE);
        Logger.getAnonymousLogger().log(Level.INFO, "Basic page loaded");
        loadThisDaysEntries(displayedDate);
    }

    public void help(View view) {

    }

    private void loadThisDaysEntries(GameDate gameDate) {
        /*
        * LOAD THIS DAYS ENTRIES FROM DB
        */
    }

}
