package com.example.youthsoccermanager.mails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.dataclasses.admin.Mail;
import com.example.youthsoccermanager.gamecreation.database.GameDatabase;
import com.example.youthsoccermanager.gamecreation.database.MailDAO;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;
import com.example.youthsoccermanager.userhelplibrary.IHelpProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailDisplay extends AppCompatActivity implements IHelpProvider {
    private final int LL_TITLE_BAR = R.id.title_bar_mail_display;
    private final int MAIN_VIEW_BODY = R.layout.mail_display;
    private final String PAGE_TITLE = "Mails";
    String mailId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(MAIN_VIEW_BODY);
        TitleBarSetter.postTitleBar(getLayoutInflater().inflate(R.layout.title_bar, null),
                (LinearLayout)findViewById(LL_TITLE_BAR), PAGE_TITLE);
        Logger.getAnonymousLogger().log(Level.INFO, "Basic page loaded");
        mailId = getIntent().getStringExtra("MAIL_ID");
        displayMail();
    }

    public void help(View view) {

    }

    public void deleteThisMail(View view) {
        Mail mail = GameDatabase.getDB().mailDao().getMailById(mailId);
        GameDatabase.getDB().mailDao().delete(mail);
        Toast.makeText(this, "E-Mail deleted successfully!", Toast.LENGTH_LONG); // NOT DISPLAYED?
        Intent intent = new Intent(this, Mails.class);
        startActivity(intent);
    }

    private void displayMail() {
        MailDAO mailDAO = GameDatabase.getDB().mailDao();
        ((TextView)findViewById(R.id.mail_display_sender)).setText(mailDAO.getMailById(mailId).getSender());
        ((TextView)findViewById(R.id.mail_display_date)).setText(mailDAO.getMailById(mailId).getDate());
        ((TextView)findViewById(R.id.mail_display_title)).setText(mailDAO.getMailById(mailId).getTitle());
        ((TextView)findViewById(R.id.mail_display_text)).setText(mailDAO.getMailById(mailId).getText());
    }
}
