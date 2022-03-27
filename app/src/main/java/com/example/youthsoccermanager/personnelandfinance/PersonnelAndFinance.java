package com.example.youthsoccermanager.personnelandfinance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;
import com.example.youthsoccermanager.personnelandfinance.finance.BankAccount;
import com.example.youthsoccermanager.personnelandfinance.finance.FinancialDeals;
import com.example.youthsoccermanager.personnelandfinance.personnel.SignAvailablePersonnel;
import com.example.youthsoccermanager.personnelandfinance.personnel.ViewPersonnel;
import com.example.youthsoccermanager.userhelplibrary.IHelpProvider;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonnelAndFinance extends AppCompatActivity implements IHelpProvider {
    private final int LL_TITLE_BAR = R.id.title_bar_personnel_finance;
    private final int MAIN_VIEW_BODY = R.layout.personnel_finance;
    private final String PAGE_TITLE = "Personnel & Finance";

    /**
     * onCreate is called when the activity is created
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(MAIN_VIEW_BODY);
        TitleBarSetter.postTitleBar(getLayoutInflater().inflate(R.layout.title_bar, null),
                (LinearLayout)findViewById(LL_TITLE_BAR), PAGE_TITLE);
        Logger.getAnonymousLogger().log(Level.INFO, "Basic page loaded");
        setEmployeesAndSalaryDisplay();
    }

    public void help(View view) {

    }

    private void setEmployeesAndSalaryDisplay() {
        // fetch data from database and set it on screen
    }

    public void viewPersonnel(View view) {
        Intent intent = new Intent(this, ViewPersonnel.class);
        startActivity(intent);
    }

    public void signPersonnel(View view) {
        Intent intent = new Intent(this, SignAvailablePersonnel.class);
        startActivity(intent);
    }

    public void showBankAccount(View view) {
        Intent intent = new Intent(this, BankAccount.class);
        startActivity(intent);
    }

    public void showFinancialDeals(View view) {
        Intent intent = new Intent(this, FinancialDeals.class);
        startActivity(intent);
    }
}
