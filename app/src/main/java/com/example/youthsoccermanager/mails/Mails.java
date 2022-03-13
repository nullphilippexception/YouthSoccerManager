package com.example.youthsoccermanager.mails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;
import com.example.youthsoccermanager.userhelplibrary.IHelpProvider;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Mails extends AppCompatActivity implements IHelpProvider {
    private final int LL_TITLE_BAR = R.id.title_bar_mails;
    private final String PAGE_TITLE = "Mails";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mails);
        TitleBarSetter.postTitleBar(getLayoutInflater().inflate(R.layout.title_bar, null),
                (LinearLayout)findViewById(LL_TITLE_BAR), PAGE_TITLE);
        Logger.getAnonymousLogger().log(Level.INFO, "Basic page loaded");
        loadInboxMails();
    }

    public void help(View view) {

    }

    private void loadInboxMails() {
        /*
        * LOAD MAILS FROM DATABASE
        */
    }

    public void goToContacts(View view) {
        Intent intent = new Intent(this, MailContacts.class);
        startActivity(intent);
    }
}
