package com.example.youthsoccermanager.mails.answers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;
import com.example.youthsoccermanager.personnelandfinance.personnel.PersonnelDisplay;
import com.example.youthsoccermanager.userhelplibrary.IHelpProvider;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is part of the Mail domain. It is called when the user decides to offer a job to the Mail contact.
 * The user can enter a contract length and salary and the class then decides whether the mail contact will accept the job,
 * depending on the offer parameters as well as the contact's skill.
 * @author Philipp S.
 */
public class MailAnswerJobOffer extends AppCompatActivity implements IHelpProvider {
    private final int LL_TITLE_BAR = R.id.title_bar_personnel_contract_negotiation;
    private final int MAIN_VIEW_BODY = R.layout.personnel_contract_negotiation;
    private final String PAGE_TITLE = "Chat";
    int contactedCoachId;

    /**
     * onCreate is called when the activity is created
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(MAIN_VIEW_BODY);
        TitleBarSetter.postTitleBar(getLayoutInflater().inflate(R.layout.title_bar, null),
                (LinearLayout)findViewById(LL_TITLE_BAR), PAGE_TITLE);
        contactedCoachId = Integer.parseInt(getIntent().getStringExtra("PERSONNEL_ID")); // to check with database whether there is job interest
        Logger.getAnonymousLogger().log(Level.INFO, "Basic page loaded");
    }

    /**
     * Posts Dialogue that provides help on current screen to user
     * @param view the help button that is pressed by user
     */
    public void help(View view) {

    }

    /**
     * Pulls offered contract length and salary from user screen and then computes wheter offer will
     * be accepted based on these parameters, as well as based on Personnel-subtype the offer is made to's skill's
     * @param view when main button of screen is pressed, indicating that user actually makes the offer
     */
    public void makeJobOffer(View view) {
        try {
            int contractLength = Integer.parseInt(((EditText)view.findViewById(R.id.personnel_contract_neg_contract_length)).getText().toString());
            int salary = Integer.parseInt(((EditText)view.findViewById(R.id.personnel_contract_neg_salary)).getText().toString());

            if(jobOfferAccepted(salary, contractLength)) {
                addToPersonnel(salary, contractLength);
                Toast.makeText(this, "The offer was successful!", Toast.LENGTH_LONG);
            }
            else {
                Toast.makeText(this, "The offer failed!", Toast.LENGTH_LONG);
            }
        }
        catch(NumberFormatException nfe) {
            Toast.makeText(this, "Please enter numbers only!", Toast.LENGTH_LONG);
            Logger.getAnonymousLogger().log(Level.WARNING, "User tried entering non-valid number");
        }
    }

    /**
     * This method opens the PersonnelDisplay screen, which offers more details on the selected personnel
     * @param view skill details button
     */
    public void getInfoOnPersonnel(View view)
    {
        Intent intent = new Intent(this, PersonnelDisplay.class);
        intent.putExtra("PERSONNEL_ID", contactedCoachId);
        startActivity(intent);
    }
    /**
     * This method computes whether the job offer made by the user will be accepted. To do so, the offer parameters get passed
     * to the method and the personnel data is fetched from the database.
     * @param salary salary offered by the user
     * @param contractLength contract length offered by the user
     * @return true if the job offer is accepted and personnel subtype switches to user team, false if not
     */
    private boolean jobOfferAccepted(int salary, int contractLength) {
        // fetch personne data from database, compute whether offer is accepted or not
        return true; // CHANGE
    }

    private void addToPersonnel(int salary, int contractLength) {
        // fetch personnel subtype from contacts database, delete there and paste into my personnel database
    }
}
