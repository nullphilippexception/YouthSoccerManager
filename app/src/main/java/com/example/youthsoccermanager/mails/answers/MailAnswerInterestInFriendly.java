package com.example.youthsoccermanager.mails.answers;

import static android.view.View.INVISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;
import com.example.youthsoccermanager.mails.WriteMail;
import com.example.youthsoccermanager.userhelplibrary.IHelpProvider;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MailAnswerInterestInFriendly extends AppCompatActivity implements IHelpProvider {
    private final int LL_TITLE_BAR = R.id.title_bar_mail_contacts_friendly_interest;
    private final int MAIN_VIEW_BODY = R.layout.mail_contacts_friendly_interest;
    private final String PAGE_TITLE = "Chat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(MAIN_VIEW_BODY);
        TitleBarSetter.postTitleBar(getLayoutInflater().inflate(R.layout.title_bar, null),
                (LinearLayout)findViewById(LL_TITLE_BAR), PAGE_TITLE);
        Logger.getAnonymousLogger().log(Level.INFO, "Basic page loaded");
        computeInterest();
    }

    /**
     * Posts Dialogue that provides help on current screen to user
     * @param view
     */
    public void help(View view) {

    }

    public void computeInterest() {
        /*actual decision will be computed by gamelogic.InterestInFriendly.java*/
        boolean interestInFriendly = true; // DUMMY -> COMPUTE BY CLASS MENTIONED ABOVE
        if(interestInFriendly) {
            ((ImageView)findViewById(R.id.mail_contacts_friendly_interest_schedule_answerimg))
                    .setBackgroundResource(R.mipmap.mail_ask_friendly_reply_yes_foreground);
            ((Button)findViewById(R.id.mail_contacts_friendly_interest_schedule_button)).setOnClickListener(
                    (View v) -> {
                        boolean success = scheduleFriendlyDate(((EditText)findViewById
                                (R.id.mail_contacts_friendly_interest_schedule_entry)).getText().toString());
                        if(success) {
                            Intent intent = new Intent(this, WriteMail.class);
                            startActivity(intent);
                        }
                    }
            );
        }
        else {
            ((ImageView)findViewById(R.id.mail_contacts_friendly_interest_schedule_answerimg))
                    .setBackgroundResource(R.mipmap.mail_ask_friendly_reply_no_foreground);
            ((TextView)findViewById(R.id.mail_contacts_friendly_interest_schedule_info)).setVisibility(INVISIBLE);
            ((EditText)findViewById(R.id.mail_contacts_friendly_interest_schedule_entry)).setVisibility(INVISIBLE);
            ((Button)findViewById(R.id.mail_contacts_friendly_interest_schedule_button)).setVisibility(INVISIBLE);
        }
    }

    public boolean scheduleFriendlyDate(String date) {
        /*
        * check whether date is legit, make error toast if not and return wrong
        * */
        return false;
    }
}
