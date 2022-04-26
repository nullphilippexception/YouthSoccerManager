package com.example.youthsoccermanager.personnelandfinance.personnel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;
import com.example.youthsoccermanager.mails.answers.MailAnswerJobOffer;
import com.example.youthsoccermanager.userhelplibrary.IHelpProvider;

import java.util.logging.Level;
import java.util.logging.Logger;

// THIS CLASS HAS A BAD PARENT ACTIVITY (SHOULD BE DIFFERENT ONES), MAKE THIS DYNAMCI?
public class PersonnelDisplay extends AppCompatActivity implements IHelpProvider {
    private final int LL_TITLE_BAR = R.id.title_bar_personnel_display;
    private final int MAIN_VIEW_BODY = R.layout.personnel_display;
    private final String PAGE_TITLE = "Personnel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(MAIN_VIEW_BODY);
        TitleBarSetter.postTitleBar(getLayoutInflater().inflate(R.layout.title_bar, null),
                (LinearLayout)findViewById(LL_TITLE_BAR), PAGE_TITLE);
        Logger.getAnonymousLogger().log(Level.INFO, "Basic page loaded");
    }

    public void help(View view) {
        // call help menu entry here
    }

    // CHECK WHEN THIS SHOULD BE POSSIBLE
    public void assignNewRole(View view) {
        Intent intent = new Intent(this, AssignNewPersonnelRole.class); // NOT REALLY GREAT NAMING HERE
        intent.putExtra("PERSONNEL_ID", getIntent().getIntExtra("PERSONNEL_ID", -1)); // BUG PRONE!
        startActivity(intent);
    }

    // CHECK WHEN THIS SHOULD BE POSSIBLE
    public void offerOrExtendContract(View view) {
        Intent intent = new Intent(this, MailAnswerJobOffer.class); // NOT REALLY GREAT NAMING HERE
        intent.putExtra("PERSONNEL_ID", getIntent().getIntExtra("PERSONNEL_ID", -1)); // BUG PRONE!
        startActivity(intent);
    }

    // CHECK WHEN THIS SHOULD BE POSSIBLE
    public void fireThisPersonnel(View view) {
        // DUMMY
        Toast.makeText(this, "This Personnel has been fired", Toast.LENGTH_LONG);
    }
}
