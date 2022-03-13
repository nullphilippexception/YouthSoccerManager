package com.example.youthsoccermanager.mails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.dataclasses.attributeenums.EPersonnelPreviewValues;
import com.example.youthsoccermanager.layouthelper.PersonPreviewCreator;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;
import com.example.youthsoccermanager.teams.PlayerDisplay;
import com.example.youthsoccermanager.userhelplibrary.IHelpProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailContacts extends AppCompatActivity implements IHelpProvider {
    private final int LL_TITLE_BAR = R.id.title_bar_mail_contacts;
    private final int MAIN_VIEW_BODY = R.layout.mail_contacts;
    private final String PAGE_TITLE = "Mail Contacts";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(MAIN_VIEW_BODY);
        TitleBarSetter.postTitleBar(getLayoutInflater().inflate(R.layout.title_bar, null),
                (LinearLayout)findViewById(LL_TITLE_BAR), PAGE_TITLE);
        Logger.getAnonymousLogger().log(Level.INFO, "Basic page loaded");
        getContactsFromDB();
    }

    public void help(View view) {

    }

    // DUMMY METHOD FILL OUT WITH REAL STUFF
    public void getContactsFromDB() {
        int testPersonnelId = 500;
        Map<EPersonnelPreviewValues, String> personnelData = new HashMap<>();
        personnelData.put(EPersonnelPreviewValues.NAME, "Testo Testcoach");
        personnelData.put(EPersonnelPreviewValues.TITLE, "Head Coach");
        personnelData.put(EPersonnelPreviewValues.AFFILIATION, "Red White Munich U15");
        PersonPreviewCreator.createMailContactsPreview(getLayoutInflater().inflate(R.layout.mail_contacts_preview, null),
                (LinearLayout)findViewById(R.id.mail_contacts_body), personnelData, testPersonnelId);
        enableButtonClick(testPersonnelId);
    }
    
    public void enableButtonClick(int personnelId) {
        ((Button)findViewById(personnelId)).setOnClickListener((View v) -> {
            Intent intent = new Intent(this, WriteMail.class);
            intent.putExtra("PERSONNEL_ID", String.valueOf(personnelId));
            startActivity(intent);
        });
    }
}
