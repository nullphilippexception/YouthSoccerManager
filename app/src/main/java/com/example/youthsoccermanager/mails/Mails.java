package com.example.youthsoccermanager.mails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.dataclasses.admin.Mail;
import com.example.youthsoccermanager.gamecreation.database.GameDatabase;
import com.example.youthsoccermanager.layouthelper.MailPreviewCreator;
import com.example.youthsoccermanager.layouthelper.PersonPreviewCreator;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;
import com.example.youthsoccermanager.userhelplibrary.IHelpProvider;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mails extends AppCompatActivity implements IHelpProvider {
    private final int LL_TITLE_BAR = R.id.title_bar_mails;
    private final String PAGE_TITLE = "Mails";
    List<Mail> inboxMails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mails);
        TitleBarSetter.postTitleBar(getLayoutInflater().inflate(R.layout.title_bar, null),
                (LinearLayout)findViewById(LL_TITLE_BAR), PAGE_TITLE);
        Logger.getAnonymousLogger().log(Level.INFO, "Basic page loaded");
        inboxMails = new ArrayList<>();
        loadInboxMails();
    }

    public void help(View view) {

    }

    private void loadInboxMails() {
        inboxMails = GameDatabase.getDB().mailDao().getAll();
        int idCount = 0;
        Logger.getAnonymousLogger().log(Level.INFO, "inboxMails size: " + inboxMails.size());
        for(Mail mail: inboxMails) {
            MailPreviewCreator.createMailPreview(getLayoutInflater().inflate(R.layout.mail_preview, null),
                    (LinearLayout)findViewById(R.id.mails_inbox_list), mail, idCount);
            idCount++;
        }
        Logger.getAnonymousLogger().log(Level.INFO, "Final idCount: " + idCount);
    }

    public void lookAtMail(View view) {
        String mailId = inboxMails.get(view.getId()).getMailId();
        Intent intent = new Intent(this, MailDisplay.class);
        intent.putExtra("MAIL_ID", mailId);
        startActivity(intent);
    }

    public void goToContacts(View view) {
        Intent intent = new Intent(this, MailContacts.class);
        startActivity(intent);
    }
}
