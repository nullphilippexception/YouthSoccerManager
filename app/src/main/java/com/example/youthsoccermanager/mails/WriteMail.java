package com.example.youthsoccermanager.mails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;
import com.example.youthsoccermanager.mails.answers.MailAnswerAvailablePlayers;
import com.example.youthsoccermanager.mails.answers.MailAnswerInterestInFriendly;
import com.example.youthsoccermanager.mails.answers.MailAnswerJobOffer;
import com.example.youthsoccermanager.userhelplibrary.IHelpProvider;

import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteMail extends AppCompatActivity implements IHelpProvider {
    private final int LL_TITLE_BAR = R.id.title_bar_mail_contacts_write;
    private final int MAIN_VIEW_BODY = R.layout.mail_contacts_write;
    private final String PAGE_TITLE = "Write Mail";
    String contactedCoachId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        contactedCoachId = getIntent().getStringExtra("PERSONNEL_ID");
        super.onCreate(savedInstanceState);
        setContentView(MAIN_VIEW_BODY);
        TitleBarSetter.postTitleBar(getLayoutInflater().inflate(R.layout.title_bar, null),
                (LinearLayout)findViewById(LL_TITLE_BAR), PAGE_TITLE);
        Logger.getAnonymousLogger().log(Level.INFO, "Basic page loaded");
    }

    @Override
    public void help(View view) {

    }

    public void askForPlayers(View view) {
        Intent intent = new Intent(this, MailAnswerAvailablePlayers.class);
        intent.putExtra("PERSONNEL_ID", contactedCoachId);
        startActivity(intent);
    }

    public void askForFriendly(View view) {
        Intent intent = new Intent(this, MailAnswerInterestInFriendly.class);
        intent.putExtra("PERSONNEL_ID", contactedCoachId);
        startActivity(intent);
    }

    public void offerPersonnelJob(View view) {
        Intent intent = new Intent(this, MailAnswerJobOffer.class);
        intent.putExtra("PERSONNEL_ID", contactedCoachId);
        startActivity(intent);
    }
}
