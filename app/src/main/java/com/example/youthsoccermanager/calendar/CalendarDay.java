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

/**
 * CalendarDay is an activity that is called when the user wants to see the details of one specific day. It fetches
 * the events for the desired day from the database and displays them on the screen.
 * @author Philipp S.
 */
public class CalendarDay extends AppCompatActivity implements IHelpProvider {
    private final int LL_TITLE_BAR = R.id.title_bar_calendar_day;
    private GameDate displayedDate;

    /**
     * onCreate is called when the activity is created
     */
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

    /**
     * help is called when the Questionmark-button of the title bar is pressed by the user.
     * Then a dialog with helpful instructions is shown.
     * @param view is the button that is pressed
     */
    public void help(View view) {

    }

    /**
     * loadThisDaysEntries is always called by the onCreate method, it displays all the events that are stored
     * in the event database for the given date
     * @param gameDate date that the database is supposed to be searched for
     */
    private void loadThisDaysEntries(GameDate gameDate) {
        /*
        * LOAD THIS DAYS ENTRIES FROM DB
        */
    }

}
